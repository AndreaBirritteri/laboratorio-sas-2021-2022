package businesslogic.preparation;

import java.util.ArrayList;

public class GroupedSteps {

    private int id;

    private String title;

    private ArrayList<String> steps;
    private String receptionRule;
    private boolean inAdvance;
    private ArrayList<Dose> doses;


    public GroupedSteps() {
        this.steps = new ArrayList<>();
    }

    public GroupedSteps(String title) {
        this.title = title;
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

    public ArrayList<Dose> getIngredients() {
        return doses;
    }

    public void setIngredients(Dose dose) {
        doses.add(dose);
    }
}
