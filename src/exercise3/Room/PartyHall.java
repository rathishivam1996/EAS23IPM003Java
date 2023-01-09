package exercise3.Room;

public class PartyHall extends Room {
    private String mealType;
    private String arrangementType;
    private int totalSupportingStaff;

    public PartyHall(String mealType, String arrangementType, int totalSupportingStaff,
                     int roomNum, int roomPricePerDay, int roomCapacity, boolean isAvailable) {
        super(roomNum, roomPricePerDay, roomCapacity, isAvailable);
        this.mealType = mealType;
        this.arrangementType = arrangementType;
        this.totalSupportingStaff = totalSupportingStaff;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getArrangementType() {
        return arrangementType;
    }

    public void setArrangementType(String arrangementType) {
        this.arrangementType = arrangementType;
    }

    public int getTotalSupportingStaff() {
        return totalSupportingStaff;
    }

    public void setTotalSupportingStaff(int totalSupportingStaff) {
        this.totalSupportingStaff = totalSupportingStaff;
    }

    @Override
    public String toString() {
        return String.format("| %10s | %18s | %15s | %20s | %15s | %15s |%n", getRoomNum(), getRoomPricePerDay(),
                getRoomCapacity(), mealType, arrangementType, totalSupportingStaff);
    }
}
