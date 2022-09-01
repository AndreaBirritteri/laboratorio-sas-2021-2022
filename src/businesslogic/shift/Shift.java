package businesslogic.shift;
public class Shift {
    private String datetime;
    private boolean isCompleted;

    @Override
    public String toString() {
        return "Shift{" +
                "datetime='" + datetime + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
        ShiftManager.updateIsCompleted(this);
    }

    public Shift(String datetime){
        this.datetime = datetime;
    }

    public String getDatetime() {
        return datetime;
    }


}
