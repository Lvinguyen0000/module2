package entities;

public class PhoneBooking {
    private String phoneNumber;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String dob;
    private String email;

    public PhoneBooking(String phoneNumber, String group, String name, String gender, String address, String dob, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.email = email;
    }

    public PhoneBooking(String[] data){
        this.phoneNumber = data[0];
        this.group = data[1];
        this.name = data[2];
        this.gender = data[3];
        this.address = data[4];
        this.dob = data[5];
        this.email = data[6];
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String exportToFile(){
        return phoneNumber + ";" + group + ";" + name + ";" + gender + ";" + address + ";" + dob + ";" + email;
    }

    @Override
    public String toString() {
        return "PhoneBooking{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
