package entities.booking;

import utility.ExportFile;
import utility.Hash;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking implements ExportFile {
    private String bookingId;
    private String userId;
    private String roomId;
    private Date startDate;
    private Date endDate;
    private boolean checkedIn;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Booking(String userId, String roomId, Date startDate, Date endDate, boolean checkedIn) {
        this.bookingId = Hash.generateMD5Hash(userId + roomId);
        this.userId = userId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkedIn = checkedIn;
    }

    public Booking(String bookingId, String userId, String roomId, Date startDate, Date endDate, boolean checkedIn) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkedIn = checkedIn;
    }

    public Booking (String dataFromFile){
        String[] data = dataFromFile.split(",");

        try {
            this.bookingId = data[0];
            this.userId = data[1];
            this.roomId = data[2];
            this.startDate = sdf.parse(data[3]);
            this.endDate = sdf.parse(data[4]);
            this.checkedIn = Boolean.parseBoolean(data[5]);
        }
        catch (ParseException e){
            System.out.println("Can't convert to date" + e.getMessage());
        }
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    @Override
    public String exportToFile(){
        return bookingId + "," + userId + "," + roomId + "," + startDate + "," + endDate + "," + checkedIn;
    }

    public boolean overlapDate(Booking booking2){
        return this.getStartDate().before(booking2.getEndDate()) && booking2.getStartDate().before(this.getEndDate());
    }
}
