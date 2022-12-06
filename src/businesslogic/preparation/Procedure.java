package businesslogic.preparation;

import businesslogic.kitchentask.KitchenTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.PersistenceManager;
import persistence.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public abstract class Procedure {
    protected static final Map<Integer, Procedure> all = new HashMap<>();

    protected int id;
    protected List<KitchenTask> assignedInTasks;
    protected List<GroupedSteps> groupedSteps;
    protected List<String> tags;

    protected String title;
    protected String quantity;
    protected String notes;
    protected String author;
    protected boolean published;
    protected int minutes1;

    protected int minutes2;

    protected int minutes3;


    @Override
    public String toString() {
        return title;
    }

    public Procedure() {
        id = 0;
        this.assignedInTasks = new ArrayList<>();
        this.groupedSteps = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public ArrayList<Dose> getIngredients(){
        ArrayList<Dose> doses = new ArrayList<>();

        for(GroupedSteps groupedStep: groupedSteps){
            doses.addAll(groupedStep.getIngredients());
        }

        return doses;
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

    public int getMinutes1() {
        return minutes1;
    }


    public static ObservableList<Procedure> loadAllInstructions() {
        String query = "SELECT * FROM Instructions";
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet res) throws SQLException {
                int id = res.getInt("id");
                String title = res.getString("title");
                String instructionType = res.getString("instruction_type");
                if (all.containsKey(id)) {
                    Procedure procedure = all.get(id);
                    procedure.title = title;
                } else {
                    Procedure procedure;
                    if(Objects.equals(instructionType, "r")){
                        procedure = new Recipe(title);
                    }else if(Objects.equals(instructionType, "p")){
                        procedure = new Preparation(title);
                    }else{
                        throw new IllegalArgumentException();
                    }

                    procedure.id = id;
                    all.put(procedure.id, procedure);
                }
            }
        });
        ObservableList<Procedure> res = FXCollections.observableArrayList(all.values());
        res.sort(new Comparator<Procedure>() {
            @Override
            public int compare(Procedure o1, Procedure o2) {
                return (o1.getTitle().compareTo(o2.getTitle()));
            }
        });
        return res;
    }

    public static ObservableList<Procedure> getAllInstruction() {
        return FXCollections.observableArrayList(all.values());
    }

    public static ArrayList<Procedure> getInstructionsOfRecipes(ArrayList<Recipe> recipes) {
        ArrayList<Procedure> procedures = new ArrayList<>(recipes);

        for (Procedure recipe: recipes){
            ArrayList <Dose> ingredientsRecipe = recipe.getIngredients();
            if (ingredientsRecipe != null){
                for (Ingredient ingredient: ingredientsRecipe){
                    if (ingredient instanceof Preparation)
                        procedures.add((Preparation) ingredient);
                }
            }
        }

        return procedures;
    }


    public void addIngredientGroup(Dose dose) {
        groupedSteps.get(1).setIngredients(dose);
    }

    public List<Dose> getIngredientsGroup() {
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
            this.groupedSteps.add(new GroupedSteps(name));
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


    public void addDetails(ArrayList<String> tags) {
        this.tags = tags;
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


    public Preparation extractPreparation(String title,int idGroup) {
        Preparation c = new Preparation();
        c.setTitle(title);
        c.setSteps(groupedSteps.get(idGroup).getSteps());
        c.groupedSteps.add(new GroupedSteps());
        c.setIngredients(c.groupedSteps.get(0), this.groupedSteps.get(idGroup).getIngredients());

        return c;

    }

    public void editRepetitionRule(String s, int idGroup) {
        groupedSteps.get(idGroup).setReceptionRule(s);
    }




}

