package businesslogic.procedure;

import java.util.ArrayList;

public class Preparation extends Procedure implements Ingredient {

  ArrayList<String> steps;
  String title;

  public Preparation(String title) {
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
    ArrayList<Dose> doses = new ArrayList<>();
    for (GroupedSteps gs : groupedSteps) {
      doses.addAll(gs.getIngredients());
    }
    return doses;
  }

  public void setIngredients(GroupedSteps gr, ArrayList<Dose> doses) {
    for(Dose dose: doses)
      gr.setIngredients(dose);
  }
}
