import org.junit.Test;
import task1.SpeedConverter;
import task2.MegaBytesConverter;
import task3.BarkingDog;
import task4.LeapYear;
import task5.DecimalComparator;
import task6.EqualSumChecker;
import task7.TeenNumberChecker;
import task8.AreaCalculator;
import task9.MinutesToYearsAndDaysCalculator;
import task10.IntEqualityPrinter;
import task11.PlayingCat;
import task12.NumberInWord;
import task13.NumberOfDaysInMonth;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExerciseTests {
    @Test
    public void toMilesPerHourTest() {
        assertEquals(1, SpeedConverter.toMilesPerHour(1.5));
        assertEquals(6, SpeedConverter.toMilesPerHour(10.25));
        assertThrows(IllegalArgumentException.class, () -> SpeedConverter.toMilesPerHour(-5.6));
        assertEquals(16, SpeedConverter.toMilesPerHour(25.42));
        assertEquals(47, SpeedConverter.toMilesPerHour(75.114));
    }

    @Test
    public void printConversionTest() {
        assertEquals("1.5 km/h = 1 mi/h", SpeedConverter.printConversion(1.5));
        assertEquals("10.25 km/h = 6 mi/h", SpeedConverter.printConversion(10.25));
        assertThrows(IllegalArgumentException.class, () -> SpeedConverter.printConversion(-5.6));
        assertEquals("25.42 km/h = 16 mi/h", SpeedConverter.printConversion(25.42));
        assertEquals("75.114 km/h = 47 mi/h", SpeedConverter.printConversion(75.114));
    }

    @Test
    public void MegaBytesConversionTest() {
        assertEquals("2500 KB = 2 MB and 452 KB", MegaBytesConverter.printMegaBytesAndKiloBytes(2500));
        assertThrows(IllegalArgumentException.class, () -> MegaBytesConverter.printMegaBytesAndKiloBytes(-1024));
        assertEquals("5000 KB = 4 MB and 904 KB", MegaBytesConverter.printMegaBytesAndKiloBytes(5000));
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
        assertFalse(EqualSumChecker.hasEqualSum(1, 1, 1));
        assertTrue(EqualSumChecker.hasEqualSum(1, 1, 2));
        assertTrue(EqualSumChecker.hasEqualSum(1, -1, 0));
        assertFalse(EqualSumChecker.hasEqualSum(Integer.MAX_VALUE, 1, Integer.MIN_VALUE));
    }

    @Test
    public void isTeenTest() {
        assertFalse(TeenNumberChecker.isTeen(9));
        assertTrue(TeenNumberChecker.isTeen(13));
    }

    @Test
    public void hasTeenTest() {
        assertTrue(TeenNumberChecker.hasTeen(9, 99, 19));
        assertTrue(TeenNumberChecker.hasTeen(23, 15, 42));
        assertFalse(TeenNumberChecker.hasTeen(22, 23, 34));
    }

    @Test
    public void areaTest() {
        assertEquals(78.53982, AreaCalculator.area(5.0), 0.00001);
        assertThrows(IllegalArgumentException.class, () -> AreaCalculator.area(-1));
        assertEquals(20.0, AreaCalculator.area(5.0, 4.0), 0.00001);
        assertThrows(IllegalArgumentException.class, () -> AreaCalculator.area(-1.0, 4.0));
    }

    @Test
    public void printYearsAndDaysTest() {
        assertEquals("525600 min = 1 y and 0 d",
                MinutesToYearsAndDaysCalculator.printYearsAndDays(525600));
        assertEquals("1051200 min = 2 y and 0 d",
                MinutesToYearsAndDaysCalculator.printYearsAndDays(1051200));
        assertEquals("561600 min = 1 y and 25 d",
                MinutesToYearsAndDaysCalculator.printYearsAndDays(561600));
        assertThrows(IllegalArgumentException.class, () ->
                MinutesToYearsAndDaysCalculator.printYearsAndDays(-2));
    }

    @Test
    public void printEqualTest() {
        assertEquals("All numbers are equal", IntEqualityPrinter.printEqual(1, 1, 1));
        assertEquals("Neither all are equal or different", IntEqualityPrinter.printEqual(1, 1, 2));
        assertThrows(IllegalArgumentException.class, () ->
                IntEqualityPrinter.printEqual(-1, -1, -1));
        assertEquals("All numbers are different", IntEqualityPrinter.printEqual(1, 2, 3));
    }

    @Test
    public void isCatPlayingTest() {
        assertFalse(PlayingCat.isCatPlaying(true,10));
        assertFalse(PlayingCat.isCatPlaying(false,36));
        assertTrue(PlayingCat.isCatPlaying(false,35));
    }

    @Test
    public void printNumberInWordTest() {
        assertEquals("OTHER",NumberInWord.printNumberInWord(-4));
        assertEquals("EIGHT",NumberInWord.printNumberInWord(8));
        assertEquals("TWO",NumberInWord.printNumberInWord(2));
    }

    @Test
    public void getDaysInMonthTest() {
        assertEquals(31,NumberOfDaysInMonth.getDaysInMonth(1,2020));
        assertEquals(29,NumberOfDaysInMonth.getDaysInMonth(2,2020));
        assertEquals(28,NumberOfDaysInMonth.getDaysInMonth(2,2018));
        assertThrows(IllegalArgumentException.class,()->NumberOfDaysInMonth.getDaysInMonth(-1,2020));
    }
}