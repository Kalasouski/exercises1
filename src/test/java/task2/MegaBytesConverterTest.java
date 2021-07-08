package task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import task1.SpeedConverter;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MegaBytesConverterTest {
    private static Stream<Arguments> bytesToKiloBytes() {
        return Stream.of(
                arguments(2500, "2500 KB = 2 MB and 452 KB"),
                arguments(5000, "5000 KB = 4 MB and 904 KB")
        );
    }

    @ParameterizedTest(name = "{index} => KB={0}, str={1}")
    @MethodSource("bytesToKiloBytes")
    void givenBytesConverterWhenPassingValidArgumentThenReturnsConversionString(int kiloBytes, String conversionString) {
        assertEquals(conversionString, MegaBytesConverter.printMegaBytesAndKiloBytes(kiloBytes));
    }

    @ParameterizedTest(name = "{index} => KB={0}")
    @ValueSource(ints = {-1024, -5})
    void givenSpeedConverterWhenPassingInvalidArgumentThenThrowsException(double kilometersPerHour) {
        assertThrows(IllegalArgumentException.class, () -> SpeedConverter.toMilesPerHour(kilometersPerHour));
    }
}