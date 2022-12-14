package businesslogic.kitchentask;

import businesslogic.UseCaseLogicException;
import businesslogic.procedure.Procedure;
import businesslogic.procedure.Recipe;
import businesslogic.shift.Shift;
import businesslogic.user.Cook;
import businesslogic.user.User;
import persistence.PersistenceManager;
import persistence.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KitchenTask {
    private final Procedure procedure;
    private Shift shift;
    private Cook cook;
    private int minutes;
    private int quantity;
    private boolean isCompleted;
    int id;

    KitchenTask(Procedure procedure) {
        this.procedure = procedure;
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        return "KitchenTask{" +
                "procedure=" + procedure +
                ", shift=" + shift +
                ", cook=" + cook +
                ", minutes1=" + minutes +
                ", quantity=" + quantity +
                ", isCompleted=" + isCompleted +
                ", id=" + id +
                "}\n";
    }

    void assign(Shift shift, Cook cook, int minutes, int quantity) throws UseCaseLogicException {
        if ((shift != null && shift.isCompleted()) || (cook != null && !cook.isAvailableFor(shift))) {
            throw new UseCaseLogicException();
        } else {
            this.shift = shift;
            this.cook = cook;
            this.minutes = minutes;
            this.quantity = quantity;
        }
    }

    void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public Shift getShift() {
        return shift;
    }

    public User getCook() {
        return cook;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getQuantity() {
        return quantity;
    }

    public static ArrayList<KitchenTask> loadTasksFor(int sheetId) {
        ArrayList<KitchenTask> result = new ArrayList<>();
        String query = "SELECT * FROM KitchenTasks WHERE id = " + sheetId +
                " ORDER BY position";
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                Procedure procedure = Recipe.loadRecipeById(rs.getInt("procedure_id"));
                KitchenTask task = new KitchenTask(procedure);
                task.id = rs.getInt("id");
                task.minutes = rs.getInt("minutes");
                task.quantity = rs.getInt("quantity");
                task.isCompleted = rs.getInt("completed") != 0;
                task.shift = new Shift(rs.getString("shift_when"));
                task.cook = User.loadUserById(rs.getInt("cook_id")).asCook();
                result.add(task);
            }
        });
        return result;
    }

    public static void addTask(KitchenSheet sheet, KitchenTask taskToAdd, int posInKitchenSheet) {
        String query = "INSERT INTO catering.KitchenTasks (completed, kitchen_sheet_id, preparation_id, position) VALUES (" +
                taskToAdd.isCompleted() + ", " +
                sheet.getId() + ", " +
                taskToAdd.getProcedure().getId() + ", " +
                posInKitchenSheet +
                ");";
        PersistenceManager.executeUpdate(query);
        taskToAdd.id = PersistenceManager.getLastId();
    }

    public static void addAllTasks(KitchenSheet sheet) {
        int pos = 0;
        for (KitchenTask task : sheet.getKitchenTasks()) {
            addTask(sheet, task, pos);
            pos++;
        }
    }

    public static void deleteTask(KitchenTask task) {
        String query = "DELETE FROM KitchenTasks WHERE id = " + task.id;
        PersistenceManager.executeUpdate(query);
    }

    public static void deleteAllTasks(KitchenSheet sheet) {
        for (KitchenTask task : sheet.getKitchenTasks()) {
            deleteTask(task);
        }
    }

    public static void assignTask(KitchenTask task) {
        String assign = "UPDATE catering.KitchenTasks SET minutes = '" + task.minutes +
                "', quantity = '" + task.quantity +
                "', cook_id = " + (task.cook == null ? null : task.cook.getId()) +
                ", shift_when = '" + (task.shift == null ? null : task.shift.getDatetime()) +
                "' WHERE id = " + task.id + ";";
        PersistenceManager.executeUpdate(assign);
    }

    public static void setTaskCompleteness(KitchenTask task, boolean isCompleted) {
        String assign = "UPDATE catering.KitchenTasks SET completed = " + (isCompleted ? 1 : 0) +
                " WHERE id = " + task.id + ";";
        PersistenceManager.executeUpdate(assign);
    }

}
