import org.junit.Test;

import task1.SpeedConverter;


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
}
