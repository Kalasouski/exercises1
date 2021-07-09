package oop.task35;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CircleTest {
    @ParameterizedTest(name = "When radius={0} then exception")
    @ValueSource(doubles = {-1, -100})
    void givenCircleConstructorWhenSettingNegativeValueThenThrowsException(double radius) {
        assertThrows(IllegalArgumentException.class, () -> new Circle(radius));
    }

    @ParameterizedTest(name = "When radius={0} then area={1}")
    @MethodSource
    void givenAreaGetterMethodWhenPassingAnyArgsThenReturnsCorrespondingArea(double radius,
                                                                             double expectedArea) {
        assertEquals(expectedArea, new Circle(radius).getArea(), 0.0001);
    }

    private static Stream<Arguments> givenAreaGetterMethodWhenPassingAnyArgsThenReturnsCorrespondingArea() {
        return Stream.of(
                arguments(3.4, 36.3168),
                arguments(5, 78.5398),
                arguments(0, 0)
        );
    }
}