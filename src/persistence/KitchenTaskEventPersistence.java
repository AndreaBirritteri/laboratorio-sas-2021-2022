package persistence;

import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.kitchentask.KitchenTaskEventReceiver;
import org.apache.commons.lang3.NotImplementedException;

public class KitchenTaskEventPersistence implements KitchenTaskEventReceiver {
    @Override
    public void updateSheetCreated(KitchenSheet sheet) {
        KitchenSheet.saveNewSheet(sheet);
    }

    @Override
    public void updateKitchenTaskAdded(KitchenSheet sheet, KitchenTask task) {
        KitchenSheet.addTask(sheet, task, sheet.getKitchenTasks().indexOf(task));
    }

    @Override
    public void updateKitchenTaskDeleted(KitchenTask task) {
        KitchenTask.deleteTask(task);
    }

    @Override
    public void updateKitchenSheetRestored(KitchenSheet sheet) {
        KitchenSheet.restoreSheet(sheet);
    }

    @Override
    public void updateKitchenTasksRearranged(KitchenSheet sheet) {
        KitchenSheet.rearrangeTask(sheet);
    }

    @Override
    public void updateKitchenTaskAssigned(KitchenTask task) {
        KitchenTask.assignTask(task);
    }

    @Override
    public void updateKitchenTaskCompleted(KitchenTask task, boolean isCompleted) {
        KitchenTask.setTaskCompleteness(task, isCompleted);
    }
}
