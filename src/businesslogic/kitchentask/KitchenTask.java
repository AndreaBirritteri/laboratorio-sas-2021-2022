package businesslogic.kitchentask;

import businesslogic.UseCaseLogicException;
import businesslogic.preparation.Instruction;
import businesslogic.preparation.Recipe;
import businesslogic.shift.Shift;
import businesslogic.user.User;
import persistence.PersistenceManager;
import persistence.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KitchenTask {
    private final Instruction instruction;
    private Shift shift;
    private User cook;
    private int minutes;
    private int quantity;
    private boolean isCompleted;
    int id;

    KitchenTask(Instruction instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "\nKitchenTask{" +
                "procedure=" + instruction +
                ", shift=" + shift +
                ", cook=" + cook +
                ", minutes=" + minutes +
                ", quantity=" + quantity +
                ", isCompleted=" + isCompleted +
                ", id=" + id +
                '}';
    }

    void assign(Shift shift, User user, int minutes, int quantity) throws Exception {
        if (!user.isAvailableFor(shift))
            throw new UseCaseLogicException();

        this.shift = shift;
        this.cook = user;
        this.minutes = minutes;
        this.quantity = quantity;
    }

    void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Instruction getInstruction() {
        return instruction;
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

    public static ArrayList<KitchenTask> loadTasksFor(int sheetId) {
        ArrayList<KitchenTask> result = new ArrayList<>();
        String query = "SELECT * FROM KitchenTasks WHERE id = " + sheetId +
                " ORDER BY position";
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                Instruction instruction = Recipe.loadRecipeById(rs.getInt("procedure_id"));
                KitchenTask task = new KitchenTask(instruction);
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

    public static void addTask(KitchenSheet sheet, KitchenTask taskToAdd, int posInKitchenSheet) {
        String query = "INSERT INTO catering.KitchenTasks (completed, kitchen_sheet_id, procedure_id, position) VALUES (" +
                taskToAdd.isCompleted() + ", " +
                sheet.getId() + ", " +
                taskToAdd.getInstruction().getId() + ", " +
                posInKitchenSheet +
                ");";
        PersistenceManager.executeUpdate(query);
        taskToAdd.id = PersistenceManager.getLastId();
    }

    public static void deleteTask(KitchenTask task) {
        String query = "DELETE FROM KitchenTasks WHERE id = " + task.id;
        PersistenceManager.executeUpdate(query);
    }

}
