package businesslogic.user;

public class Chef extends User {
    Chef() throws Exception {
        super();

        if (!this.isChef()) {
            throw new Exception("Is not a chef");
        }
    }
}
