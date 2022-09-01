package businesslogic.procedure;

import java.util.ArrayList;

public class Preparation extends Procedure {

    ArrayList<String> steps;
    String title;
    ArrayList<Ingredient> ingredients;


    public Preparation(ArrayList<String> steps) {
        super();
    }


    public Preparation(ArrayList<String> steps, String title, ArrayList<Ingredient> ingredients) {
        this.steps = steps;
        this.title = title;
        this.ingredients = ingredients;

    }
}
