package businesslogic.kitchentask;

import businesslogic.shift.Shift;

public interface KitchenTaskEventReceiver {
    public void updateSheetCreated(KitchenSheet sheet);

    public void updateKitchenTaskAdded(KitchenSheet sheet, KitchenTask task);

    public void updateKitchenTaskDeleted(KitchenTask task);

    public void updateKitchenSheetRestored(KitchenSheet sheet);

    public void updateKitchenTasksRearranged(KitchenTask task);

    public void updateKitchenTaskAssigned(KitchenTask task);

    public void updateKitchenTaskCompleted(KitchenTask task);

    public void updateShiftCompletenessChanged(Shift shift, boolean isComplete);
}
