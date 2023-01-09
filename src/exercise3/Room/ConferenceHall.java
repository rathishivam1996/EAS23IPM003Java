package exercise3.Room;

import java.util.Arrays;

public class ConferenceHall extends Room {
    private boolean additionalFacilitiesRequired;
    private String[] services;

    public ConferenceHall(boolean additionalFacilitiesRequired, String[] services,
                          int roomNum, int roomPricePerDay, int roomCapacity, boolean isAvailable) {
        super(roomNum, roomPricePerDay, roomCapacity, isAvailable);
        this.additionalFacilitiesRequired = additionalFacilitiesRequired;
        this.services = services;
    }

    public boolean isAdditionalFacilitiesRequired() {
        return additionalFacilitiesRequired;
    }

    public void setAdditionalFacilitiesRequired(boolean additionalFacilitiesRequired) {
        this.additionalFacilitiesRequired = additionalFacilitiesRequired;
    }

    public String[] getServices() {
        return services;
    }

    public void setServices(String[] services) {
        this.services = services;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < services.length; i++) {
            String service = services[i];
            if (i == 0) {
                sb.append(String.format("| %10s | %18s | %15s | %20s | %15s |%n",
                        getRoomNum(), getRoomPricePerDay(), getRoomCapacity(),
                        additionalFacilitiesRequired, service));
            } else {
                sb.append(String.format("| %10s | %18s | %15s | %20s | %15s |%n",
                        "", "", "", additionalFacilitiesRequired, service));
            }
        }
        return sb.toString();
    }
}
