package businesslogic.kitchentask;

import businesslogic.BusinessLogicException;
import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.procedure.Procedure;
import businesslogic.shift.Shift;
import businesslogic.user.User;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;

public class KitchenTaskManager {
    private KitchenSheet currentKitchenSheet;
    private ArrayList<KitchenTaskEventReceiver> eventReceivers = new ArrayList<>();

    public void addEventReceiver(KitchenTaskEventReceiver kitchenTaskEventReceiver) {
        eventReceivers.add(kitchenTaskEventReceiver);
    }

    public void removeEventReceiver(KitchenTaskEventReceiver kitchenTaskEventReceiver) {
        eventReceivers.remove(kitchenTaskEventReceiver);
    }

    public void notifyKitchenSheetCreated(KitchenSheet sheet) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateSheetCreated(sheet);
        }
    }

    public void notifyKitchenTaskAdded(KitchenSheet sheet, KitchenTask task) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateKitchenTaskAdded(sheet, task);
        }
    }

    public void notifyKitchenTaskDeleted(KitchenTask task) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateKitchenTaskDeleted(task);
        }
    }

    public void notifyKitchenSheetRestored(KitchenSheet sheet) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateKitchenSheetRestored(sheet);
        }
    }

    public void notifyKitchenTasksRearranged(KitchenTask sheet) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateKitchenTasksRearranged(sheet);
        }
    }

    public void notifyKitchenTaskAssigned(KitchenTask task) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateKitchenTaskAssigned(task);
        }
    }

    public void notifyKitchenTaskCompleted(KitchenTask task) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateKitchenTaskCompleted(task);
        }
    }

    public void notifyShiftCompletenessChanged(Shift shift, boolean isCompleted) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateShiftCompletenessChanged(shift, isCompleted);
        }
    }

    public KitchenSheet createKitchenSheet(String title, EventInfo event, ServiceInfo service) {
        throw new NotImplementedException("not implemented");
    }

    public void setCurrentKitchenSheet(KitchenSheet sheet) throws UseCaseLogicException {
        if (sheet != null) {
            this.currentKitchenSheet = sheet;
        } else {
            throw new UseCaseLogicException();
        }
    }

    public KitchenSheet chooseKitchenSheet(KitchenSheet sheet, EventInfo event, ServiceInfo service)
            throws UseCaseLogicException, BusinessLogicException {
        User user = CatERing.getInstance().getUserManager().getCurrentUser();
        if (!user.isChef() ||
                !event.getServices().contains(service) ||
                !user.getAssignedEvents().contains(event) ||
                service.getMenu() == null) {
            throw new UseCaseLogicException();
        }
        KitchenSheet currentSheet = KitchenSheet.loadSheetInfoByTitle(sheet.getTitle(), service);
        this.setCurrentKitchenSheet(currentSheet);
        return currentSheet;
    }

    public KitchenTask addKitchenTask(Procedure procedure) throws UseCaseLogicException {
        if (currentKitchenSheet != null) {
            KitchenTask kitchenTask = this.currentKitchenSheet.addKitchenTask(procedure);
            this.notifyKitchenTaskAdded(currentKitchenSheet, kitchenTask);
            return kitchenTask;
        }
        throw new UseCaseLogicException();
    }

    public void deleteKitchenTask(KitchenTask task) throws UseCaseLogicException {
        if (currentKitchenSheet != null && currentKitchenSheet.getKitchenTasks().contains(task)) {
            currentKitchenSheet.deleteKitchenTask(task);
            this.notifyKitchenTaskDeleted(task);
        } else {
            throw new UseCaseLogicException();
        }
    }

    public void restoreOriginalTasks() {
        throw new NotImplementedException("not implemented");
    }

    public void moveTask(KitchenTask task, int position) throws UseCaseLogicException {
        if (currentKitchenSheet == null) {
            throw new UseCaseLogicException();
        } else if (position < 0 || position >= currentKitchenSheet.getKitchenTasks().size()) {
            throw new IllegalArgumentException();
        } else {
            this.currentKitchenSheet.moveTask(task, position);
            this.notifyKitchenTasksRearranged(task);
        }
    }

    public void assignTask(KitchenTask task, Shift shift, User user, int minutes, int quantity) throws Exception {
        if(currentKitchenSheet != null && currentKitchenSheet.getKitchenTasks().contains(task)){
            task.assign(shift, user, minutes, quantity);
            notifyKitchenTaskAssigned(task);
        }else{
            throw new UseCaseLogicException();
        }
    }

    public void specifyCompletedTask(KitchenTask task) throws UseCaseLogicException {
        if(currentKitchenSheet != null && currentKitchenSheet.getKitchenTasks().contains(task)){
            currentKitchenSheet.setKitchenTaskAsCompleted(task);
            notifyKitchenTaskCompleted(task);
        }else{
            throw new UseCaseLogicException();
        }
    }
}
