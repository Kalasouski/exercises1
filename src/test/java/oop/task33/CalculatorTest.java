package oop.task33;

import oop.task32.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculatorTest {
    private static Stream<Arguments> givenTotalCostMethodWhenSettingValidArgsThenReturnsCorrespondingCost() {
        return Stream.of(
                arguments(2.0,3.4,7,47.6),
                arguments(1.15,2.18,9,22.563)
        );
    }

    @ParameterizedTest(name = "When width={0} and length={1} and cost={3} then result={2}")
    @MethodSource
    void givenTotalCostMethodWhenSettingValidArgsThenReturnsCorrespondingCost(double width, double length, double cost, double expected) {
        assertEquals(expected, new Calculator(new Floor(width, length),new Carpet(cost)).getTotalCost(), 0.0001);
    }
}