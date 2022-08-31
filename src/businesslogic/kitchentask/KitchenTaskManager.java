package businesslogic.kitchentask;

import businesslogic.shift.Shift;

public class KitchenTaskManager {

    public void addReceiver(KitchenTaskReceiver kitchenTaskReceiver) {

    }

    public void removeReceiver(KitchenTaskReceiver kitchenTaskReceiver) {

    }

    public void notifySheetCreated(KitchenSheet sheet) {

    }

    public void notifyTaskAdded(KitchenSheet sheet, KitchenTask task) {

    }

    public void notifyTaskDeleted(KitchenTask task) {

    }

    public void notifySheetRestored(KitchenSheet sheet) {

    }

    public void notifyTasksRearranged(KitchenSheet sheet) {

    }

    public void notifyTaskAssigned(KitchenSheet sheet, KitchenTask task) {

    }

    public void notifyTaskCompleted(KitchenSheet sheet, KitchenTask task) {

    }

    public void notifyTurnCompletenessChanged(Shift shift, boolean isCompleted) {

    }

    createKitchenSheet(title:String, event:Event, service:Service) :KitchenSheet

    setCurrentSheet(sheet:KitchenSheet)

    chooseKitchenSheet(sheet:KitchenSheet, event:Event, service:Service) :KitchenSheet +

    addKitchenTask(procedure:Procedure) :KitchenTask
+

    deleteKitchenTask(task:KitchenTask)
+

    restoreOriginalTasks()
+

    moveTask(task:KitchenTask, position:int)
+

    assignTask(task:KitchenTask, turn?:Turn, cook?:Cook, timing?:String, quantity?:String) +

    specifyCompletedTask(task:KitchenTask)
+

    specifyTurnCompleteness(turn:Turn, isComplete:boolean)
}
