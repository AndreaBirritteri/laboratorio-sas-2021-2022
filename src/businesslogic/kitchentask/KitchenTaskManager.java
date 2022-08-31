package businesslogic.kitchentask;

import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.procedure.Procedure;
import businesslogic.shift.Shift;
import businesslogic.user.Cook;
import org.apache.commons.lang3.NotImplementedException;

public class KitchenTaskManager {

    public void addReceiver(KitchenTaskReceiver kitchenTaskReceiver) {
        throw new NotImplementedException("not implemented");
    }

    public void removeReceiver(KitchenTaskReceiver kitchenTaskReceiver) {
        throw new NotImplementedException("not implemented");
    }

    public void notifySheetCreated(KitchenSheet sheet) {
        throw new NotImplementedException("not implemented");
    }

    public void notifyTaskAdded(KitchenSheet sheet, KitchenTask task) {
        throw new NotImplementedException("not implemented");
    }

    public void notifyTaskDeleted(KitchenTask task) {
        throw new NotImplementedException("not implemented");
    }

    public void notifySheetRestored(KitchenSheet sheet) {
        throw new NotImplementedException("not implemented");
    }

    public void notifyTasksRearranged(KitchenSheet sheet) {
        throw new NotImplementedException("not implemented");
    }

    public void notifyTaskAssigned(KitchenSheet sheet, KitchenTask task) {
        throw new NotImplementedException("not implemented");
    }

    public void notifyTaskCompleted(KitchenSheet sheet, KitchenTask task) {
        throw new NotImplementedException("not implemented");
    }

    public void notifyTurnCompletenessChanged(Shift shift, boolean isCompleted) {
        throw new NotImplementedException("not implemented");
    }

    public KitchenSheet createKitchenSheet(String title, EventInfo event, ServiceInfo service) {
        throw new NotImplementedException("not implemented");
    }

    public void setCurrentSheet(KitchenSheet sheet) {
        throw new NotImplementedException("not implemented");
    }

    public KitchenSheet chooseKitchenSheet(KitchenSheet sheet, EventInfo event, ServiceInfo service) {
        throw new NotImplementedException("not implemented");
    }

    public KitchenSheet addKitchenTask(Procedure procedure) {
        throw new NotImplementedException("not implemented");
    }

    public void deleteKitchenTask(KitchenTask task) {
        throw new NotImplementedException("not implemented");
    }

    public void restoreOriginalTasks() {
        throw new NotImplementedException("not implemented");
    }

    public void moveTask(KitchenTask task, int position) {
        throw new NotImplementedException("not implemented");
    }

    public void assignTask(KitchenTask task, Shift shift, Cook cook, int minutes, int quantity) {
        throw new NotImplementedException("not implemented");
    }

    public void specifyCompletedTask(KitchenTask task) {
        throw new NotImplementedException("not implemented");
    }

    public void specifyTurnCompleteness(Shift shift, boolean isComplete) {
        throw new NotImplementedException("not implemented");
    }
}
