package entities.user;

public class Partner extends User {
    public Partner(){}

    public Partner(String[] data) {
        super(data);
    }

    public Partner(User user) {
        super(user);
    }
}
