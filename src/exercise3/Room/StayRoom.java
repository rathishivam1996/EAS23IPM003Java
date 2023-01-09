package exercise3.Room;

import java.util.List;

public class StayRoom extends Room {

    private List<RoomFeature> roomFeatures;

    private RoomType roomType;

    public StayRoom(List<RoomFeature> roomFeatures, RoomType roomType,
                    int roomNum, int pricePerDay, int roomCapacity, boolean isAvailable) {
        super(roomNum, pricePerDay, roomCapacity, isAvailable);
        this.roomFeatures = roomFeatures;
        this.roomType = roomType;
    }

    public List<RoomFeature> getRoomFeatures() {
        return roomFeatures;
    }

    public void setRoomFeatures(List<RoomFeature> roomFeatures) {
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < roomFeatures.size(); i++) {
            RoomFeature roomFeature = roomFeatures.get(i);
            if (i == 0) {
                sb.append(String.format("| %10s | %10s | %18s | %15s | %20s | %15s |%n",
                        getRoomNum(), isAvailable(), getRoomPricePerDay(), getRoomCapacity(),
                        roomFeature.getFeature() + " " + roomFeature.getPrice(), roomType));
            } else {
                sb.append(String.format("| %10s | %10s | %18s | %15s | %20s | %15s |%n",
                        "","", "", "", roomFeature.getFeature() + " " + roomFeature.getPrice(), ""));
            }
        }
        return sb.toString();
    }
}
