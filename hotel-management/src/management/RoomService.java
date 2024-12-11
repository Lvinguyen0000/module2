package management;

import utility.fileIO.RoomReadWriteFile;
import entities.room.Room;

import java.util.List;

public class RoomService {
    public static final RoomReadWriteFile ROOM_READ_WRITE_FILE = RoomReadWriteFile.getInstance();
    private static RoomService roomService = null;

    private RoomService(){}

    public static RoomService getInstance(){
        if (roomService == null){
            roomService = new RoomService();
        }
        return roomService;
    }

    public List<String> getRoomListByHotelId(String hotelId, int roomToShow, int page){
        return ROOM_READ_WRITE_FILE.readRoomsWithHotelId(hotelId, roomToShow, page);
    }

    public List<String> getRoomList(int roomToShow, int page){
        return ROOM_READ_WRITE_FILE.readRoomList(roomToShow, page);
    }

    public void editRoom (Room room){
        ROOM_READ_WRITE_FILE.editRoom(room.getId(), room.exportToFile());
    }

    public boolean deleteRoomById (String roomId){
        boolean result =  ROOM_READ_WRITE_FILE.deleteRoomById(roomId);
        if (result){
            BookingService.getInstance().deleteBookingByRoomId(roomId);
            return true;
        }
        return false;
    }

    public List<String> sortRoom (int minCap, int maxCap, long minPrice, long maxPrice, int roomToShow, int page){
        return ROOM_READ_WRITE_FILE.sortRoom(minCap, maxCap, minPrice, maxPrice, roomToShow, page);
    }
}
