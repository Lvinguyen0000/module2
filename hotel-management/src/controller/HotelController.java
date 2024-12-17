package controller;

import service.HotelService;
import utility.NumberGetter;
import utility.fileIO.HotelReadWriteFile;
import entities.hotel.Hotel;
import entities.user.User;

import java.util.List;
import java.util.Objects;

import static run.Main.sc;

public class HotelController {
    public static final HotelService HOTEL_SERVICE = HotelService.getInstance();
    public static final HotelReadWriteFile HOTEL_READ_WRITE_FILE = HotelReadWriteFile.getInstance();
    private static final int HOTEL_TO_SHOW = 5;
    private Hotel currentHotel = null;
    private User currentUser = null;
    private static HotelController hotelController = null;

    private HotelController(){}

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public static HotelController getInstance(){
        if (hotelController == null){
            hotelController = new HotelController();
        }
        return hotelController;
    }

    public void hotelMainScreen(){
        int choice = -1;

        do{
            System.out.println("What do you need?");
            System.out.println("1. Choose a hotel from list");
            System.out.println("2. Sort room");
            System.out.println("3. Manage your hotel");
            System.out.println("4. Go back");

            choice = NumberGetter.getInstance().getInt();

            switch(choice){
                case 1:
                    showHotelList(1, false, false);
                    break;
                case 2:
                    RoomController rc = RoomController.getInstance();
                    rc.setCurrentUser(currentUser);
                    rc.sortAllRoomsOption();
                    break;
                case 3:
                    manageHotel();
                    break;
                default:
                    break;
            }
        }while(choice != 4);
    }

    public void showHotelList(int currentPage, boolean isGuest, boolean isPartner){
        int choice = -1;

        List<String> list;

        if (isPartner){
            list = HOTEL_SERVICE.getPartnerHotelList(currentUser.getId(), HOTEL_TO_SHOW, currentPage);
        }
        else {
            list = HOTEL_SERVICE.getHotelList(HOTEL_TO_SHOW, currentPage);
        }

        int i;
        for (i = 0; i < list.size(); i++){
            System.out.println(i + ". Hotel " + list.get(i).split(",")[1]);
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
            if (list.size() < HOTEL_TO_SHOW){
                System.out.println("No more hotel to show");
            }
            else {
                showHotelList(++currentPage, isGuest, isPartner);
            }
        } else if (choice == i - 2) {
            if (currentPage == 1){
                System.out.println("Can't go to previous page");
            }
            else {
                showHotelList(--currentPage, isGuest, isPartner);
            }
        } else if (choice < list.size() && choice >= 0) {
            String[] hotelInfo = list.get(choice).split(",");
            currentHotel = new Hotel(hotelInfo[0], hotelInfo[1], hotelInfo[2], hotelInfo[3]);
            if (isGuest) {
                RoomController rc = RoomController.getInstance();
                rc.setCurrentHotel(currentHotel);
                rc.showRoomListOfHotel(1, true, false);
            }
            else if (!isPartner){
                RoomController rc = RoomController.getInstance();
                rc.setCurrentUser(currentUser);
                rc.setCurrentHotel(currentHotel);
                rc.showRoomListOfHotel(1, false, false);
            }
            else {
                RoomController rc = RoomController.getInstance();
                rc.setCurrentUser(currentUser);
                rc.setCurrentHotel(currentHotel);
                rc.partnerRoomOption();
            }
        }
        else {
            showHotelList(currentPage, isGuest, isPartner);
        }
    }

    private void manageHotel(){
        int choice = -1;

        if (Objects.equals(currentUser.getRole(), "partner")){
            do {
                System.out.println("1. Current hotels");
                System.out.println("2. Add new hotel");
                System.out.println("3. Go back");

                choice = NumberGetter.getInstance().getInt();

                switch (choice) {
                    case 1:
                        showHotelList(1, false, true);
                        break;
                    case 2:
                        addHotel();
                        break;
                    default:
                        break;
                }
            }
            while(choice != 3);
        }
    }

    private void addHotel(){
        StringBuilder sb = new StringBuilder();
        Hotel hotel;
        String hotelName = "";
        String hotelAddress = "";

        do{System.out.println("Enter hotel name: ");
            hotelName = sc.nextLine();
            System.out.println("Enter hotel address: ");
            hotelAddress = sc.nextLine();

            hotel = new Hotel(hotelName, hotelAddress, currentUser.getId());
        }
        while(Objects.equals(hotelName, "") && Objects.equals(hotelAddress, "") && HOTEL_READ_WRITE_FILE.isHotelExist(hotel));
        HOTEL_READ_WRITE_FILE.writeNewHotel(hotel);
    }
}
