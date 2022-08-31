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
    public void updateTaskAdded(KitchenSheet sheet, KitchenTask task) {

    }

    @Override
    public void updateTaskDeleted(KitchenTask task) {

    }

    @Override
    public void updateSheetRestored(KitchenSheet sheet) {

    }

    @Override
    public void updateTasksRearranged(KitchenSheet sheet) {

    }

    @Override
    public void updateTaskAssigned(KitchenSheet sheet, KitchenTask task) {

    }

    @Override
    public void updateTaskCompleted(KitchenSheet sheet, KitchenTask task) {

    }

    @Override
    public void updateShiftCompletenessChanged(Shift shift, boolean isComplete) {

    }
}
