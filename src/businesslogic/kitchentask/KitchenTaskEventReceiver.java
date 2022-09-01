package businesslogic.kitchentask;
public interface KitchenTaskEventReceiver {
    public void updateSheetCreated(KitchenSheet sheet);

    public void updateKitchenTaskAdded(KitchenSheet sheet, KitchenTask task);

    public void updateKitchenTaskDeleted(KitchenTask task);

    public void updateKitchenSheetRestored();

    public void updateKitchenTasksRearranged(KitchenTask task);

    public void updateKitchenTaskAssigned(KitchenTask task);

    public void updateKitchenTaskCompleted(KitchenTask task);
}
