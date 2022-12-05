package businesslogic.preparation;

import java.util.ArrayList;

public class Preparation extends Procedure implements Ingredient {

    ArrayList<String> steps;
    String title;
    ArrayList<Dose> doses;

    public Preparation(String title){
        this.title = title;
    }

    public Preparation(ArrayList<String> steps) {
        super();
    }
    public Preparation() {
    }



    public Preparation(ArrayList<String> steps, String title, ArrayList<Dose> doses) {
        this.steps = steps;
        this.title = title;
        this.doses = doses;

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
    public ArrayList<Dose> getIngredients() {
        doses.toArray().toString();
        return doses;
    }

    public void setIngredients(ArrayList<Dose> doses) {
        this.doses = doses;
    }
}
