package task1;

public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0)
            throw new IllegalArgumentException("Input must be non-negative");
        return Math.round(kilometersPerHour * 0.621371);
    }

    public static String printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0)
            throw new IllegalArgumentException("Input must be non-negative");
        String text = String.valueOf(Math.abs(kilometersPerHour));
        int decimalPlaces = text.length() - text.indexOf('.') - 1;
        return String.format("%." + decimalPlaces + "f km/h = %d mi/h", kilometersPerHour, toMilesPerHour(kilometersPerHour));
    }
}