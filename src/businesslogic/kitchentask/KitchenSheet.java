package businesslogic.kitchentask;

import businesslogic.event.ServiceInfo;
import businesslogic.procedure.Procedure;
import businesslogic.shift.Shift;
import businesslogic.user.Cook;
import org.apache.commons.lang3.NotImplementedException;

public class KitchenSheet {
    public String title;

    public KitchenSheet create(String title, ServiceInfo service){
        throw new NotImplementedException("not implemented");
    }

    public KitchenTask addKitchenTask(Procedure procedure){
        throw new NotImplementedException("not implemented");
    }

    public void deleteKitchenTask(KitchenTask kitchenTask){
        throw new NotImplementedException("not implemented");
    }

    public void restoreOriginalTasks(){
        throw new NotImplementedException("not implemented");
    }

    public void moveTask(KitchenTask kitchenTask, int position){
        throw new NotImplementedException("not implemented");
    }

    public void assignTask(KitchenTask kitchenTask, Shift shift, Cook cook, int minutes, int quantity){
        throw new NotImplementedException("not implemented");
    }

    public void specifyCompletedTask(KitchenTask kitchenTask){
        throw new NotImplementedException("not implemented");
    }
}
