package oop.task32;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PointTest {
    @ParameterizedTest(name = "When instanceX={0} and instanceY={1} then result={2}")
    @MethodSource
    void givenNoArgsDistanceMethodWhenSettingAnyCoordinatesThenReturnsCorrespondingDistance(int instanceX, int instanceY, double expected) {
        assertEquals(expected,new Point(instanceX,instanceY).distance(),0.0001);
    }

    @ParameterizedTest(name = "When instanceX={0} and instanceY={1} and x={2} y={3} then result={4}")
    @MethodSource("coordinatesToDistance")
    void givenIntArgsDistanceMethodWhenSettingAnyCoordinatesThenReturnsCorrespondingDistance(int instanceX, int instanceY, int x, int y, double expected) {
        assertEquals(expected,new Point(instanceX,instanceY).distance(x,y),0.0001);
    }

    @ParameterizedTest(name = "When instanceX={0} and instanceY={1} and x={2} y={3} then result={4}")
    @MethodSource("coordinatesToDistance")
    void givenPointArgDistanceMethodWhenSettingAnyCoordinatesThenReturnsCorrespondingDistance(int instanceX, int instanceY, int x, int y, double expected) {
        assertEquals(expected,new Point(instanceX,instanceY).distance(new Point(x,y)),0.0001);
    }

    private static Stream<Arguments> givenNoArgsDistanceMethodWhenSettingAnyCoordinatesThenReturnsCorrespondingDistance() {
        return Stream.of(
                arguments(1,-3,3.1622),
                arguments(0,0,0.0),
                arguments(0,3,3.0)
        );
    }

    private static Stream<Arguments> coordinatesToDistance() {
        return Stream.of(
                arguments(1,-3,5,6,9.8488),
                arguments(0,0,5,6,7.8102),
                arguments(0,3,5,6,5.8309),
                arguments(0,0,0,0,0.0)
        );
    }
}