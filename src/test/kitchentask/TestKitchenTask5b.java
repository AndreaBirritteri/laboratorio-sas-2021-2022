package test.kitchentask;

import businesslogic.CatERing;
import businesslogic.shift.Shift;

import java.util.List;

public class TestKitchenTask5b {
    public static void main(String[] args) {
        System.out.println("TEST FAKE LOGIN");
        CatERing catERing = CatERing.getInstance();
        catERing.getUserManager().fakeLogin("Lidia");
        System.out.println(catERing.getUserManager().getCurrentUser());

        System.out.println("\nTABELLONE DEI TURNI");
        List<Shift> shiftTable = catERing.getShiftManager().getShiftTable();
        System.out.println("######################################################");
        System.out.println(shiftTable.toString().replace(", ", " "));
        System.out.println("######################################################");

        System.out.println("\nTEST SET TURN COMPLETENESS");
        int firstShift = 0;
        boolean isCompleted = true;
        System.out.println("Provo a segnare il primo turno nel tabellone come completato = " + isCompleted);
        catERing.getShiftManager().getShiftTable().get(firstShift).setCompleted(isCompleted);
        System.out.println("Tabellone post modifica: ");
        System.out.println("######################################################");
        shiftTable = catERing.getShiftManager().getShiftTable(); //bisogna rifare la chiamata per ottenere l'aggiornamento fatto dal db
        System.out.println(shiftTable.toString().replace(", ", " "));
        System.out.println("######################################################");

    }
}
