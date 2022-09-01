package test.kitchentask;

import businesslogic.BusinessLogicException;
import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.procedure.Instruction;
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
            KitchenSheet sheet = catERing.getKitchenTaskManager().createKitchenSheet("Primo foglio di prova", event, service);
            System.out.println("Foglio autogenerato per servizio \"" + service.getName() + "\" associato all'evento \"" + event.getName() + "\": " + sheet);

            System.out.println("\nTEST ADD KITCHEN TASK");
            ObservableList<Instruction> recipes = CatERing.getInstance().getInstructionManager().getInstructions();
            KitchenTask preparePaniniLatte = catERing.getKitchenTaskManager().addKitchenTask(recipes.get(11));
            KitchenTask prepareBigneFarciti = catERing.getKitchenTaskManager().addKitchenTask(recipes.get(14));
            KitchenTask preparePizzette = catERing.getKitchenTaskManager().addKitchenTask(recipes.get(15));
            System.out.println("Foglio con nuovi tasks: \"Panini al latte\", \"Bigne farciti\", \"Pizzette\"" + sheet);

            System.out.println("\nTEST DELETE KITCHEN TASK");
            catERing.getKitchenTaskManager().deleteKitchenTask(prepareBigneFarciti);
//            catERing.getKitchenTaskManager().deleteKitchenTask(preparePizzette); //commentare per vedere che resta aggiunto nel db
            catERing.getKitchenTaskManager().deleteKitchenTask(preparePaniniLatte);
//			System.out.println("Foglio con tasks \"Panini al latte\", \"Bigne farciti\", \"Pizzette\" rimossi: "+sheet);
            System.out.println("Foglio con tasks \"Panini al latte\", \"Bigne farciti\" rimossi: "+sheet); //pizzette rimaste


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
