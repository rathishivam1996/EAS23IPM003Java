package exercise2;

import java.util.Date;
import java.util.UUID;

public class Reservation {
    private final UUID reservationId;
    private UUID customerId;
    private int roomId;
    private Date bookingDate;
    private int numOfDays;
    private int bookingAmount;

    public Reservation(UUID customerId, int roomId, Date bookingDate, int numOfDays, int bookingAmount) {
        this.reservationId = UUID.randomUUID();
        this.customerId = customerId;
        this.roomId = roomId;
        this.bookingDate = bookingDate;
        this.numOfDays = numOfDays;
        this.bookingAmount = bookingAmount;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + reservationId + "\n" +
                ", customerId=" + customerId +  "\n" +
                ", roomId=" + roomId + "\n" +
                ", bookingDate=" + bookingDate + "\n" +
                ", bookingAmount=" + bookingAmount + "\n" +
                '}';
    }
}
