package exercise2;

import java.util.Random;

public enum RoomType {
    SINGLE_ROOM,
    DOUBLE_ROOM,
    DelUXE_ROOM,
    SUITE,
    PRESIDENT_SUITE;

    public static RoomType getRandomRoomType() {
        RoomType[] values = RoomType.values();
        Random generator = new Random();
        int min = 0;
        int max = values.length;
        // max exclusive. inclusive = +1
        int num = generator.nextInt((max - min)) + min;

        return values[num];
    }
}
