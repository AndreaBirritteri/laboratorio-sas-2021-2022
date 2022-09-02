package businesslogic.kitchentask;

import businesslogic.BusinessLogicException;
import businesslogic.CatERing;
import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.event.ServiceInfo;
import businesslogic.preparation.Instruction;
import businesslogic.shift.Shift;
import businesslogic.user.Chef;
import businesslogic.user.Cook;
import businesslogic.user.User;

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

    public void notifyKitchenTasksRearranged(KitchenSheet sheet) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateKitchenTasksRearranged(sheet);
        }
    }

    public void notifyKitchenTaskAssigned(KitchenTask task) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateKitchenTaskAssigned(task);
        }
    }

    public void notifyKitchenTaskCompletedChanged(KitchenTask task) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateKitchenTaskCompleted(task, task.isCompleted());
        }
    }

    public KitchenSheet createKitchenSheet(String title, EventInfo event, ServiceInfo service) throws UseCaseLogicException, BusinessLogicException {
        KitchenSheet kitchenSheet;
        User user = CatERing.getInstance().getUserManager().getCurrentUser();

        if (!user.isRole(User.Role.CHEF) ||
                !event.getServices().contains(service) ||
                service.getMenu() == null ||
                !user.getAssignedEvents().contains(event)) {
            throw new UseCaseLogicException();
        }
        if (KitchenSheet.getIdFromTitleAndServiceId(title, service.getId()) >= 0) {
            kitchenSheet = KitchenSheet.loadSheetInfoByTitle(title, service);
        } else if (KitchenSheet.getIdFromServiceId(service.getId()) >= 0) {
            throw new BusinessLogicException("\"" + service.getName() + "\", già esistente ma ha un altro titolo.");
        } else {
            kitchenSheet = new KitchenSheet(title, service);
            notifyKitchenSheetCreated(kitchenSheet);
        }

        setCurrentKitchenSheet(kitchenSheet);

        return kitchenSheet;
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
        if (!user.isRole(User.Role.CHEF) ||
                !event.getServices().contains(service) ||
                !user.getAssignedEvents().contains(event) ||
                service.getMenu() == null) {
            throw new UseCaseLogicException();
        }
        KitchenSheet currentSheet = KitchenSheet.loadSheetInfoByTitle(sheet.getTitle(), service);
        this.setCurrentKitchenSheet(currentSheet);
        return currentSheet;
    }

    public KitchenTask addKitchenTask(Instruction instruction) throws UseCaseLogicException {
        if (currentKitchenSheet != null) {
            KitchenTask kitchenTask = this.currentKitchenSheet.addKitchenTask(instruction);
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

    public void restoreOriginalTasks() throws UseCaseLogicException {
        if (currentKitchenSheet != null) {
            currentKitchenSheet.restoreOriginalTasks();
            notifyKitchenSheetRestored(currentKitchenSheet);
        } else {
            throw new UseCaseLogicException();
        }
    }

    public void moveTask(KitchenTask task, int toPosition) throws UseCaseLogicException {
        if (currentKitchenSheet == null) {
            throw new UseCaseLogicException();
        } else if (toPosition < 0 || toPosition >= currentKitchenSheet.getKitchenTasks().size()) {
            throw new IllegalArgumentException();
        } else {
            currentKitchenSheet.moveTask(task, toPosition);
            this.notifyKitchenTasksRearranged(currentKitchenSheet);
        }
    }

    public void assignTask(KitchenTask task, Shift shift, Cook user, int minutes, int quantity) throws UseCaseLogicException {
        if (currentKitchenSheet != null && currentKitchenSheet.getKitchenTasks().contains(task)) {
            currentKitchenSheet.assignTask(task, shift, user, minutes, quantity);
            notifyKitchenTaskAssigned(task);
        } else {
            throw new UseCaseLogicException();
        }
    }

    public void specifyTaskCompleted(KitchenTask task, boolean isCompleted) throws UseCaseLogicException {
        if (currentKitchenSheet != null && currentKitchenSheet.getKitchenTasks().contains(task)) {
            currentKitchenSheet.setKitchenTaskCompleted(task, isCompleted);
            notifyKitchenTaskCompletedChanged(task);
        } else {
            throw new UseCaseLogicException();
        }
    }
}
