package businesslogic.procedure;

public class Dose implements Ingredient {
    private String quantity;
    private String description;

    public Dose(String description, String quantity) {
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

    public static Dose asDose(Preparation preparation){
        return new Dose(preparation.getTitle(), preparation.getQuantity());
    }
}
