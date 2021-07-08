package task3;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import task1.SpeedConverter;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BarkingDogTest {
    private static Stream<Arguments> wakingConditions() {
        return Stream.of(
                arguments(true, 1),
                arguments(true, 23)
        );
    }

    private static Stream<Arguments> sleepingConditions() {
        return Stream.of(
                arguments(false, 2),
                arguments(true, 8)
        );
    }

    private static Stream<Arguments> invalidConditions() {
        return Stream.of(
                arguments(true, -1)
        );
    }

    @ParameterizedTest(name = "{index} => isBarking={0}, hour={1}")
    @MethodSource("wakingConditions")
    void givenBarkingDogCheckerWhenPassingValidArgumentThenReturnsTrue(boolean isBarking, int hourOfDay) {
        assertTrue(BarkingDog.shouldWakeUp(isBarking, hourOfDay));
    }

    @ParameterizedTest(name = "{index} => isBarking={0}, hour={1}")
    @MethodSource("sleepingConditions")
    void givenBarkingDogCheckerWhenPassingValidArgumentThenReturnsFalse(boolean isBarking, int hourOfDay) {
        assertFalse(BarkingDog.shouldWakeUp(isBarking, hourOfDay));
    }

    @ParameterizedTest(name = "{index} => isBarking={0}, hour={1}")
    @MethodSource("invalidConditions")
    void givenBarkingDogCheckerWhenPassingInvalidArgumentThenThrowsException(boolean isBarking, int hourOfDay) {
        assertThrows(IllegalArgumentException.class, () -> BarkingDog.shouldWakeUp(isBarking, hourOfDay));
    }
}