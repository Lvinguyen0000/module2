package menu;

import entities.PhoneBooking;
import management.PhoneBookingManagement;
import utility.InputGetter;
import utility.ReadWriteFile;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class OperationMenu {
    private final int NUMBER_TO_SHOW = 5;

    private static OperationMenu operationMenu = null;

    private OperationMenu(){}

    public static OperationMenu getInstance(){
        if (operationMenu == null){
            operationMenu = new OperationMenu();
        }
        return operationMenu;
    }

    public void viewMenu(int page){
        int choice = -1;

        List<PhoneBooking> list = PhoneBookingManagement.getInstance().getInfoByPage(NUMBER_TO_SHOW, page);

        int i;

        for (i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        System.out.println("--------------------------------------");
        System.out.println(++i + ". Previous page");
        System.out.println(++i + ". Next page");
        System.out.println(++i + ". Go back");

        choice = InputGetter.getInstance().getInt();

        if (choice == i){
            return;
        }
        else if (choice == i - 1){
            if (list.size() < NUMBER_TO_SHOW){
                System.out.println("Can't go to next page");
            }
            else viewMenu(++page);
        }
        else if (choice == i - 2){
            if (page == 1){
                System.out.println("Can't go to previous page");
            }
            else{
                viewMenu(--page);
            }
        }
        else viewMenu(page);
    }

    public void addMenu(){
        String phone = enterPhone();

        String group = enterGroup();

        String name = enterName();

        String gender = enterGender();

        String address = enterAdress();

        String dob = enterDob();

        String email = enterEmail();

        PhoneBookingManagement.getInstance().addInformation(new PhoneBooking(phone, group, name, gender, address, dob, email));
    }

    private static String enterEmail() {
        System.out.println("Email");
        String email = InputGetter.getInstance().getEmail();
        return email;
    }

    private static String enterDob() {
        System.out.println("Enter date of birth");
        String dob = InputGetter.getInstance().getString();
        return dob;
    }

    private static String enterAdress() {
        System.out.println("Enter address");
        String address = InputGetter.getInstance().getString();
        return address;
    }

    private static String enterGender() {
        System.out.println("Enter gender");
        String gender = InputGetter.getInstance().getString();
        return gender;
    }

    private static String enterName() {
        System.out.println("Enter name");
        String name = InputGetter.getInstance().getString();
        return name;
    }

    private static String enterGroup() {
        System.out.println("Enter phone group");
        String group = InputGetter.getInstance().getString();
        return group;
    }

    private static String enterPhone() {
        System.out.println("Enter phone number");
        String phone = InputGetter.getInstance().getPhoneNumber();
        return phone;
    }

    public void updateMenu(){
        System.out.println("Enter phone number for updating");

        String phone = new Scanner(System.in).nextLine();

        if (Objects.equals("", phone)) return;

        PhoneBooking phoneBooking = PhoneBookingManagement.getInstance().getByPhone(phone);

        if (phoneBooking == null) {
            System.out.println("Unavailable phone number, please try again");
            updateMenu();
        }

        update(phoneBooking);
    }

    public void update(PhoneBooking phoneBooking){
        int choice = -1;

        do{
            System.out.println("Which information do you want to update?");
            System.out.println("1. Phone group (" + phoneBooking.getGroup() + ")");
            System.out.println("2. Name (" + phoneBooking.getName() + ")");
            System.out.println("3. Gender (" + phoneBooking.getGender() + ")");
            System.out.println("4. Address (" + phoneBooking.getAddress() + ")");
            System.out.println("5. Date of brith (" + phoneBooking.getDob() + ")");
            System.out.println("6. Email (" + phoneBooking.getEmail() + ")");
            System.out.println("7 .Go back");

            choice = InputGetter.getInstance().getInt();

            switch (choice){
                case 1:
                    String group = enterGroup();
                    phoneBooking.setGroup(group);
                    break;
                case 2:
                    String name = enterName();
                    phoneBooking.setName(name);
                    break;
                case 3:
                    String gender = enterGender();
                    phoneBooking.setGender(gender);
                    break;
                case 4:
                    String address = enterAdress();
                    phoneBooking.setAddress(address);
                    break;
                case 5:
                    String dob = enterDob();
                    phoneBooking.setDob(dob);
                    break;
                case 6:
                    String email = enterEmail();
                    phoneBooking.setEmail(email);
                    break;
                default:
                    break;
            }
        }
        while (choice != 7);
    }

    public void deleteMenu(){
        int choice = -1;
        System.out.println("Enter phone number for deleting");

        String phone = new Scanner(System.in).nextLine();

        if (Objects.equals("", phone)) return;

        PhoneBooking phoneBooking = PhoneBookingManagement.getInstance().getByPhone(phone);

        if (phoneBooking == null) {
            System.out.println("Unavailable phone number, please try again");
            updateMenu();
        }

        PhoneBookingManagement.getInstance().deleteInformation(phone);
        System.out.println("Delete successfully");
    }

    public void readFileMenu(){
        int choice = -1;

        do{
            System.out.println("Warning: this will delete all data in current memory");
            System.out.println("1. Read file");
            System.out.println("2. Go back");

            choice = InputGetter.getInstance().getInt();

            if (choice == 1){
                List<String> fileList = ReadWriteFile.readFile();
                if (fileList != null){
                    PhoneBookingManagement.getInstance().clearList();
                    for (String str: fileList){
                        PhoneBookingManagement.getInstance().addInformation(new PhoneBooking(str.split(";")));
                    }
                }
            }

        }while (choice != 2);
    }

    public void writeFile(){
        List<PhoneBooking> list = PhoneBookingManagement.getInstance().getList();

        for (PhoneBooking phoneBooking: list){
            ReadWriteFile.writeNewLineToFile(phoneBooking.exportToFile());
        }
    }

    public void findMenu(){
        System.out.println("Enter phone number or name");

        String str = new Scanner(System.in).nextLine();

        if (Objects.equals("", str)) return;

        PhoneBooking phoneBooking = PhoneBookingManagement.getInstance().getByPhone(str);

        if (phoneBooking != null) {
            System.out.println(phoneBooking);
            return;
        }

        phoneBooking = PhoneBookingManagement.getInstance().getByName(str);

        if (phoneBooking != null) {
            System.out.println(phoneBooking);
            return;
        }

        else System.out.println("Can't find information");
    }
}
