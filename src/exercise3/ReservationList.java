package exercise3;

import exercise3.Room.RoomCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class ReservationList {
    private ArrayList<Reservation> reservations;

    private static ReservationList Instance = null;

    private ReservationList() {
        if (reservations == null) reservations = new ArrayList<>();
    }

    public static ReservationList getInstance() {
        if (Instance == null) Instance = new ReservationList();
        return Instance;
    }

    public boolean isRoomAvailable(int roomNum) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoomId() == roomNum) return false;
        }
        return true;
    }

    public void makeReservation(UUID customerId, int roomId,
                                Date bookingDate, int numOfDays,
                                int bookingAmount) {
        Reservation reservation = new Reservation(customerId, roomId, bookingDate, numOfDays, bookingAmount);
        reservations.add(reservation);
    }

    public Reservation findReservationByCustomerId(UUID customerId) {
        for (Reservation reservation : reservations) {
            if (reservation.getCustomerId() == customerId) return reservation;
        }
        return null;
    }

    public void displayAllReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
        System.out.println("Done !!!");
    }
}
