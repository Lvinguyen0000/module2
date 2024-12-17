package service;

import utility.fileIO.HotelReadWriteFile;

import java.util.List;

public class HotelService {
    private static HotelService hotelService = null;

    private HotelService(){}

    public static HotelService getInstance(){
        if (hotelService == null){
            hotelService = new HotelService();
        }
        return hotelService;
    }

    public static final HotelReadWriteFile HOTEL_READ_WRITE_FILE = HotelReadWriteFile.getInstance();

    public String getHotelNameById(String id){
        return HOTEL_READ_WRITE_FILE.getHotelById(id);
    }

    public List<String> getPartnerHotelList(String id, int hotelToShow, int page){
        return HOTEL_READ_WRITE_FILE.readPartnerHotels(id, hotelToShow, page);
    }

    public List<String> getHotelList(int hotelToShow, int page){
        return HOTEL_READ_WRITE_FILE.readHotelsFromFile(hotelToShow, page);
    }
}
