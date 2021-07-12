package oop.task39;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HoldenTest {
    @ParameterizedTest
    @MethodSource("holdenDataStream")
    void givenStartEngineMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car holden = new Holden(cylinders, name);
        assertEquals("Holden -> startEngine()", holden.startEngine());
    }

    @ParameterizedTest
    @MethodSource("holdenDataStream")
    void givenAccelerateMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car holden = new Holden(cylinders, name);
        assertEquals("Holden -> accelerate()", holden.accelerate());
    }

    @ParameterizedTest
    @MethodSource("holdenDataStream")
    void givenBrakeMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car holden = new Holden(cylinders, name);
        assertEquals("Holden -> brake()", holden.brake());
    }

    private static Stream<Arguments> holdenDataStream() {
        return Stream.of(
                arguments(true, "Big"),
                arguments(false, "Big"),
                arguments(false, "Red"),
                arguments(true, "Red")
        );
    }
}