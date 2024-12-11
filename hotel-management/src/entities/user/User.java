package entities.user;

import utility.ExportFile;

public abstract class User implements ExportFile{
    private String id;
    private String name;
    private String dob;
    private String phoneNumber;
    private String email;
    private String address;
    private String role;

    public User(){}

    public User(String[] data) {
        this.id = data[0];
        this.name = data[1];
        this.dob = data[2];
        this.phoneNumber = data[3];
        this.email = data[4];
        this.address = data[5];
        this.role = data[6];
    }

    public User (User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.dob = user.getDob();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.role = user.getRole();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String exportToFile(){
        return id + "," + name + "," + dob + "," + phoneNumber + "," + email + " ," + address + "," + role;
    }


    @Override
    public String toString() {
        return "Name: " + this.getName() +
                "\nDate of brith: " + this.getDob() +
                "\nPhone number: " + this.getPhoneNumber() +
                "\nEamil: " + this.getEmail() +
                "\nAddress: " + this.getAddress();
    }
}
