package businesslogic.procedure;

import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.kitchentask.KitchenTaskEventReceiver;
import businesslogic.shift.Shift;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProcedureManager {

    public ProcedureManager() {
        Procedure.loadAllRecipes();
    }


    private Procedure currentProcedure;




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


    public void addRecipe(String title) {

            currentProcedure = new Recipe(title);

    }

    public void addProcedure(String title) {
        currentProcedure = new Recipe();
    }



    public void deleteProcedure(Procedure procedure) {
        currentProcedure.deleteRecipe();
    }

    public void editProcedure(Procedure procedure) {
            currentProcedure.editRecipe();
    }

    public void copyProcedure(Procedure procedure) {

    }

    public void unpublishProcedure(Procedure procedure) {

    }

    public void defineSection(String name) {
        currentProcedure.defineSection(name);

    }

    public void modifyRepetition(){
        currentProcedure.
    }


    public void deleteSection(String name) {

    }

    public void editNameSection(String name) {

    }

    public void viewRecipeBook(){

    }

    public void newSimpleStep(){

    }

    public void editStep(){

    }

    public void deleteStep(){

    }

    public void addIngredient(){

    }

    public void deleteIngredient(){

    }

    public void addDetails(){

    }

    public void addInfo(){

    }

    public void publish(){

    }

    public void createVariant(){

    }
    public void extractPreparation(String title){

        currentProcedure = new Recipe();
    }



    public ObservableList<Recipe> getRecipes() {
        return FXCollections.unmodifiableObservableList(Recipe.getAllRecipes());
    }
}
