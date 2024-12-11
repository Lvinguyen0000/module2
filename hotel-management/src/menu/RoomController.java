package menu;

import management.HotelService;
import management.RoomService;
import utility.NumberGetter;
import utility.fileIO.RoomReadWriteFile;
import entities.hotel.Hotel;
import entities.room.Room;
import entities.user.User;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RoomController {
    public static final RoomReadWriteFile ROOM_READ_WRITE_FILE = RoomReadWriteFile.getInstance();
    public static final HotelService HOTEL_SERVICE = HotelService.getInstance();
    public static final RoomService ROOM_SERVICE = RoomService.getInstance();
    private final Scanner sc = new Scanner(System.in);
    private static final int ROOM_TO_SHOW = 10;
    private User currentUser = null;
    private Hotel currentHotel = null;
    private  static RoomController roomController = null;

    private RoomController(){}

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setCurrentHotel(Hotel currentHotel) {
        this.currentHotel = currentHotel;
    }

    public static RoomController getInstance(){
        if (roomController == null){
            roomController = new RoomController();
        }
        return roomController;
    }

    public void partnerRoomOption(){
        int choice = -1;

        do{
            System.out.println("Please choose an option for the chosen hotel");
            System.out.println("1. Add room");
            System.out.println("2. Show all rooms of current hotel");
            System.out.println("3. Go back to hotel main screen");

            choice = NumberGetter.getInstance().getInt();

            switch(choice){
                case 1:
                    addRoom();
                    break;
                case 2:
                    showRoomListOfHotel(1, false, true);
                    break;
                default:
                    break;
            }
        }
        while(choice != 3);
    }

    private void addRoom(){
        Room room;

        do{
            System.out.println("Enter room name:");
            String name = sc.nextLine();
            System.out.println("Enter room capacity");
            int capacity = NumberGetter.getInstance().getInt();
            System.out.println("Enter room price:");
            long price = NumberGetter.getInstance().getLong();

            room = new Room(name, capacity, currentHotel.getId(), price);
        }
        while (Objects.equals(room.getName(), "") && ROOM_READ_WRITE_FILE.isRoomExist(room));
        ROOM_READ_WRITE_FILE.writeNewRoom(room);
    }

    private void printRoom(String roomData){
        String[] spiltRoomData = roomData.split(",");
        String hotelName = HOTEL_SERVICE.getHotelNameById(spiltRoomData[3]).split(",")[1];
        System.out.println("Room: " + spiltRoomData[1] + ", id: " + spiltRoomData[0] + ", capacity: " + spiltRoomData[2] + ", price: " + spiltRoomData[4] + " | Hotel: " + hotelName);
    }

    public void showRoomListOfHotel(int currentPage, boolean isGuest, boolean isPartner){
        int choice = -1;

        List<String> list = ROOM_SERVICE.getRoomListByHotelId(currentHotel.getId(), ROOM_TO_SHOW, currentPage);
        int i;
        for (i = 0; i < list.size(); i++){
            System.out.print(i + ". ");
            printRoom(list.get(i));
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
            if (list.size() < ROOM_TO_SHOW){
                System.out.println("No more room to show");
            }
            else {
                showRoomListOfHotel(++currentPage, isGuest, isPartner);
            }
        } else if (choice == i - 2) {
            if (currentPage == 1){
                System.out.println("Can't go to previous page");
            }
            else {
                showRoomListOfHotel(--currentPage, isGuest, isPartner);
            }
        } else if (choice < list.size() && choice >= 0) {
            if (!isGuest) {
                String roomInfo = list.get(choice);
                Room room = new Room(roomInfo);

                if (isPartner) {
                    editRoomOption(room);
                } else {
                    BookingController bc = BookingController.getInstance();
                    bc.setCurrentUser(currentUser);
                    bc.showBookingOption(room);
                }
            }
            else {
                System.out.println("---------------------------------------------------------");
                System.out.println("Can't book the room, please login first");
                System.out.println("---------------------------------------------------------");
                showRoomListOfHotel(currentPage, isGuest, isPartner);
            }
        }
        else {
            showRoomListOfHotel(currentPage, isGuest, isPartner);
        }
    }

    public void editRoomOption(Room room){
        int choice = -1;

        do {
            System.out.println("Choose an option for the current room");
            System.out.println("1. Edit");
            System.out.println("2. Delete");
            System.out.println("3. Go back");

            choice = NumberGetter.getInstance().getInt();

            switch (choice){
                case 1:
                    editRoom(room);
                    break;
                case 2:
                    deleteRoomById(room);
                    break;
                default:
                    break;
            }
        } while(choice != 3);
    }

    private void editRoom(Room room){
        System.out.println("Enter new room name");
        String newName = sc.nextLine();
        boolean doEdit = false;

        if (!"".equals(newName)){
            room.setName(newName);
            doEdit = true;
        }

        try{
            System.out.println("Enter new capacity (-1 to don't change)");
            int newCap = NumberGetter.getInstance().getInt();
            System.out.println("Enter new price (-1 to don't change)");
            long newPrice = NumberGetter.getInstance().getInt();

            if (newCap < -1 || newPrice < -1) {
                throw new NumberFormatException();
            }

            if (newCap != -1) {
                room.setCapacity(newCap);
                doEdit = true;
            }
            if (newPrice != -1) {
                room.setPrice(newPrice);
                doEdit = true;
            }

        }catch (NumberFormatException e){
            System.out.println("All field should be positive number, not " + e.getMessage());
        }
        if (doEdit) ROOM_SERVICE.editRoom(room);
    }

    private void deleteRoomById(Room room){
        if (ROOM_SERVICE.deleteRoomById(room.getId())){
            System.out.println("Delete successfully");
        }
        else{
            System.out.println("Can't delete room");
        }

    }

    public void sortAllRoomsOption (){
        System.out.println("Please enter capacity and room pricing range (0 to set to no requirement");
        System.out.println("Enter minimum capacity");
        int minCap = Math.abs(NumberGetter.getInstance().getInt());
        System.out.println("Enter maximum capacity");
        int maxCap = Math.abs(NumberGetter.getInstance().getInt());
        System.out.println("Enter minimum price");
        long minPrice = Math.abs(NumberGetter.getInstance().getLong());
        System.out.println("Enter maximum price");
        long maxPrice = Math.abs(NumberGetter.getInstance().getLong());

        if (maxCap == 0) maxCap = Integer.MAX_VALUE;
        if (maxPrice == 0) maxPrice = Long.MAX_VALUE;

        if (minCap > maxCap){
            int temp = minCap;
            minCap = maxCap;
            maxCap = temp;
        }
        if (minPrice > maxPrice){
            long temp = minPrice;
            minPrice = maxPrice;
            maxPrice = temp;
        }

        sortAllRoom(minCap, maxCap, minPrice, maxPrice, 1);

    }

    public void sortAllRoom (int minCap, int maxCap, long minPrice, long maxPrice, int currentPage){
        int choice = -1;

        List<String> list = ROOM_SERVICE.sortRoom(minCap, maxCap, minPrice, maxPrice, ROOM_TO_SHOW, currentPage);
        int i;
        for (i = 0; i < list.size(); i++){
            System.out.print(i + ". ");
            printRoom(list.get(i));
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
            if (list.size() < ROOM_TO_SHOW){
                System.out.println("No more room to show");
            }
            else {
                sortAllRoom(minCap, maxCap, minPrice, maxPrice, ++currentPage);
            }
        } else if (choice == i - 2) {
            if (currentPage == 1){
                System.out.println("Can't go to previous page");
            }
            else {
                sortAllRoom(minCap, maxCap, minPrice, maxPrice, --currentPage);
            }
        } else if (choice < list.size() && choice >= 0) {
            String roomInfo = list.get(choice);
            BookingController bc = BookingController.getInstance();
            bc.setCurrentUser(currentUser);
            bc.showBookingOption(new Room(roomInfo));
        }
        else {
            sortAllRoom(minCap, maxCap, minPrice, maxPrice, currentPage);
        }
    }
}
