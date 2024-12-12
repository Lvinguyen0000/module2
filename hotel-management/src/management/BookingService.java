package management;

import utility.fileIO.BookingReadWriteFile;
import entities.booking.Booking;

import java.util.List;

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

    public boolean addBooking (Booking booking){
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
}
