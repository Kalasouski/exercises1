import org.junit.Test;
import task1.SpeedConverter;
import task2.MegaBytesConverter;
import task3.BarkingDog;

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
}