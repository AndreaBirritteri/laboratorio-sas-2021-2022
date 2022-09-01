package test.kitchentask;

import businesslogic.BusinessLogicException;
import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.procedure.Recipe;
import businesslogic.shift.Shift;
import businesslogic.user.Chef;
import businesslogic.user.Cook;
import businesslogic.user.User;

public class TestKitchenTask1a {
    public static void main(String[] args) {
        try {
            System.out.println("TEST FAKE LOGIN");
            CatERing catERing = CatERing.getInstance();
            catERing.getUserManager().fakeLogin("Lidia");
            System.out.println(catERing.getUserManager().getCurrentUser());

            EventInfo event = EventInfo.getEventByName("Compleanno di Manuela");
            System.out.println(event);

            System.out.println("\nTEST GET SERVICE BY EVENT ID");
            ServiceInfo service = event.getFirstService();
            System.out.println(service);


            System.out.println("\nTEST OPEN EXISTING SHEET");
            KitchenSheet sheetToOpen = new KitchenSheet("Convegno Agile Community", service);
            KitchenSheet sheet = catERing.getKitchenTaskManager().chooseKitchenSheet(sheetToOpen, event, service);
            System.out.println("Foglio esistente per servizio \"" + service.getName() + "\" associato all'evento \"" + event.getName() + "\": " + sheet);

            System.out.println("\nTEST ADD KITCHEN TASK");
            KitchenTask preparePizza = catERing.getKitchenTaskManager().addKitchenTask(new Recipe("pizza"));
            KitchenTask preparePollo = catERing.getKitchenTaskManager().addKitchenTask(new Recipe("pollo"));
            KitchenTask preparePesce = catERing.getKitchenTaskManager().addKitchenTask(new Recipe("pesce"));
            KitchenTask preparePesto = catERing.getKitchenTaskManager().addKitchenTask(new Recipe("pesto"));
            KitchenTask prepareSpaghetti = catERing.getKitchenTaskManager().addKitchenTask(new Recipe("spaghetti"));
            System.out.println("Foglio con nuovo task \"spaghetti\": " + sheet);

            System.out.println("\nTEST DELETE KITCHEN TASK");
            catERing.getKitchenTaskManager().deleteKitchenTask(prepareSpaghetti);
            System.out.println("Foglio con task \"spaghetti\" rimosso: " + sheet);

            System.out.println("\nTEST MOVE KITCHEN TASK");
            int firstPosition = 0;
            KitchenTask firstTask = sheet.getKitchenTasks().get(firstPosition);
            int newPosition = 2;
            System.out.println("Spostiamo il " + firstPosition + " task \"" + firstTask.getProcedure() + "\" in posizione " + newPosition);
            catERing.getKitchenTaskManager().moveTask(firstTask, newPosition);
            System.out.println("Foglio con task spostato: " + sheet);


            System.out.println("\nTEST ASSIGN VALUES TO FIRST TASK");
            int marinellaID = 4;
            User cookMarinella = User.loadUserById(marinellaID);
            Shift tuesdayAfternoonShift = new Shift("Martedi ore 09:00");
            cookMarinella.addAvailabilityFor(tuesdayAfternoonShift);
            int minutes = 50;
            int quantity = 6;
            firstTask = sheet.getKitchenTasks().get(firstPosition);
            System.out.printf("Assegniamo al primo task il cuoco: %s, nel turno: %s, con durata: %s e quantita': %s%n", cookMarinella.getUserName(), tuesdayAfternoonShift.getDatetime(), minutes, quantity);
            catERing.getKitchenTaskManager().assignTask(firstTask, tuesdayAfternoonShift, cookMarinella, minutes, quantity);
            System.out.println("Foglio con primo task assegnato: " + sheet);


            System.out.println("\nTEST SET FIRST TASK COMPLETED");
            catERing.getKitchenTaskManager().specifyCompletedTask(firstTask);
            System.out.println("Foglio con primo task completato: " + sheet);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } catch (BusinessLogicException e) {
            throw new RuntimeException(e);
        }
    }
}
