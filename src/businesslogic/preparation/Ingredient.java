package businesslogic.preparation;

public class Ingredient implements AbstractIngredient {
    private String quantity;
    private String description;

    public Ingredient(String description, String quantity) {
        this.quantity = quantity;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getQuantity(){
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Ingredient asIngredient(Preparation preparation){
        return new Ingredient(preparation.getTitle(), preparation.getQuantity());
    }
}
