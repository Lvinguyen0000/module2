package entities.user;

public class Admin extends User {
    public Admin(){}

    public Admin(String[] data) {
        super(data);
    }

    public Admin(User user) {
        super(user);
    }
}
