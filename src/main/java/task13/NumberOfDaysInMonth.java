package task13;

import task4.LeapYear;

public class NumberOfDaysInMonth {
    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Month must be in range [1,12]");
        if (year < 1 || year > 9999)
            throw new IllegalArgumentException("Year must be in range [1,9999]");
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (LeapYear.isLeapYear(year))
                    return 29;
                return 28;
            default:
                return -1;
        }
    }
}
