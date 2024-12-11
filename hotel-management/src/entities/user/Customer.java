package entities.user;

public class Customer extends User {
    public Customer(){}

    public Customer(String[] data) {
        super(data);
    }

    public Customer(User user) {
        super(user);
    }
}
