package businesslogic.kitchentask;

import businesslogic.procedure.Procedure;
import businesslogic.shift.Shift;
import businesslogic.user.Cook;
import org.apache.commons.lang3.NotImplementedException;

public class KitchenTask {
    private Procedure procedure;
    private int minutes;
    private int quantity;
    private boolean isCompleted;

    KitchenTask(Procedure procedure) {
        this.procedure = procedure;
    }

    void assign(Shift shift, Cook cook, int minutes, int quantity) {
        throw new NotImplementedException("not implemented");
    }

    void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }



}
