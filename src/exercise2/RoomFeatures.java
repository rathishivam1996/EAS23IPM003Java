package exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum RoomFeatures {
    BASE_NON_AC("BASE_NON_AC", 1000),
    AC("AC", 1000),
    WIFI("WIFI", 250),
    BALCONY("BALCONY", 500),
    TV("TV", 250),
    KING_SIZE_BED("KING_SIZE_BED", 500),
    BATHROOM("BATHROOM", 250),
    KITCHEN("KITCHEN", 500),
    SITTING_AREA("SITTING_AREA", 250);

    private final String feature;
    private final int price;

    RoomFeatures(String feature, int price) {
        this.feature = feature;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getFeature() {
        return feature;
    }

    public static List<RoomFeatures> getRandomRoomFeatures(int numOfFeatures) {
        RoomFeatures[] values = RoomFeatures.values();
        int min = 0;
        int max = values.length;

        List<Integer> indices = IntStream.range(min, max).boxed().collect(Collectors.toList());
        Collections.shuffle(indices);
        return indices.subList(0, numOfFeatures).stream()
                .collect(ArrayList<RoomFeatures>::new, (x, y) -> x.add(values[y]), ArrayList::addAll);
    }

    @Override
    public String toString() {
        return "{" +
                "feature='" + feature + '\'' +
                ", price=" + price +
                '}';
    }
}
