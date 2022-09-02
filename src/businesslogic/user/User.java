package businesslogic.user;

import businesslogic.UseCaseLogicException;
import businesslogic.event.EventInfo;
import businesslogic.shift.Shift;
import javafx.collections.FXCollections;
import persistence.PersistenceManager;
import persistence.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class User {

    protected static Map<Integer, User> loadedUsers = FXCollections.observableHashMap();

    public static enum Role {SERVIZIO, CUOCO, CHEF, ORGANIZZATORE}

    ;

    protected int id;
    protected String username;
    protected Set<Role> roles;
    protected ArrayList<Shift> availableForShifts;
    protected ArrayList<EventInfo> assignedEvents;

    public User() {
        id = 0;
        username = "";
        this.roles = new HashSet<>();
        availableForShifts = new ArrayList<>();
        assignedEvents = new ArrayList<>();
    }

    public Cook asCook() throws UseCaseLogicException {
        if (this.isRole(Role.CUOCO)) {
            Cook cook = new Cook();
            cook.id = this.id;
            cook.username = this.username;
            cook.roles = this.roles;
            cook.availableForShifts = this.availableForShifts;
            cook.assignedEvents = this.assignedEvents;
            return cook;
        }
        else{
            throw new UseCaseLogicException();
        }
    }

    public boolean isRole(Role role) {
        return roles.contains(role);
    }

    public ArrayList<EventInfo> getAssignedEvents() {
        return assignedEvents;
    }

    public void addAvailabilityFor(Shift shift) {
        availableForShifts.add(shift);
    }

    public boolean isAvailableFor(Shift shift) {
        return availableForShifts.contains(shift);
    }

    public String getUserName() {
        return username;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        String result = username;
        if (roles.size() > 0) {
            result += ": ";

            for (User.Role r : roles) {
                result += r.toString() + " ";
            }
        }

        result += " id: " + id;
        return result;
    }

    // STATIC METHODS FOR PERSISTENCE

    public static User loadUserById(int uid) {
        if (loadedUsers.containsKey(uid)) return loadedUsers.get(uid);

        User load = new User();
        String userQuery = "SELECT * FROM Users WHERE id='" + uid + "'";
        PersistenceManager.executeQuery(userQuery, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                load.id = rs.getInt("id");
                load.username = rs.getString("username");
            }
        });
        if (load.id > 0) {
            loadedUsers.put(load.id, load);
            String roleQuery = "SELECT * FROM UserRoles WHERE user_id=" + load.id;
            PersistenceManager.executeQuery(roleQuery, new ResultHandler() {
                @Override
                public void handle(ResultSet rs) throws SQLException {
                    String role = rs.getString("role_id");
                    switch (role.charAt(0)) {
                        case 'c':
                            load.roles.add(User.Role.CUOCO);
                            break;
                        case 'h':
                            load.roles.add(User.Role.CHEF);
                            break;
                        case 'o':
                            load.roles.add(User.Role.ORGANIZZATORE);
                            break;
                        case 's':
                            load.roles.add(User.Role.SERVIZIO);
                    }
                }
            });
        }
        return load;
    }

    public static User loadUser(String username) {
        User u = new User();
        String userQuery = "SELECT * FROM Users JOIN Events ON chef_id = Users.id WHERE username='" + username + "'";
        PersistenceManager.executeQuery(userQuery, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                u.id = rs.getInt("id");
                u.username = rs.getString("username");
                String n = rs.getString("name");
                EventInfo e = new EventInfo(n);
                e.setId(rs.getInt("id"));
                e.setDateStart(rs.getDate("date_start"));
                e.setDateEnd(rs.getDate("date_end"));
                e.setParticipants(rs.getInt("expected_participants"));
                int org = rs.getInt("organizer_id");
                e.setOrganizer(User.loadUserById(org));
                u.assignedEvents.add(e);
            }
        });
        if (u.id > 0) {
            loadedUsers.put(u.id, u);
            String roleQuery = "SELECT * FROM UserRoles WHERE user_id=" + u.id;
            PersistenceManager.executeQuery(roleQuery, new ResultHandler() {
                @Override
                public void handle(ResultSet rs) throws SQLException {
                    String role = rs.getString("role_id");
                    switch (role.charAt(0)) {
                        case 'c':
                            u.roles.add(User.Role.CUOCO);
                            break;
                        case 'h':
                            u.roles.add(User.Role.CHEF);
                            break;
                        case 'o':
                            u.roles.add(User.Role.ORGANIZZATORE);
                            break;
                        case 's':
                            u.roles.add(User.Role.SERVIZIO);
                    }
                }
            });
        }
        return u;
    }
}
