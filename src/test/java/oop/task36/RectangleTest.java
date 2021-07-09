package oop.task36;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RectangleTest {
    @ParameterizedTest(name = "When width={0} and length={1} then exception")
    @MethodSource
    void givenRectangleConstructorWhenSettingNegativeValuesThenThrowsException(double width, double length) {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(width, length));
    }

    @ParameterizedTest(name = "When width={0} and length={1} then area={2}")
    @MethodSource
    void givenAreaGetterMethodWhenPassingAnyArgsThenReturnsCorrespondingArea(double width,
                                                                             double length,
                                                                             double expectedArea) {
        assertEquals(expectedArea, new Rectangle(width, length).getArea(), 0.0001);
    }

    private static Stream<Arguments> givenRectangleConstructorWhenSettingNegativeValuesThenThrowsException() {
        return Stream.of(
                arguments(-2.0, 3),
                arguments(2.0, -3),
                arguments(-2.0, -3)
        );
    }

    private static Stream<Arguments> givenAreaGetterMethodWhenPassingAnyArgsThenReturnsCorrespondingArea() {
        return Stream.of(
                arguments(2.0, 3, 6),
                arguments(2.0, 0, 0)
        );
    }
}