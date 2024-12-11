package utility;

import utility.fileIO.BookingReadWriteFile;
import utility.fileIO.HotelReadWriteFile;
import utility.fileIO.RoomReadWriteFile;
import entities.booking.Booking;
import entities.hotel.Hotel;
import entities.room.Room;
import entities.user.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelExport {
    public static final String BOOKING_EXPORT_PATH = System.getProperty("user.dir") + "\\data\\excel\\booking.xlsx";
    public static final XSSFWorkbook WORKBOOK = new XSSFWorkbook();
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static ExcelExport excelExport = null;

    private ExcelExport(){}

    public static ExcelExport getInstance(){
        if (excelExport == null){
            excelExport = new ExcelExport();
        }
        return excelExport;
    }

    private void deleteSheet (String sheetName){
        int sheetIndex = WORKBOOK.getSheetIndex(sheetName); // Replace with your sheet name
        if (sheetIndex != -1) {
            WORKBOOK.removeSheetAt(sheetIndex);
        }
    }

    public void exportUserBooking(User user) {
        List<Booking> bookingInfo = getBookingListFromUser(user);
        List<Room> roomInfo = getRoomListFromBooking(bookingInfo);
        List<Hotel> hotelInfo = getHotelListFromRoom(roomInfo);
        Map<String, Object[]> data = createBookingData(bookingInfo, roomInfo, hotelInfo);

        deleteSheet("Booking information of " + user.getName());

        XSSFSheet sheet = WORKBOOK.createSheet("Booking information of " + user.getName());
        writeToSheet(data, sheet);

        try {
            FileOutputStream out = new FileOutputStream(new File(BOOKING_EXPORT_PATH));
            WORKBOOK.write(out);
            out.close();
            System.out.println("booking.xlsx written successfully on disk.");
        }
        catch (IOException e) {
            System.out.println("Error exporting" + e.getMessage());
        }
    }

    private Map<String, Object[]> createBookingData(List<Booking> bookingInfo, List<Room> roomInfo, List<Hotel> hotelInfo) {
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"Booking ID", "Hotel", "Address", "Room", "Room capacity", "Start date", "End Date", "Pricing"});

        for (int i = 0; i < bookingInfo.size(); i++){
            String sheetId = String.valueOf(i + 2);
            Booking tempBooking = bookingInfo.get(i);
            Room tempRoom = roomInfo.get(i);
            Hotel tempHotel = hotelInfo.get(i);

            Object[] object = new Object[] {tempBooking.getBookingId(), tempHotel.getName(), tempHotel.getAddress(), tempRoom.getName(), tempRoom.getCapacity(), sdf.format(tempBooking.getStartDate()), sdf.format(tempBooking.getEndDate()), String.valueOf(tempRoom.getPrice())};

            data.put(sheetId, object);
        }
        return data;
    }

    private void writeToSheet(Map<String, Object[]> data, XSSFSheet sheet) {
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {

            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
    }

    private List<Hotel> getHotelListFromRoom(List<Room> roomInfo) {
        List<Hotel> hotelInfo = new ArrayList<>();
        for (Room room: roomInfo){
            String hotel = HotelReadWriteFile.getInstance().getHotelById(room.getHotelId());
            hotelInfo.add(new Hotel(hotel));
        }
        return hotelInfo;
    }

    private List<Room> getRoomListFromBooking(List<Booking> bookingInfo) {
        List<Room> roomInfo = new ArrayList<>();
        for (Booking booking: bookingInfo){
            String room = RoomReadWriteFile.getInstance().getRoomById(booking.getRoomId());
            roomInfo.add(new Room(room));
        }
        return roomInfo;
    }

    private List<Booking> getBookingListFromUser(User user) {
        List<String> tempList = BookingReadWriteFile.getInstance().getAllBookingByUserId(user.getId());
        List<Booking> bookingInfo = new ArrayList<>();

        for (String str: tempList){
            bookingInfo.add(new Booking(str));
        }
        return bookingInfo;
    }
}
