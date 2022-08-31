package businesslogic.shift;

public class Shift {
    private String datetime;
    private boolean isCompleted;

    public Shift(String datetime){
        this.datetime = datetime;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }
}
