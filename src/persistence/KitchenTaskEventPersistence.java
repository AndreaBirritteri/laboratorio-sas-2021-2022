package persistence;

import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.kitchentask.KitchenTaskEventReceiver;
import businesslogic.shift.Shift;
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
