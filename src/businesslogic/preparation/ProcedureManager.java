package businesslogic.preparation;

import businesslogic.kitchentask.KitchenSheet;
import businesslogic.kitchentask.KitchenTask;
import businesslogic.kitchentask.KitchenTaskEventReceiver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ProcedureManager {

    ArrayList<KitchenTaskEventReceiver> eventReceivers = new ArrayList<>();

    public ProcedureManager() {
        Recipe.loadAllInstructions();
    }


    private Procedure currentRecipe;


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

    public void addPreparation(String title) {
        currentRecipe = new Recipe();
    }


    public void deleteProcedure(Procedure procedure) {
        currentRecipe.deleteRecipe();
    }
/*
    public void editProcedure(Instruction instruction) {
            currentRecipe.editRecipe();
    }*/

    public void copyProcedure(Procedure procedure) {

    }

    public void unpublishProcedure(Procedure procedure) {

    }

    public void defineSection(String name) {
        currentRecipe.defineSection(name);

    }

    public void modifyRepetition(String repetition, int id) {
        currentRecipe.editRepetitionRule(repetition,id);
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

    public void addDetails(ArrayList<String> tags) {
                currentRecipe.addDetails(tags);
    }

    public void addInfo() {

    }

    public void publish() {

    }

    public void createVariant() {

    }

    public void extractPreparation(int id, String title) {
        //currentRecipe = new Preparation(groupedSteps.getSteps(),title, groupedSteps.getIngredients());
        currentRecipe = currentRecipe.extractPreparation(title,id);
        //notifyKitchenSheetCreated(new KitchenSheet("ciao", new ServiceInfo("cio")));
    }

    public ObservableList<Procedure> getInstructions() {
        return FXCollections.unmodifiableObservableList(Procedure.getAllInstruction());
    }

    public ObservableList<Recipe> getRecipes() {
        return FXCollections.unmodifiableObservableList(Recipe.getAllRecipes());
    }
}
