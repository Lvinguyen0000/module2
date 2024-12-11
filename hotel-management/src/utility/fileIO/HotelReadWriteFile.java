package utility.fileIO;

import entities.hotel.Hotel;

import java.util.List;
import java.util.Objects;

public class HotelReadWriteFile extends ReadWriteFile {
    public static final String HOTEL_INFO_PATH = System.getProperty("user.dir") + "\\data\\hotel\\hotel-info.txt";
    private static HotelReadWriteFile hotelReadWriteFile = null;

    private HotelReadWriteFile(){}

    public static HotelReadWriteFile getInstance(){
        if (hotelReadWriteFile == null){
            hotelReadWriteFile = new HotelReadWriteFile();
        }
        return hotelReadWriteFile;
    }

    public void writeNewHotel(Hotel hotel){
        writeNewLineToFile(HOTEL_INFO_PATH, hotel.exportToFile());
    }

    public String getHotelById(String id){
        return readLineById(HOTEL_INFO_PATH, id);
    }

    public boolean isHotelExist(Hotel hotel){
        String stringByHotelName = findByString(HOTEL_INFO_PATH, hotel.getName());
        String stringByHotelAddress = findByString(HOTEL_INFO_PATH, hotel.getAddress());
        return Objects.equals(stringByHotelName, stringByHotelAddress);
    }

    public List<String> readPartnerHotels(String id, int hotelToShow, int page){
        return readLinesToPageFormFileById(HOTEL_INFO_PATH, hotelToShow, page, id);
    }

    public List<String> readHotelsFromFile(int maxLine, int page){
        return readLinesToPageFromFile(HOTEL_INFO_PATH, maxLine, page);
    }
}
