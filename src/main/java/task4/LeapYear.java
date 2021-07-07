package task4;

public class LeapYear {

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999)
            throw new IllegalArgumentException("Year must be in range [1,9999]");
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    return true;
                else
                    return false;
            } else
                return true;
        } else
            return false;
    }
}
