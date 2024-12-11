package utility.fileIO;

import entities.booking.Booking;

import java.util.List;

public class BookingReadWriteFile extends ReadWriteFile{
    public static final String BOOKING_INFO_PATH = System.getProperty("user.dir") + "\\data\\room\\booking-info.txt";
    private static BookingReadWriteFile bookingReadWriteFile = null;

    private BookingReadWriteFile(){}

    public static BookingReadWriteFile getInstance(){
        if (bookingReadWriteFile == null){
            bookingReadWriteFile = new BookingReadWriteFile();
        }
        return bookingReadWriteFile;
    }

    public List<String> getBookingsById (String id){
        return getAllLinesById(BOOKING_INFO_PATH, id);
    }

    public void addBookingToFile (Booking booking){
        writeNewLineToFile(BOOKING_INFO_PATH, booking.exportToFile());
    }

    public List<String> readBookingsFromFile (String id ,int bookingToShow, int page){
        return readLinesToPageFormFileById(BOOKING_INFO_PATH, bookingToShow, page, id);
    }

    public List<String> getAllBookingByUserId (String id){
        return getAllLinesById(BOOKING_INFO_PATH, id);
    }

    public void deleteBookingByRoomId(String id){
        deleteById(BOOKING_INFO_PATH, id);
    }
}
