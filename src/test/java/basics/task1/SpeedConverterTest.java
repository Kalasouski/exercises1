package basics.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SpeedConverterTest {
    // Given => When => Then
    // givenSmth_whenSmth_thenSmth
    @ParameterizedTest(name = "When kph={0} then mph={1}")
    @MethodSource
    void givenSpeedConverterWhenPassingValidArgumentThenReturnsConvertedValue(double kilometersPerHour, int milesPerHour) {
        assertEquals(milesPerHour, SpeedConverter.toMilesPerHour(kilometersPerHour));
    }

    @ParameterizedTest(name = "When kph={0} then exception")
    @ValueSource(doubles = {-5.6, -1})
    void givenSpeedConverterWhenPassingInvalidArgumentThenThrowsException(double kilometersPerHour) {
        assertThrows(IllegalArgumentException.class, () -> SpeedConverter.toMilesPerHour(kilometersPerHour));
    }

    @ParameterizedTest(name = "When kph={0} then str={1}")
    @MethodSource
    void givenConversionPrinterWhenPassingValidArgumentThenReturnsConversionString(double kilometersPerHour, String conversionString) {
        assertEquals(conversionString, SpeedConverter.printConversion(kilometersPerHour));
    }

    @ParameterizedTest(name = "When kph={0} then exception")
    @ValueSource(doubles = {-5.6, -1})
    void givenConversionPrinterWhenPassingInvalidArgumentThenThrowsException(double kilometersPerHour) {
        assertThrows(IllegalArgumentException.class, () -> SpeedConverter.printConversion(kilometersPerHour));
    }

    private static Stream<Arguments> givenSpeedConverterWhenPassingValidArgumentThenReturnsConvertedValue() {
        return Stream.of(
                arguments(1.5, 1),
                arguments(10.25, 6),
                arguments(25.42, 16),
                arguments(75.114, 47)
        );
    }

    private static Stream<Arguments> givenConversionPrinterWhenPassingValidArgumentThenReturnsConversionString() {
        return Stream.of(
                arguments(1.5, "1.5 km/h = 1 mi/h"),
                arguments(10.25, "10.25 km/h = 6 mi/h"),
                arguments(25.42, "25.42 km/h = 16 mi/h"),
                arguments(75.114, "75.114 km/h = 47 mi/h")
        );
    }
}