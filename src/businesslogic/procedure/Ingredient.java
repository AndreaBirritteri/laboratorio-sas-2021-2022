package businesslogic.procedure;

public class Ingredient {
    private String quantity;
    private String description;

    public Ingredient(String quantity, String description) {
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
}
