package businesslogic.procedure;

import businesslogic.kitchentask.KitchenTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.PersistenceManager;
import persistence.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public abstract class Instruction {
    protected static final Map<Integer, Instruction> all = new HashMap<>();

    protected int id;
    protected final List<KitchenTask> assignedInTasks;
    protected final List<GroupedSteps> groupedSteps;

    protected List<String> tags;

    protected String title;
    protected String quantity;
    protected String notes;
    protected String author;
    protected boolean published;
    protected int minutes;

    public Instruction() {
        id = 0;
        this.assignedInTasks = new ArrayList<>();
        this.groupedSteps = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public ArrayList<Ingredient> getIngredients(){
        ArrayList<Ingredient> ingredients = new ArrayList<>();

        for(GroupedSteps groupedStep: groupedSteps){
            ingredients.addAll(groupedStep.getIngredients());
        }

        return ingredients;
    }

    public List<KitchenTask> getAssignedInTasks() {
        return assignedInTasks;
    }

    public List<GroupedSteps> getGroupedSteps() {
        return groupedSteps;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getNotes() {
        return notes;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isPublished() {
        return published;
    }

    public int getMinutes() {
        return minutes;
    }


    public static ObservableList<Instruction> loadAllInstructions() {
        String query = "SELECT * FROM Instructions";
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                int id = rs.getInt("id");
                if (all.containsKey(id)) {
                    Instruction rec = all.get(id);
                    rec.title = rs.getString("title");
                } else {
                    Instruction rec = new Recipe(rs.getString("title"));
                    rec.id = id;
                    all.put(rec.id, rec);
                }
            }
        });
        ObservableList<Instruction> res = FXCollections.observableArrayList(all.values());
        res.sort(new Comparator<Instruction>() {
            @Override
            public int compare(Instruction o1, Instruction o2) {
                return (o1.getTitle().compareTo(o2.getTitle()));
            }
        });
        return res;
    }

    public static ObservableList<Instruction> getAllRecipes() {
        return FXCollections.observableArrayList(all.values());
    }

    public static ArrayList<Instruction> getInstructionsOfRecipes(ArrayList<Instruction> recipes) {
        ArrayList<Instruction> procedures = new ArrayList<>(recipes);

        for (Instruction recipe: recipes){
            ArrayList <Ingredient> ingredientsRecipe = recipe.getIngredients();
            if (ingredientsRecipe != null){
                for (AbstractIngredient ingredient: ingredientsRecipe){
                    if (ingredient instanceof Preparation)
                        procedures.add((Preparation) ingredient);
                }
            }
        }

        return procedures;
    }


    public void addIngredientGroup(Ingredient ingredient) {
        groupedSteps.get(1).setIngredients(ingredient);
    }

    public List<Ingredient> getIngredientsGroup() {
        return groupedSteps.get(1).getIngredients();
    }

    //this method extract all the procedures from the recipe list passed by argument
   /* public static List<Procedure> retrieveProceduresToPrepare(List<Recipe> recipesToExtract) {
        List<Procedure> procedures = new ArrayList<>();

        for (Recipe recipe : recipesToExtract) {
            Procedure newPrep = new Preparation(groupedSteps.get(3).getGroupedSteps());
            for (Ingredient ingredient : recipe.getIngredients()) {
                newPrep.addIngredient(ingredient);
                procedures.add(newPrep);
            }
        }

        return procedures;
    }
*/

    public void defineSection(String name) {

    }

    public void deleteSection(String name) {

    }


    public void editNameSection(String name) {

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





    public void addAssignedTask(KitchenTask task) {
        this.assignedInTasks.add(task);
    }

    public void removeAssignedTask(KitchenTask task) {
        this.assignedInTasks.remove(task);
    }


    public void setName(String name) {
        //this.name = name;
    }

    public void deleteRecipe() {
        all.remove(this);
    }

    public void editRecipe(String title) {
        this.title = title;
    }


    public void copyProcedure() {
        all.remove(this);
    }


    public void extractPreparation(String title) {
        new Preparation(groupedSteps.get(3).getSteps(), title, groupedSteps.get(3).getIngredients());


    }

    public void editRepetitionRule(String s) {
        groupedSteps.get(3).setReceptionRule(s);
    }




}

