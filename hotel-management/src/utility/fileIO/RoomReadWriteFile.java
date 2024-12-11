package utility.fileIO;

import entities.room.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoomReadWriteFile extends ReadWriteFile{
    public static final String ROOM_INFO_PATH = System.getProperty("user.dir") + "\\data\\room\\room-info.txt";
    private static RoomReadWriteFile roomReadWriteFile = null;

    private RoomReadWriteFile(){}

    public static RoomReadWriteFile getInstance(){
        if (roomReadWriteFile == null){
            roomReadWriteFile = new RoomReadWriteFile();
        }
        return roomReadWriteFile;
    }

    public List<String> getRoomByHotelId(String hotelId, int roomToShow, int page){
        return readLinesToPageFormFileById(ROOM_INFO_PATH, roomToShow, page, hotelId);
    }

    public boolean isRoomExist(Room room){
        String stringByRoomName = findByString(ROOM_INFO_PATH, room.getName());
        String stringByHotelId = findByString(ROOM_INFO_PATH, room.getHotelId());
        return Objects.equals(stringByRoomName, stringByHotelId);
    }

    public void writeNewRoom(Room room){
        writeNewLineToFile(ROOM_INFO_PATH, room.exportToFile());
    }

    public List<String> readRoomsWithHotelId(String id, int roomToShow, int page){
        return readLinesToPageFormFileById(ROOM_INFO_PATH, roomToShow, page, id);
    }

    public String getRoomById (String id){
        return readLineById(ROOM_INFO_PATH, id);
    }

    public List<String> readRoomList (int roomToShow, int page){
        return readLinesToPageFromFile(ROOM_INFO_PATH, roomToShow, page);
    }

    public void editRoom (String roomId ,String exportedRoom){
        replaceById(ROOM_INFO_PATH, roomId, exportedRoom);
    }

    public boolean deleteRoomById (String roomId){
        return deleteById(ROOM_INFO_PATH, roomId);
    }

    public List<String> sortRoom(int minCap, int maxCap, long minPrice, long maxPrice, int roomToShow, int page){
        List<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(Objects.requireNonNull(getFile(ROOM_INFO_PATH))))) {
            int pageTraversed = 1;
            while ((line = br.readLine()) != null){
                if (list.size() == roomToShow){
                    if (pageTraversed == page){
                        return list;
                    }
                    list.clear();
                    pageTraversed++;
                }
                int roomCap = Integer.parseInt(line.split(",")[2]);
                long roomPrice = Long.parseLong(line.split(",")[4]);
                if (Math.min(roomCap, minCap) == minCap &&
                    Math.max(roomCap, maxCap) == maxCap &&
                    Math.min(roomPrice, minPrice) == minPrice &&
                    Math.max(roomPrice, maxPrice) == maxPrice)
                {
                    list.add(line);
                }
            }
        }
        catch (IOException e){
            System.out.println("Error reading file" + e.getMessage());
        }
        return list;
    }
}
