package businesslogic.kitchentask;

import businesslogic.procedure.Procedure;
import businesslogic.shift.Shift;
import businesslogic.user.Cook;
import org.apache.commons.lang3.NotImplementedException;

public class KitchenTask {
    private int minutes;
    private int quantity;
    private boolean isCompleted;

    KitchenTask create(Procedure procedure){
        throw new NotImplementedException("create(Procedure procedure) not implemented");
    }

    void assign(Shift shift, Cook cook, int minutes, int quantity){
        throw new NotImplementedException("assign(Shift shift, Cook cook, int minutes, int quantity) not implemented");
    }

    void setCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }

}
