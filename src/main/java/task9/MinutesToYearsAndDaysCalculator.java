package task9;

public class MinutesToYearsAndDaysCalculator {

    private static final int MINUTES_IN_DAY = 60 * 24;
    private static final int MINUTES_IN_YEAR = MINUTES_IN_DAY * 365;

    public static String printYearsAndDays(long minutes) {
        if (minutes < 0)
            throw new IllegalArgumentException("Minutes must be non-negative number");
        int years = (int) (minutes / MINUTES_IN_YEAR);
        int days = (int) (minutes / MINUTES_IN_DAY - 365 * years); //all days = 365*years+rem
        return String.format("%d min = %d y and %d d", minutes, years, days);
    }
}
