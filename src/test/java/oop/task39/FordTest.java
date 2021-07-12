package oop.task39;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FordTest {
    @ParameterizedTest
    @MethodSource("fordDataStream")
    void givenStartEngineMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car ford = new Ford(cylinders, name);
        assertEquals("Ford -> startEngine()", ford.startEngine());
    }

    @ParameterizedTest
    @MethodSource("fordDataStream")
    void givenAccelerateMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car ford = new Ford(cylinders, name);
        assertEquals("Ford -> accelerate()", ford.accelerate());
    }

    @ParameterizedTest
    @MethodSource("fordDataStream")
    void givenBrakeMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car ford = new Ford(cylinders, name);
        assertEquals("Ford -> brake()", ford.brake());
    }

    private static Stream<Arguments> fordDataStream() {
        return Stream.of(
                arguments(true, "Big"),
                arguments(false, "Big"),
                arguments(false, "Red"),
                arguments(true, "Red")
        );
    }
}