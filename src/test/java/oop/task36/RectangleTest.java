package oop.task36;

import oop.task35.Circle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RectangleTest {
    private static Stream<Arguments> givenRectangleConstructorWhenSettingNegativeValuesThenThrowsException() {
        return Stream.of(
                arguments(-2.0,3),
                arguments(2.0,-3),
                arguments(-2.0,-3)
        );
    }

    @ParameterizedTest(name = "When width={0} and length={1} then exception")
    @MethodSource
    void givenRectangleConstructorWhenSettingNegativeValuesThenThrowsException(double width,double length) {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(width, length));
    }
}