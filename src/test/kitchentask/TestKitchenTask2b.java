package test.kitchentask;

import businesslogic.BusinessLogicException;
import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.procedure.Procedure;
import javafx.collections.ObservableList;

public class TestKitchenTask2b {

    public static void main(String[] args) throws UseCaseLogicException {
        System.out.println("TEST FAKE LOGIN");
        CatERing catERing = CatERing.getInstance();
        catERing.getUserManager().fakeLogin("Lidia");
        System.out.println(catERing.getUserManager().getCurrentUser());

        EventInfo event = EventInfo.getEventByName("Compleanno di Manuela");
        ServiceInfo service = event.getFirstService();

        try {
            System.out.println("\nTEST CREATE SHEET");
            KitchenSheet sheet = catERing.getKitchenTaskManager().createKitchenSheet("Convegno Agile Community", event, service);
            System.out.println("Foglio autogenerato per servizio \"" + service.getName() + "\" associato all'evento \"" + event.getName() + "\": " + sheet);

            System.out.println("\nTEST ADD KITCHEN TASK");
            ObservableList<Procedure> recipes = CatERing.getInstance().getProcedureManager().getProcedures();
            KitchenTask task1 = catERing.getKitchenTaskManager().addKitchenTask(recipes.get(11));
            KitchenTask task2 = catERing.getKitchenTaskManager().addKitchenTask(recipes.get(14));
            KitchenTask task3 = catERing.getKitchenTaskManager().addKitchenTask(recipes.get(15));
            System.out.printf("Foglio con nuovi tasks: \"%s\", \"%s\", \"%s\" %s", task1, task2, task3, sheet);

            System.out.println("\nTEST DELETE KITCHEN TASK");
            catERing.getKitchenTaskManager().deleteKitchenTask(task1);
            catERing.getKitchenTaskManager().deleteKitchenTask(task3);
            System.out.printf("Foglio con rimossi tasks: \"%s\", \"%s\", %s", task1,  task3, sheet);


            System.out.println("\nTEST RESTORE KITCHEN TASK");
            catERing.getKitchenTaskManager().restoreOriginalTasks();
            System.out.println("Foglio ripristinato: " + sheet);

        } catch (UseCaseLogicException e) {
            System.out.println("Errore di logica nello use case");
        } catch (BusinessLogicException e) {
            throw new RuntimeException(e);
        }
    }
}
