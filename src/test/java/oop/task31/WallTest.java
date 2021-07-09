package oop.task31;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WallTest {
    @ParameterizedTest(name = "When width={0} then result={1}")
    @MethodSource("inputSizeToExpectedSize")
    void givenWidthSetterWhenPassingAnyArgumentsThenSetsCorrespondingValue(double width, double expectedWidth) {
        Wall wall = new Wall();
        wall.setWidth(width);
        assertEquals(expectedWidth, wall.getWidth());
    }

    @ParameterizedTest(name = "When height={0} then result={1}")
    @MethodSource("inputSizeToExpectedSize")
    void givenHeightSetterWhenPassingAnyArgumentsThenSetsCorrespondingValue(double height, double expectedHeight) {
        Wall wall = new Wall();
        wall.setHeight(height);
        assertEquals(expectedHeight, wall.getHeight());
    }

    private static Stream<Arguments> inputSizeToExpectedSize() {
        return Stream.of(
                arguments(-1.0, 0.0),
                arguments(0.0, 0.0),
                arguments(1.0, 1.0)
        );
    }
}