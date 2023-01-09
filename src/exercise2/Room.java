package exercise2;

import java.util.List;

public class Room {
    private final int roomId;
    private List<RoomFeatures> roomFeatures;

    private int roomPricePerDay;

    private int roomCapacity;

    private RoomType roomType;

    public Room(int roomId, List<RoomFeatures> roomFeatures, int roomCapacity, RoomType roomType) {
        this.roomId = roomId;
        this.roomFeatures = roomFeatures;
        this.roomPricePerDay = this.roomFeatures.stream().map(RoomFeatures::getPrice).reduce(0, Integer::sum);
        this.roomCapacity = roomCapacity;
        this.roomType = roomType;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getRoomPricePerDay() {
        return roomPricePerDay;
    }

    public void setRoomPricePerDay(int roomPricePerDay) {
        this.roomPricePerDay = roomPricePerDay;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public void setRoomFeatures(List<RoomFeatures> roomFeatures) {
        this.roomFeatures = roomFeatures;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId + "\n" +
                ", roomFeatures=" + roomFeatures + "\n" +
                ", roomPricePerDay=" + roomPricePerDay + "\n" +
                ", roomCapacity=" + roomCapacity + "\n" +
                ", roomType=" + roomType + "\n" +
                '}';
    }
}
