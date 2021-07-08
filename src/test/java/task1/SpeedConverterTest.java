package task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SpeedConverterTest {
    private static Stream<Arguments> kilometersToMiles() {
        return Stream.of(
                arguments(1.5, 1),
                arguments(10.25, 6),
                arguments(25.42, 16),
                arguments(75.114, 47)
        );
    }

    private static Stream<Arguments> kilometersToConversionString() {
        return Stream.of(
                arguments(1.5, "1.5 km/h = 1 mi/h"),
                arguments(10.25, "10.25 km/h = 6 mi/h"),
                arguments(25.42, "25.42 km/h = 16 mi/h"),
                arguments(75.114, "75.114 km/h = 47 mi/h")
        );
    }

    // Given => When => Then
    // givenSmth_whenSmth_thenSmth
    @ParameterizedTest(name = "{index} => kph={0}, mph={1}")
    @MethodSource("kilometersToMiles")
    void givenSpeedConverterWhenPassingValidArgumentThenReturnsConvertedValue(double kilometersPerHour, int milesPerHour) {
        assertEquals(milesPerHour, SpeedConverter.toMilesPerHour(kilometersPerHour));
    }

    @ParameterizedTest(name = "{index} => kph={0}")
    @ValueSource(doubles = {-5.6, -1})
    void givenSpeedConverterWhenPassingInvalidArgumentThenThrowsException(double kilometersPerHour) {
        assertThrows(IllegalArgumentException.class, () -> SpeedConverter.toMilesPerHour(kilometersPerHour));
    }

    @ParameterizedTest(name = "{index} => kph={0}, str={1}")
    @MethodSource("kilometersToConversionString")
    void givenConversionPrinterWhenPassingValidArgumentThenReturnsConversionString(double kilometersPerHour, String conversionString) {
        assertEquals(conversionString,SpeedConverter.printConversion(kilometersPerHour));
    }

    @ParameterizedTest(name = "{index} => kph={0}")
    @ValueSource(doubles = {-5.6, -1})
    void givenConversionPrinterWhenPassingInvalidArgumentThenThrowsException(double kilometersPerHour) {
        assertThrows(IllegalArgumentException.class, () -> SpeedConverter.printConversion(kilometersPerHour));
    }
}