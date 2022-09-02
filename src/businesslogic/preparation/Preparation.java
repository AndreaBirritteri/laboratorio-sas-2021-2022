package businesslogic.preparation;

import java.util.ArrayList;

public class Preparation extends Instruction implements AbstractIngredient {

    ArrayList<String> steps;
    String title;
    ArrayList<Ingredient> ingredients;


    public Preparation(ArrayList<String> steps) {
        super();
    }
    public Preparation() {
    }



    public Preparation(ArrayList<String> steps, String title, ArrayList<Ingredient> ingredients) {
        this.steps = steps;
        this.title = title;
        this.ingredients = ingredients;

    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        ingredients.toArray().toString();
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
