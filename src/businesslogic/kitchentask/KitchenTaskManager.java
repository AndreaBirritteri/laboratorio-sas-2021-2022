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

    public void notifySheetCreated(KitchenSheet sheet) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateSheetCreated(sheet);
        }
    }

    public void notifyTaskAdded(KitchenSheet sheet, KitchenTask task) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateTaskAdded(sheet, task);
        }
    }

    public void notifyTaskDeleted(KitchenTask task) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateTaskDeleted(task);
        }
    }

    public void notifySheetRestored(KitchenSheet sheet) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateSheetRestored(sheet);
        }
    }

    public void notifyTasksRearranged(KitchenSheet sheet) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateTasksRearranged(sheet);
        }
    }

    public void notifyTaskAssigned(KitchenSheet sheet, KitchenTask task) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateTaskAssigned(sheet, task);
        }
    }

    public void notifyTaskCompleted(KitchenSheet sheet, KitchenTask task) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateTaskCompleted(sheet, task);
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

    public void setCurrentSheet(KitchenSheet sheet) {
        throw new NotImplementedException("not implemented");
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
        this.setCurrentSheet(currentSheet);

        return currentSheet;
    }

    public KitchenTask addKitchenTask(Procedure procedure) {
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

    public void assignTask(KitchenTask task, Shift shift, User cook, int minutes, int quantity) {
        throw new NotImplementedException("not implemented");
    }

    public void specifyCompletedTask(KitchenTask task) {
        throw new NotImplementedException("not implemented");
    }
}
