package service;

import entities.room.Room;
import utility.fileIO.BookingReadWriteFile;
import entities.booking.Booking;
import utility.validation.DateValidation;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static run.Main.sc;

public class BookingService {
    private static final BookingReadWriteFile BOOKING_READ_WRITE_FILE = BookingReadWriteFile.getInstance();
    private static BookingService bookingService = null;

    private BookingService(){}

    public static BookingService getInstance(){
        if (bookingService == null){
            bookingService = new BookingService();
        }
        return bookingService;
    }

    public static boolean addBooking(Booking booking){
        List<String> list = BOOKING_READ_WRITE_FILE.getBookingsById(booking.getRoomId());

        for (String tempBooking: list){
            if (booking.overlapDate(new Booking(tempBooking))){
                return false;
            }
        }

        BOOKING_READ_WRITE_FILE.addBookingToFile(booking);
        return true;
    }

    public List<String> getUserBookingInfo (String id, int hotelToShow, int page){
        return BOOKING_READ_WRITE_FILE.readBookingsFromFile(id, hotelToShow, page);
    }

    public void deleteBookingByRoomId (String roomId){
        BOOKING_READ_WRITE_FILE.deleteBookingByRoomId(roomId);
    }

    public void deleteBookingById (String bookingId){BOOKING_READ_WRITE_FILE.deleteBookingById(bookingId);}

    public static boolean checkDateRange(Date startDate, Date endDate) {
        if (startDate.after(endDate)) {
            System.out.println("Invalid day range");
            return false;
        }
        return true;
    }

    public String enterDate() {
        String tempStrDate;
        tempStrDate = sc.nextLine();
        while (!(DateValidation.getInstance().validate(tempStrDate)) || isInteger(tempStrDate)) {
            System.out.println("Invalid date");
            tempStrDate = sc.nextLine();
        }
        return String.valueOf(tempStrDate);
    }

    public static void checkBooking(Booking booking, Room room) {
        if (addBooking(booking)){
            UserService.getInstance().addFund(booking.getUserId(), room.getPrice() * -1);

            System.out.println("Booking successfully");
        }
        else{
            System.out.println("Booking fail, please change the booking date");
        }
    }

    public boolean isInteger (String str){
        try {
            Integer.parseInt(str);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public Date addDays(Date start, int daysToAdd){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
        return calendar.getTime();
    }
}
