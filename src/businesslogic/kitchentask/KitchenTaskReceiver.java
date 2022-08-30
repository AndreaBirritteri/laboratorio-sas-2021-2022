package businesslogic.kitchentask;

import businesslogic.shift.Shift;

public interface KitchenTaskReceiver {
    public void updateSheetCreated(KitchenSheet sheet);

    public void updateTaskAdded(KitchenSheet sheet, KitchenTask task);

    public void updateTaskDeleted(KitchenTask task);

    public void updateSheetRestored(KitchenSheet sheet);

    public void updateTasksRearranged(KitchenSheet sheet);

    public void updateTaskAssigned(KitchenSheet sheet, KitchenTask task);

    public void updateTaskCompleted(KitchenSheet sheet, KitchenTask task);

    public void updateTurnCompletenessChanged(Shift shift, boolean isComplete);
}
