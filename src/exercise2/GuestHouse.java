package exercise2;

import java.util.*;

public class GuestHouse {

    private ArrayList<Room> rooms;

    private ReservationList reservationList;

    private static GuestHouse Instance = null;

    private GuestHouse() {
        if (rooms == null) rooms = new ArrayList<>();
        if (reservationList == null) reservationList = ReservationList.getInstance();
    }

    public static GuestHouse getInstance() {
        if (Instance == null) Instance = new GuestHouse();

        return Instance;
    }

    public void createRandomRooms(int numOfRooms, int numOfFeaturesPerRoom) {
        for (int i = 1; i <= numOfRooms; i++) {
            List<RoomFeatures> randomRoomFeatures = RoomFeatures.getRandomRoomFeatures(numOfFeaturesPerRoom);
            RoomType randomRoomType = RoomType.getRandomRoomType();
            rooms.add(new Room(i, randomRoomFeatures, 4, randomRoomType));
        }
    }

    public void displayRooms() {
        for (Room room : rooms) {
            System.out.println(room);
        }
        System.out.println("Done !!!");
    }

    public void displayRoomByType() {
        RoomType[] roomTypes = RoomType.values();
        System.out.printf("%20s%20s", "Room Type", "Room Number" + "\n");
        for (RoomType roomType : roomTypes) {
            for (Room room : rooms) {
                if (room.getRoomType().equals(roomType))
                    System.out.printf("%20s%20s", room.getRoomType(), room.getRoomId() + "\n");
            }
        }
    }

    public Room getRoomById(int roomId) {
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) return room;
        }
        return null;
    }

    public void displayRoomsStatus() {
        System.out.println("--------------------------------");
        System.out.printf("%8s %10s", "RoomId", "Available");
        System.out.println();
        System.out.println("--------------------------------");
        for (Room room : rooms) {
            int roomId = room.getRoomId();
            System.out.printf("%8s %8s", roomId, reservationList.isRoomAvailable(roomId));
            System.out.println();
        }
    }

}
