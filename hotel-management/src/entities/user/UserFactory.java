package entities.user;

public class UserFactory {
    public static User getUser(String[] data){
        return switch (data[data.length-1]) {
            case "admin" -> new Admin(data);
            case "customer" -> new Customer(data);
            case "partner" -> new Partner(data);
            default -> null;
        };
    }
}
