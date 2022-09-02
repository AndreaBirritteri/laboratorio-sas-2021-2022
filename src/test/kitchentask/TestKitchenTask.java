package test.kitchentask;

import businesslogic.BusinessLogicException;
import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.preparation.Instruction;
import businesslogic.shift.Shift;
import businesslogic.user.User;

import java.util.List;

public class TestKitchenTask {
    public static void main(String[] args) {
        try {
            System.out.println("TEST FAKE LOGIN");
            CatERing catERing = CatERing.getInstance();
            catERing.getUserManager().fakeLogin("Lidia");
            System.out.println(catERing.getUserManager().getCurrentUser());

//        System.out.println("\nTEST GET EVENT BY NAME");
            EventInfo event = EventInfo.getEventByName("Compleanno di Manuela");
//        System.out.println(event);

//        System.out.println("\nTEST GET SERVICE BY EVENT ID");
            ServiceInfo service = event.getFirstService();
//        System.out.println(service);


            System.out.println("\nTEST CREATE SHEET");
            KitchenSheet sheet = catERing.getKitchenTaskManager().createKitchenSheet("Convegno Agile Community", event, service);
            System.out.println("Foglio autogenerato per servizio \"" + service.getName() + "\" associato all'evento \"" + event.getName() + "\": " + sheet);

            System.out.println("\nTEST ADD KITCHEN TASK");
            List<Instruction> recipes = CatERing.getInstance().getInstructionManager().getInstructions();

            KitchenTask task1 = catERing.getKitchenTaskManager().addKitchenTask(recipes.get(10));
            KitchenTask task2 = catERing.getKitchenTaskManager().addKitchenTask(recipes.get(14));
            KitchenTask task3 = catERing.getKitchenTaskManager().addKitchenTask(recipes.get(15));
            System.out.println("Foglio con nuovi tasks: \"" + task1 + "\", \"" + task2 + "\", \"" + task3 + "\"" + sheet);

            System.out.println("\nTEST DELETE KITCHEN TASK");
            catERing.getKitchenTaskManager().deleteKitchenTask(task1);
            //catERing.getKitchenTaskManager().deleteKitchenTask(task2);
            catERing.getKitchenTaskManager().deleteKitchenTask(task3);
//			System.out.println("Foglio con tasks \"Panini al latte\", \"Bigne farciti\", \"Pizzette\" rimossi: "+sheet);
            System.out.println("Foglio con nuovi tasks: \"" + task1 + "\", \"" + task3 + "\"" + sheet);

            System.out.println("\nTEST MOVE KITCHEN TASK");
            int firstPosition = 0;
            KitchenTask firstTask = sheet.getKitchenTasks().get(firstPosition);
            int newPosition = 5;
            System.out.println("Spostiamo il " + firstPosition + " task \"" + firstTask.getInstruction() + "\" in posizione " + newPosition);
            catERing.getKitchenTaskManager().moveTask(firstTask, newPosition);
            System.out.println("Foglio con task spostato: " + sheet);

            System.out.println("\nTEST GET TURN TABLE");
            List<Shift> shiftTable = catERing.getShiftManager().getShiftTable();
            System.out.println("######################################################");
            System.out.println(shiftTable.toString().replace(", ", " "));
            System.out.println("######################################################");

            System.out.println("\nTEST ASSIGN VALUES TO FIRST TASK");
            int marinellaID = 4;
            User cookMarinella = User.loadUserById(marinellaID);
            Shift tuesdayAfternoonShift = new Shift("Giovedi ore 16:00");
            cookMarinella.addAvailabilityFor(tuesdayAfternoonShift);
            int minutes = 50;
            int quantity = 6;
            System.out.printf("Assegniamo al primo task il cuoco: %s, nel turno: %s, con durata: %s e quantita': %s%n", cookMarinella.getUserName(), tuesdayAfternoonShift.getDatetime(), minutes, quantity);
            firstTask = sheet.getKitchenTasks().get(firstPosition);
            catERing.getKitchenTaskManager().assignTask(firstTask, tuesdayAfternoonShift, cookMarinella.asCook(), minutes, quantity);
            System.out.printf("Assegniamo al secondo task il turno: %s, con durata: %s e quantita': %s%n", tuesdayAfternoonShift.getDatetime(), minutes, quantity);
            KitchenTask secondTask = sheet.getKitchenTasks().get(firstPosition + 1);
            catERing.getKitchenTaskManager().assignTask(secondTask, tuesdayAfternoonShift, null, minutes, quantity);
            System.out.printf("Assegniamo al terzo task il turno: %s%n", tuesdayAfternoonShift.getDatetime());
            KitchenTask thirdTask = sheet.getKitchenTasks().get(firstPosition + 2);
            catERing.getKitchenTaskManager().assignTask(thirdTask, tuesdayAfternoonShift, null, 0, 0);
            System.out.println("Foglio con primi tre tasks assegnati: " + sheet);

            System.out.println("\nTEST SET FIRST TASK COMPLETED");
            catERing.getKitchenTaskManager().specifyTaskCompleted(firstTask, true);
            System.out.println("Foglio con primo task completato: " + sheet);

        } catch (UseCaseLogicException e) {
            System.out.println("Errore di logica nello use case");
        } catch (BusinessLogicException e) {
            System.out.println(e.getMessage());
        }

    }
}
