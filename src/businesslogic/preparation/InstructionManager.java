package businesslogic.preparation;

import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.kitchentask.KitchenTaskEventReceiver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class InstructionManager {

    ArrayList<KitchenTaskEventReceiver> eventReceivers = new ArrayList<>();

    public InstructionManager() {
        Recipe.loadAllInstructions();
    }


    private Recipe currentRecipe;


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

    public void notifyKitchenTaskCompleted(KitchenTask task, boolean isCompleted) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateKitchenTaskCompleted(task, isCompleted);
        }
    }
/*
    public void notifyShiftCompletenessChanged(Shift shift, boolean isCompleted) {
        for (KitchenTaskEventReceiver er : this.eventReceivers) {
            er.updateShiftCompletenessChanged(shift, isCompleted);
        }
    }
*/

    public void addRecipe(String title) {

        currentRecipe = new Recipe(title);

    }

    public void addProcedure(String title) {
        currentRecipe = new Recipe();
    }


    public void deleteProcedure(Instruction instruction) {
        currentRecipe.deleteRecipe();
    }
/*
    public void editProcedure(Instruction instruction) {
            currentRecipe.editRecipe();
    }*/

    public void copyProcedure(Instruction instruction) {

    }

    public void unpublishProcedure(Instruction instruction) {

    }

    public void defineSection(String name) {
        currentRecipe.defineSection(name);

    }

    public void modifyRepetition() {
        //currentRecipe.
    }


    public void deleteSection(String name) {

    }

    public void editNameSection(String name) {

    }

    public void viewRecipeBook() {

    }

    public void newSimpleStep() {

    }

    public void editStep() {

    }

    public void deleteStep() {

    }

    public void addIngredient() {

    }

    public void deleteIngredient() {

    }

    public void addDetails() {

    }

    public void addInfo() {

    }

    public void publish() {

    }

    public void createVariant() {

    }

    public void extractPreparation(String title) {

        currentRecipe = new Recipe();
    }

    public ObservableList<Instruction> getInstructions() {
        return FXCollections.unmodifiableObservableList(Instruction.getAllInstruction());
    }

    public ObservableList<Recipe> getRecipes() {
        return FXCollections.unmodifiableObservableList(Recipe.getAllRecipes());
    }
}
