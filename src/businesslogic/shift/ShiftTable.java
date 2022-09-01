package businesslogic.shift;

import persistence.PersistenceManager;

import java.util.ArrayList;

public class ShiftTable {
    public static ArrayList<Shift> getShifts() {
        ArrayList<Shift> shifts = new ArrayList<>();
        String userQuery = "SELECT * FROM Shifts";
        PersistenceManager.executeQuery(userQuery, rs -> {
            Shift shift = new Shift(rs.getString("when"));
            shift.setCompleted(rs.getInt("completed") != 0);
            shifts.add(shift);
        });
        return shifts;
    }
}
