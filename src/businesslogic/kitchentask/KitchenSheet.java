package businesslogic.kitchentask;

import businesslogic.BusinessLogicException;
import businesslogic.UseCaseLogicException;
import businesslogic.event.ServiceInfo;
import businesslogic.menu.Menu;
import businesslogic.preparation.Procedure;
import businesslogic.preparation.Recipe;
import businesslogic.shift.Shift;
import businesslogic.user.Cook;
import persistence.PersistenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class KitchenSheet {
    private String title;
    private int id;
    private ServiceInfo service;
    private ArrayList<KitchenTask> kitchenTasks;

    public KitchenSheet(String title, ServiceInfo service) {
        this.title = title;
        this.service = service;
        this.kitchenTasks = new ArrayList<>();

        restoreOriginalTasks();
    }


    @Override
    public String toString() {
        return "KitchenSheet{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", service=" + service +
                ", \nkitchenTasks=\n" + kitchenTasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KitchenSheet that = (KitchenSheet) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public KitchenTask addKitchenTask(Procedure procedure) {
        KitchenTask kitchenTask = new KitchenTask(procedure);
        procedure.addAssignedTask(kitchenTask);
        kitchenTasks.add(kitchenTask);
        return kitchenTask;
    }

    public List<KitchenTask> getKitchenTasks() {
        return kitchenTasks;
    }

    public static int getIdFromTitleAndServiceId(String title, int serviceId) {
        AtomicInteger res = new AtomicInteger(-1);
        String query = "SELECT id FROM catering.KitchenSheets WHERE title = '" + title + "' and service_id = " + serviceId;
        PersistenceManager.executeQuery(query, rs -> {
            res.set(rs.getInt("id"));
        });
        return res.get();
    }

    public static int getIdFromServiceId(int serviceId) {
        AtomicInteger res = new AtomicInteger(-1);
        String sheetIdFind = "SELECT id FROM catering.KitchenSheets WHERE service_id = " + serviceId;
        PersistenceManager.executeQuery(sheetIdFind, rs -> {
            res.set(rs.getInt("id"));
        });
        return res.get();
    }

    static public KitchenSheet loadSheetInfoByTitle(String title, ServiceInfo service) throws BusinessLogicException {
        int idFromTitle = getIdFromTitleAndServiceId(title, service.getId());
        if (idFromTitle < 0) {
            throw new BusinessLogicException("Il foglio \"" + title + "\" non è stato trovato");
        }
        KitchenSheet sheet = new KitchenSheet(title, service);
        sheet.id = idFromTitle;
        sheet.kitchenTasks = KitchenTask.loadTasksFor(sheet.id);
        return sheet;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void deleteKitchenTask(KitchenTask kitchenTask) {
        kitchenTask.getInstruction().removeAssignedTask(kitchenTask);
        kitchenTasks.remove(kitchenTask);
    }

    public void restoreOriginalTasks() {
        kitchenTasks.clear();
        Menu menu = service.getMenu();
        ArrayList<Recipe> recipes = menu.getRecipes();
        List<Procedure> procedures = Procedure.getInstructionsOfRecipes(recipes);
        for (Procedure procedure : procedures) {
            KitchenTask task = new KitchenTask(procedure);
            kitchenTasks.add(task);
        }
    }

    public void moveTask(KitchenTask kitchenTask, int position) {
        kitchenTasks.remove(kitchenTask);
        kitchenTasks.add(position, kitchenTask);
    }

    public void assignTask(KitchenTask kitchenTask, Shift shift, Cook cook, int minutes, int quantity) throws UseCaseLogicException {
        kitchenTasks.get(kitchenTasks.indexOf(kitchenTask)).assign(shift, cook, minutes, quantity);
    }

    public void setKitchenTaskCompleted(KitchenTask kitchenTask, boolean isCompleted) {
        kitchenTasks.get(kitchenTasks.indexOf(kitchenTask)).setCompleted(isCompleted);
    }

    //Persistence
    public static void saveNewSheet(KitchenSheet sheet) {
        String sheetInsert = "INSERT INTO catering.KitchenSheets (title, service_id) VALUES (" +
                "'" + PersistenceManager.escapeString(sheet.title) + "', " +
                sheet.service.getId() +
                ");";
        PersistenceManager.executeUpdate(sheetInsert);
        sheet.id = PersistenceManager.getLastId();

        for (KitchenTask task : sheet.kitchenTasks)
            KitchenTask.addTask(sheet, task, sheet.kitchenTasks.indexOf(task));
    }

    public static void addTask(KitchenSheet sheet, KitchenTask task, int position) {
        String secInsert = "INSERT INTO catering.KitchenTasks (completed, kitchen_sheet_id, preparation_id, position) VALUES (" +
                task.isCompleted() + ", " +
                sheet.getId() + ", " +
                task.getInstruction().getId() + ", " +
                position +
                ");";
        PersistenceManager.executeUpdate(secInsert);
        task.id = PersistenceManager.getLastId();
    }

    public static void rearrangeTask(KitchenSheet sheet) {
        for (int newPos = 0; newPos < sheet.kitchenTasks.size(); newPos++) {
            String changePosition = "UPDATE catering.KitchenTasks SET position = " + newPos + " WHERE id = " + sheet.kitchenTasks.get(newPos).id;
            PersistenceManager.executeUpdate(changePosition);
        }

    }

    public static void restoreSheet(KitchenSheet sheet) {
        KitchenTask.deleteAllTasks(sheet);
        KitchenTask.addAllTasks(sheet);
    }
}
