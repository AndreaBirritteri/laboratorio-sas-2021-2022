package businesslogic.procedure;

import java.util.ArrayList;
import java.util.List;

public class GroupedSteps {

    private ArrayList<String> steps;
    private String repetionRule;
    private boolean inAdvance;
    private ArrayList<Ingredient> ingredients;


    public GroupedSteps() {
        this.steps = new ArrayList<>();
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    public String getRepetionRule() {
        return repetionRule;
    }

    public void setRepetionRule(String repetionRule) {
        this.repetionRule = repetionRule;
    }

    public boolean isInAdvance() {
        return inAdvance;
    }

    public void setInAdvance(boolean inAdvance) {
        this.inAdvance = inAdvance;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
}
