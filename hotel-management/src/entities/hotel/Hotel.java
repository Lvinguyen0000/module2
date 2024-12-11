package entities.hotel;

import utility.ExportFile;
import utility.Hash;

public class Hotel implements ExportFile {
    private String id;
    private String name;
    private String address;
    private String partnerId;

    public Hotel(String name, String address, String partnerId) {
        this.id = Hash.generateMD5Hash(name + address);
        this.name = name;
        this.address = address;
        this.partnerId = partnerId;
    }

    public Hotel(String id, String name, String address, String partnerId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.partnerId = partnerId;
    }

    public Hotel (String data){
        String[] temp = data.split(",");
        this.id = temp[0];
        this.name = temp[1];
        this.address = temp[2];
        this.partnerId = temp[3];
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String exportToFile(){
        return id + "," + name + "," + address + "," + partnerId;
    }
}
