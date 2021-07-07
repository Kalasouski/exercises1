package task3;

public class BarkingDog {
    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23)
            throw new IllegalArgumentException("Hour of day must be in range [0,23]");
        return isBarking && (hourOfDay < 8 || hourOfDay > 22);
    }
}
