package exercise3.Room;

public class Room {
    private int roomNum;
    private int roomPricePerDay;
    private int roomCapacity;
    private boolean isAvailable;

    public Room(int roomNum, int roomPricePerDay, int roomCapacity, boolean isAvailable) {
        setRoomNum(roomNum);
        setRoomPricePerDay(roomPricePerDay);
        setRoomCapacity(roomCapacity);
        setAvailable(isAvailable);
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        if (roomNum > 0 && roomNum <= 100) {
            this.roomNum = roomNum;
        } else throw new IllegalArgumentException("Invalid roomNum in Room setter");
    }

    public int getRoomPricePerDay() {
        return roomPricePerDay;
    }

    public void setRoomPricePerDay(int roomPricePerDay) {
        if (this.roomPricePerDay > 0) {
            this.roomPricePerDay = roomPricePerDay;
        } else throw new IllegalArgumentException("Invalid roomPricePerDAY in Room setter");
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        if (roomCapacity > 0) {
            this.roomCapacity = roomCapacity;
        } else throw new IllegalArgumentException("Invalid roomPricePerDAY in Room setter");
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNum=" + roomNum + "\n" +
                ", roomPricePerDay=" + roomPricePerDay + "\n" +
                ", roomCapacity=" + roomCapacity + "\n" +
                '}';
    }
}
