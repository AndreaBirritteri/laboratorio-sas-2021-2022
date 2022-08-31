package businesslogic.procedure;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProcedureManager {

    public ProcedureManager() {
        Recipe.loadAllRecipes();
    }


    private Recipe currentRecipe;


    public void addRecipe(String title) {

            currentRecipe = new Recipe();

    }

    public void addProcedure(String title) {
        currentRecipe = new Recipe();
    }

    public void deleteProcedure(Procedure procedure) {
        currentRecipe.deleteRecipe();
    }

    public void editProcedure(Procedure procedure) {
            currentRecipe.editRecipe();
    }

    public void copyProcedure(Procedure procedure) {

    }

    public void unpublishProcedure(Procedure procedure) {

    }

    public void defineSection(String name) {

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



    public ObservableList<Recipe> getRecipes() {
        return FXCollections.unmodifiableObservableList(Recipe.getAllRecipes());
    }
}
