import org.junit.Test;
import task1.SpeedConverter;
import task2.MegaBytesConverter;
import task3.BarkingDog;
import task4.LeapYear;
import task5.DecimalComparator;
import task6.EqualSumChecker;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseTests {
    @Test
    public void toMilesPerHourTest() {
        assertEquals(SpeedConverter.toMilesPerHour(1.5), 1);
        assertEquals(SpeedConverter.toMilesPerHour(10.25), 6);
        assertThrows(IllegalArgumentException.class, () -> SpeedConverter.toMilesPerHour(-5.6));
        assertEquals(SpeedConverter.toMilesPerHour(25.42), 16);
        assertEquals(SpeedConverter.toMilesPerHour(75.114), 47);
    }

    @Test
    public void printConversionTest() {
        assertEquals(SpeedConverter.printConversion(1.5), "1.5 km/h = 1 mi/h");
        assertEquals(SpeedConverter.printConversion(10.25), "10.25 km/h = 6 mi/h");
        assertThrows(IllegalArgumentException.class, () -> SpeedConverter.printConversion(-5.6));
        assertEquals(SpeedConverter.printConversion(25.42), "25.42 km/h = 16 mi/h");
        assertEquals(SpeedConverter.printConversion(75.114), "75.114 km/h = 47 mi/h");
    }

    @Test
    public void MegaBytesConversionTest() {
        assertEquals(MegaBytesConverter.printMegaBytesAndKiloBytes(2500), "2500 KB = 2 MB and 452 KB");
        assertThrows(IllegalArgumentException.class, () -> MegaBytesConverter.printMegaBytesAndKiloBytes(-1024));
        assertEquals(MegaBytesConverter.printMegaBytesAndKiloBytes(5000), "5000 KB = 4 MB and 904 KB");
    }

    @Test
    public void shouldWakeUpTest() {
        assertTrue(BarkingDog.shouldWakeUp(true, 1));
        assertFalse(BarkingDog.shouldWakeUp(false, 2));
        assertFalse(BarkingDog.shouldWakeUp(true, 8));
        assertThrows(IllegalArgumentException.class, () -> BarkingDog.shouldWakeUp(true, -1));
    }

    @Test
    public void leapYearTest() {
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(-1600));
        assertTrue(LeapYear.isLeapYear(1600));
        assertFalse(LeapYear.isLeapYear(2017));
        assertTrue(LeapYear.isLeapYear(2000));
    }

    @Test
    public void decimalComparatorTest() {
        assertTrue(DecimalComparator.areEqualByThreeDecimalPlaces(-3.1756, -3.175));
        assertFalse(DecimalComparator.areEqualByThreeDecimalPlaces(3.175, 3.176));
        assertTrue(DecimalComparator.areEqualByThreeDecimalPlaces(3.0, 3.0));
        assertFalse(DecimalComparator.areEqualByThreeDecimalPlaces(-3.123, 3.123));
    }

    @Test
    public void hasEqualSumTest() {
        assertFalse(EqualSumChecker.hasEqualSum(1,1,1));
        assertTrue(EqualSumChecker.hasEqualSum(1,1,2));
        assertTrue(EqualSumChecker.hasEqualSum(1,-1,0));
        assertFalse(EqualSumChecker.hasEqualSum(Integer.MAX_VALUE,1,Integer.MIN_VALUE));
    }
}