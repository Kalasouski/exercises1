package oop.task33;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FloorTest {
    @ParameterizedTest(name = "When width={0} and length={1} then exception")
    @MethodSource
    void givenFloorConstructorWhenSettingNegativeValuesThenThrowsException(double width, double length) {
        assertThrows(IllegalArgumentException.class, () -> new Floor(width, length));
    }

    private static Stream<Arguments> givenFloorConstructorWhenSettingNegativeValuesThenThrowsException() {
        return Stream.of(
                arguments(-1, 2),
                arguments(-1, -1),
                arguments(2, -1)
        );
    }
}