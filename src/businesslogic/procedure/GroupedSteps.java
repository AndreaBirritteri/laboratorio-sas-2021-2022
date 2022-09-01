package businesslogic.procedure;

import java.util.ArrayList;

public class GroupedSteps {

    private ArrayList<String> steps;
    private String receptionRule;
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

    public String getReceptionRule() {
        return receptionRule;
    }

    public void setReceptionRule(String receptionRule) {
        this.receptionRule = receptionRule;
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
