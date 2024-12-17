package management;

import entities.PhoneBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhoneBookingManagement {
    private final List<PhoneBooking> list = new ArrayList<>();
    private static PhoneBookingManagement phoneBookingManagement = null;

    private PhoneBookingManagement(){}

    public static PhoneBookingManagement getInstance(){
        if (phoneBookingManagement == null){
            phoneBookingManagement = new PhoneBookingManagement();
        }
        return phoneBookingManagement;
    }

    public List<PhoneBooking> getList() {
        return list;
    }

    public void addInformation(PhoneBooking phoneBooking){
        list.add(phoneBooking);
    }

    public void deleteInformation(String phoneNumber){
        list.removeIf(phoneBooking -> Objects.equals(phoneBooking.getPhoneNumber(), phoneNumber));
    }

    public List<PhoneBooking> getInfoByPage(int numberToShow, int page){
        List<PhoneBooking> tempList = new ArrayList<>();
        int currentPage = 1;
        for (PhoneBooking phoneBooking: list){
            if (tempList.size() == numberToShow){
                if (currentPage == page){
                    return tempList;
                }
                else {
                    tempList.clear();
                    currentPage++;
                }
            }
            else{
                tempList.add(phoneBooking);
            }
        }
        if (currentPage < page) return null;
        else return tempList;
    }

    public PhoneBooking getByPhone(String phone){
        int index = -1;

        for (PhoneBooking phoneBooking: list){
            if (Objects.equals(phoneBooking.getPhoneNumber(), phone)){
                index = list.indexOf(phoneBooking);
            }
        }
        if (index == -1) return null;
        return list.get(index);
    }

    public PhoneBooking getByName(String name){
        int index = -1;

        for (PhoneBooking phoneBooking: list){
            if (Objects.equals(phoneBooking.getName(), name)){
                index = list.indexOf(phoneBooking);
            }
        }
        if (index == -1) return null;
        return list.get(index);
    }

    public void clearList(){list.clear();}
}
