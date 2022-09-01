package persistence;

import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.kitchentask.KitchenTaskEventReceiver;
import businesslogic.shift.Shift;

public class KitchenTaskEventPersistence implements KitchenTaskEventReceiver {
    @Override
    public void updateSheetCreated(KitchenSheet sheet) {
    }

    @Override
    public void updateKitchenTaskAdded(KitchenSheet sheet, KitchenTask task) {

    }

    @Override
    public void updateKitchenTaskDeleted(KitchenTask task) {

    }

    @Override
    public void updateKitchenSheetRestored(KitchenSheet sheet) {

    }

    @Override
    public void updateKitchenTasksRearranged(KitchenTask task) {

    }

    @Override
    public void updateKitchenTaskAssigned(KitchenTask task) {

    }

    @Override
    public void updateKitchenTaskCompleted(KitchenTask task) {

    }

    @Override
    public void updateShiftCompletenessChanged(Shift shift, boolean isComplete) {

    }
}
