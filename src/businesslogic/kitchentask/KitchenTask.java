package businesslogic.kitchentask;

import businesslogic.procedure.Procedure;
import businesslogic.procedure.Recipe;
import businesslogic.shift.Shift;
import businesslogic.user.Cook;
import businesslogic.user.User;
import persistence.PersistenceManager;
import persistence.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KitchenTask {
    private final Procedure procedure;
    private Shift shift;
    private User cook;
    private int minutes;
    private int quantity;
    private boolean isCompleted;
    private int id;

    KitchenTask(Procedure procedure) {
        this.procedure = procedure;
    }

    void assign(Shift shift, Cook cook, int minutes, int quantity) throws Exception {
        if(!cook.isAvailableFor(shift))
            throw new Exception("Not available");

        this.shift = shift;
        this.cook = cook;
        this.minutes = minutes;
        this.quantity = quantity;
    }

    void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public Shift getShift() {
        return shift;
    }

    public User getCook() {
        return cook;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getQuantity() {
        return quantity;
    }

    public static List<KitchenTask> loadTasksFor(int sheetId) {
        List<KitchenTask> result = new ArrayList<>();
        String query = "SELECT * FROM KitchenTasks WHERE id = " + sheetId +
                " ORDER BY priority";
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                Procedure procedure = Recipe.loadRecipeById(rs.getInt("procedures_id"));
                KitchenTask task = new KitchenTask(procedure);
                task.id = rs.getInt("id");
                task.minutes = rs.getInt("minutes");
                task.quantity = rs.getInt("quantity");
                task.isCompleted = rs.getInt("completed") != 0;
                task.shift = new Shift(rs.getString("shift_when"));
                task.cook = User.loadUserById(rs.getInt("cook_id"));
                result.add(task);
            }
        });
        return result;
    }


}
