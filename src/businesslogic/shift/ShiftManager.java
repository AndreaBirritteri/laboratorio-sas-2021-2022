package businesslogic.shift;

import persistence.PersistenceManager;

import java.util.List;

public class ShiftManager {

    public static void updateIsCompleted(Shift shift) {
        String upd = "UPDATE Shifts SET completed = " + (shift.isCompleted() ? 1 : 0) +
                " WHERE Shifts.when = '" + shift.getDatetime()+ '\'';
        PersistenceManager.executeUpdate(upd);
    }

    public List<Shift> getShiftTable() {
        return ShiftTable.getShifts();
    }

}
