package basics.task4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeapYearTest {
    @ParameterizedTest(name = "When year={0} then result={2}")
    @MethodSource
    void givenLeapYearTesterWhenPassingValidArgumentThenReturnsCorrespondingBooleanValue(int year, boolean expected) {
        assertEquals(expected, LeapYear.isLeapYear(year));
    }

    @ParameterizedTest(name = "When year={0} then exception")
    @MethodSource
    void givenLeapYearTesterWhenPassingInvalidArgumentThenThrowsException(int year) {
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(year));
    }

    private static Stream<Arguments> givenLeapYearTesterWhenPassingValidArgumentThenReturnsCorrespondingBooleanValue() {
        return Stream.of(
                arguments(1600, true), // year % 4, year%100, year%400
                arguments(300, false), // year % 4, year%100, !year%400
                arguments(2148, true),  // year % 4, !year%100
                arguments(1997, false) //!year%4
        );
    }

    private static Stream<Arguments> givenLeapYearTesterWhenPassingInvalidArgumentThenThrowsException() {
        return Stream.of(
                arguments(-1),
                arguments(10000)
        );
    }
}