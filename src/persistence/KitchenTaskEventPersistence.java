package persistence;

import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.kitchentask.KitchenTaskEventReceiver;
import businesslogic.shift.Shift;
import org.apache.commons.lang3.NotImplementedException;

public class KitchenTaskEventPersistence implements KitchenTaskEventReceiver {
    @Override
    public void updateSheetCreated(KitchenSheet sheet) {
        throw new NotImplementedException("Not implemented");
    }

    @Override
    public void updateKitchenTaskAdded(KitchenSheet sheet, KitchenTask task) {
        throw new NotImplementedException("Not implemented");
    }

    @Override
    public void updateKitchenTaskDeleted(KitchenTask task) {
        throw new NotImplementedException("Not implemented");
    }

    @Override
    public void updateKitchenSheetRestored() {
        throw new NotImplementedException("Not implemented");
    }

    @Override
    public void updateKitchenTasksRearranged(KitchenTask task) {
        throw new NotImplementedException("Not implemented");
    }

    @Override
    public void updateKitchenTaskAssigned(KitchenTask task) {
        throw new NotImplementedException("Not implemented");
    }

    @Override
    public void updateKitchenTaskCompleted(KitchenTask task) {
        throw new NotImplementedException("Not implemented");
    }
}
