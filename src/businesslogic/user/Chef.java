package businesslogic.user;

public class Chef extends User {
    public Chef() throws Exception {
        super();

        if (!this.isRole(Role.CHEF)) {
            throw new Exception("Is not a chef");
        }
    }
}
