package entities.room;

import utility.ExportFile;
import utility.Hash;

public class Room implements ExportFile {
    private String id;
    private String name;
    private int capacity;
    private String hotelId;
    private long price;

    public Room(String name, int capacity, String hotelId, long price) {
        this.id = Hash.generateMD5Hash(name + hotelId);
        this.name = name;
        this.capacity = capacity;
        this.hotelId = hotelId;
        this.price = price;
    }

    public Room(String id, String name, int capacity, String hotelId, long price) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.hotelId = hotelId;
        this.price = price;
    }

    public Room(String dataFromFile){
        String[] newData = dataFromFile.split(",");
        this.id = newData[0];
        this.name = newData[1];
        this.capacity = Integer.parseInt(newData[2]);
        this.hotelId = newData[3];
        this.price = Long.parseLong(newData[4]);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String exportToFile(){
        return id + "," + name + "," + capacity + "," + hotelId + "," + price;
    }

    @Override
    public String toString() {
        return "Room: " + getName() + ", id: " + getId() + ", capacity: " + getCapacity() + ", price: " + getPrice();
    }
}
