package controller;

import service.BookingService;
import utility.EmailHandler;
import utility.ExcelExport;
import utility.NumberGetter;
import utility.fileIO.UserReadWriteFile;
import entities.booking.Booking;
import entities.room.Room;
import entities.user.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingController {
    public static final UserReadWriteFile USER_READ_WRITE_FILE = UserReadWriteFile.getInstance();
    public static final UserController USER_CONTROLLER = UserController.getInstance();
    public static final BookingService BOOKING_SERVICE = BookingService.getInstance();
    private final Scanner sc = new Scanner(System.in);
    private User currentUser = null;
    private final int BOOKING_TO_SHOW = 10;
    private static BookingController bookingController = null;

    private BookingController(){}

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public static BookingController getInstance(){
        if (bookingController == null){
            bookingController = new BookingController();
        }
        return bookingController;
    }

    public void showBookingOption(Room room){
        int choice = -1;

        do {
            System.out.println("Please choose on option below");
            System.out.println("1. Book room");
            System.out.println("2. Use discount to book room");
            System.out.println("3. Go back");

            choice = NumberGetter.getInstance().getInt();

            switch (choice){
                case 1:
                    bookRoomOption(room);
                    break;
                case 2:
                    //TODO: add upcoming discount feature
                    break;
                default:
                    break;
            }
        }
        while (choice != 3);
    }

    public void bookRoomOption(Room room){
        long userFund = USER_READ_WRITE_FILE.getUserFunding(currentUser.getId());
        long roomPrice = room.getPrice();
        System.out.println("Your current funding: " + userFund);
        System.out.println("Room price: " + roomPrice);

        System.out.println("1. Book this room");
        System.out.println("Press any button to go back");

        try {
            if (NumberGetter.getInstance().getInt() == 1) {
                if (userFund < roomPrice) {
                    System.out.println("Can't book this room");
                    USER_CONTROLLER.checkFunding(currentUser);
                    bookRoomOption(room);
                }
                bookRoom(room);
            }
        }
        catch (NumberFormatException e){
            System.out.println("Please enter a number, not " + e.getMessage());
        }

    }

    public void bookRoom(Room room){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate, endDate;
        String tempStrDate;

        try {
            System.out.println("Enter start date");
            tempStrDate = BOOKING_SERVICE.enterDate();

            startDate = sdf.parse(tempStrDate);

//            System.out.println("Enter end date");
            System.out.println("Enter end date or number of staying days");
            tempStrDate = BOOKING_SERVICE.enterDate();

            if (BOOKING_SERVICE.isInteger(tempStrDate)) {
                endDate = BOOKING_SERVICE.addDays(startDate, Integer.parseInt(tempStrDate));
            }
            else{
                endDate = sdf.parse(tempStrDate);
            }

            if (!BookingService.checkDateRange(startDate, endDate)) return;

            Booking booking = new Booking(currentUser.getId(), room.getId(), startDate, endDate, false);
            BookingService.checkBooking(booking, room);
        }
        catch(ParseException e){
            System.out.println("Can't convert to date" + e.getMessage());
        }

    }

    public void showUserBookingOption(){
        int choice = -1;

        do{
            System.out.println("1. See booking information");
            System.out.println("2. Export excel file to local");
            System.out.println("3. Send excel file to email");
            System.out.println("4. Go back");

            choice = NumberGetter.getInstance().getInt();

            switch (choice){
                case 1:
                    showUserBookingInfo(1);
                    break;
                case 2:
                    ExcelExport.getInstance().exportUserBooking(currentUser);
                    break;
                case 3:
                    EmailHandler.getInstance().sendExcelFileAsync(currentUser.getEmail(), currentUser);
                    break;
                default:
                    break;
            }
        }while (choice != 4);
    }

    public void showUserBookingInfo(int currentPage){
        int choice = -1;

        List<String> list = BOOKING_SERVICE.getUserBookingInfo(currentUser.getId(), BOOKING_TO_SHOW, currentPage);
        int i;
        for (i = 0; i < list.size(); i++){
            System.out.println(i + ". " + Arrays.toString(list.get(i).split(",")));
        }

        System.out.println("---------------------------------------------------------");
        System.out.println(i + ". Previous page");
        i++;
        System.out.println(i + ". Next page");
        i++;
        System.out.println(i + ". Go back");

        choice = NumberGetter.getInstance().getInt();

        if (choice == i){
            return;
        }
        else if (choice == i - 1){
            if (list.size() < BOOKING_TO_SHOW){
                System.out.println("No more booking to show");
            }
            else {
                showUserBookingInfo(++currentPage);
            }
        } else if (choice == i - 2) {
            if (currentPage == 1){
                System.out.println("Can't go to previous page");
            }
            else {
                showUserBookingInfo(--currentPage);
            }
        } else if (choice < list.size() && choice >= 0) {
            String[] bookingInfo = list.get(choice).split(",");
            deleteBookingOption(bookingInfo[0]);

        }
        else {
            showUserBookingInfo(currentPage);
        }
    }

    public void deleteBookingOption(String bookingId){
        System.out.println("Delete this booking? (y/n");
        String choice = sc.nextLine();

        if (Objects.equals(choice, "y")){
            BOOKING_SERVICE.deleteBookingById(bookingId);
        }
        else if (!(Objects.equals(choice, "n"))){
            deleteBookingOption(bookingId);
        }
    }
}
