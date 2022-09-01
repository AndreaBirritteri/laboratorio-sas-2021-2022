package businesslogic.kitchentask;

public interface KitchenTaskEventReceiver {
    public void updateSheetCreated(KitchenSheet sheet);

    public void updateKitchenTaskAdded(KitchenSheet sheet, KitchenTask task) ;

    public void updateKitchenTaskDeleted(KitchenTask task);

    public void updateKitchenSheetRestored(KitchenSheet sheet);

    public void updateKitchenTasksRearranged(KitchenSheet sheet);

    public void updateKitchenTaskAssigned(KitchenTask task);

    public void updateKitchenTaskCompleted(KitchenTask task, boolean isCompleted);
}
