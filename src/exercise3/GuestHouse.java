package exercise3;

import exercise3.Room.*;

import java.util.ArrayList;
import java.util.List;

public class GuestHouse {

    ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<StayRoom> stayRooms;
    private ArrayList<ConferenceHall> conferenceHalls;
    private ArrayList<PartyHall> partyHalls;

    private ReservationList reservationList;

    private static GuestHouse Instance = null;

    private GuestHouse() {
        if (stayRooms == null) stayRooms = new ArrayList<>();
        if (conferenceHalls == null) conferenceHalls = new ArrayList<>();
        if (partyHalls == null) partyHalls = new ArrayList<>();
        if (reservationList == null) reservationList = ReservationList.getInstance();
    }

    public static GuestHouse getInstance() {
        if (Instance == null) Instance = new GuestHouse();

        return Instance;
    }

    public Room getRoomById(int roomNum){
        for (Room room: rooms){
            if (room.getRoomNum()== roomNum){
                return room;
            }
        }
        return null;
    }
    public void createRandomStayRooms(int numOfStayRooms, int numOfFeaturesPerRoom) {
        for (int i = 1; i <= numOfStayRooms; i++) {
            List<RoomFeature> randomRoomFeatures = RoomFeature.getRandomRoomFeatures(numOfFeaturesPerRoom);
            // reduce(0, (x, y) -> x + y, (a, b) -> a + b)
            int pricePerDay = randomRoomFeatures.stream().mapToInt(RoomFeature::getPrice).sum();
            RoomType randomRoomType = RoomType.getRandomRoomType();
            rooms.add(new StayRoom(randomRoomFeatures, randomRoomType, i, pricePerDay, 4, true));
        }
    }

    public void createRandomConferenceHalls() {
        rooms.add(new ConferenceHall(false, new String[]{"Projector", "Conference Table", "Sound System"},
                11, 5000, 20, true));
        rooms.add(new ConferenceHall(false, new String[]{"Projector", "Sound System", "Auditorium"},
                12, 10000, 50, true));
        rooms.add(new ConferenceHall(false, new String[]{"White Board", "Conference Table", "Sound System"},
                13, 2000, 20, true));
        rooms.add(new ConferenceHall(false, new String[]{"Projector", "Conference Table", "Sound System"},
                14, 5000, 20, true));
    }

    public void createRandomPartyHalls() {
        rooms.add(new PartyHall("Non Veg", "Outdoors", 30,
                15, 50000, 100, true));
        rooms.add(new PartyHall("Veg", "Indoors", 20,
                16, 100000, 50, true));
        rooms.add(new PartyHall("Mix", "Outdoors", 30,
                17, 50000, 100, true));
    }

    public void displayRoomByCategory(RoomCategory roomCategory) {
        if (roomCategory.equals(RoomCategory.STAY_ROOM)) {
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.printf("| %10s | %10s | %18s | %15s | %20s | %15s |%n",
                    "Room Num", "isAvailable", "Room Price Per Day", "Room Capacity", "Room Features", "Room Type");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            for (Room room : rooms) {
                if (room instanceof StayRoom){
                    System.out.println(room);
                }
            }
        } else if (roomCategory.equals(RoomCategory.CONFERENCE_HALL)) {
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.printf("| %10s | %18s | %15s | %20s | %15s |%n", "Room Num", "Room Price Per Day",
                    "Room Capacity", "Additional Facilities", "Services");
            System.out.println("-------------------------------------------------------------------------------------------");
            for (Room room : rooms) {
                if (room instanceof ConferenceHall){
                    System.out.println(room);
                }
            }
        } else if (roomCategory.equals(RoomCategory.PARTY_HALL)) {
            System.out.println("-------------------------------------------------------------------------------------------\n");
            System.out.printf("| %10s | %18s | %15s | %20s | %15s | %15s |%n", "Room Num", "Room Price Per Day",
                    "Room Capacity", "Meal Type", "Arrangement Type", "Total Staff");
            System.out.println("-------------------------------------------------------------------------------------------");
            for (Room room : rooms) {
                if (room instanceof PartyHall){
                    System.out.println(room);
                }
            }
        }
    }

//    public Room getRoomById(int roomNum) {
//        for (Room stayRoom : stayRooms) {
//            if (stayRoom.getRoomNum() == roomNum) return stayRoom;
//        }
//        for (Room conferenceHall : conferenceHalls) {
//            if (conferenceHall.getRoomNum() == roomNum) return conferenceHall;
//        }
//        for (Room partyHall : partyHalls) {
//            if (partyHall.getRoomNum() == roomNum) return partyHall;
//        }
//        return null;
//    }

    public void displayRoomsByStatus() {
        System.out.println("=========================================================");
        System.out.printf("%15s | %8s | %10s", "RoomType", "RoomId", "Available \n");
        System.out.println("=========================================================");
        for (Room stayRoom : stayRooms) {
            System.out.printf("%15s | %8s | %10s", "Stay Room", stayRoom.getRoomNum(), stayRoom.isAvailable());
            System.out.println();
        }
        System.out.println();
        for (Room conferenceHall : conferenceHalls) {
            System.out.printf("%15s | %8s | %10s", "Conference Hall", conferenceHall.getRoomNum(), conferenceHall.isAvailable());
            System.out.println();
        }
        System.out.println();
        for (Room partyHall : partyHalls) {
            System.out.printf("%15s | %8s | %10s", "Party Hall", partyHall.getRoomNum(), partyHall.isAvailable());
            System.out.println();
        }
    }

}
