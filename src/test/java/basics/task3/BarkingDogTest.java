package basics.task3;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BarkingDogTest {
    @ParameterizedTest(name = "When isBarking={0} and hour={1} then result={2}")
    @MethodSource
    void givenBarkingDogCheckerWhenPassingValidArgumentThenReturnsCorrespondingBooleanValue(boolean isBarking, int hourOfDay, boolean expected) {
        assertEquals(expected, BarkingDog.shouldWakeUp(isBarking, hourOfDay));
    }

    @ParameterizedTest(name = "When isBarking={0} and hour={1} then exception")
    @MethodSource
    void givenBarkingDogCheckerWhenPassingInvalidArgumentThenThrowsException(boolean isBarking, int hourOfDay) {
        assertThrows(IllegalArgumentException.class, () -> BarkingDog.shouldWakeUp(isBarking, hourOfDay));
    }

    private static Stream<Arguments> givenBarkingDogCheckerWhenPassingValidArgumentThenReturnsCorrespondingBooleanValue() {
        return Stream.of(
                arguments(false, 2, false),
                arguments(true, 8, false),
                arguments(true, 1, true),
                arguments(true, 23, true)
        );
    }

    private static Stream<Arguments> givenBarkingDogCheckerWhenPassingInvalidArgumentThenThrowsException() {
        return Stream.of(
                arguments(true, -1),
                arguments(false, -1),
                arguments(true, 24),
                arguments(false, 24)
        );
    }
}