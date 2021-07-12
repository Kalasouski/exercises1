package oop.task39;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MitsubishiTest {
    @ParameterizedTest
    @MethodSource("mitsubishiDataStream")
    void givenStartEngineMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car mitsubishi = new Mitsubishi(cylinders, name);
        assertEquals("Mitsubishi -> startEngine()", mitsubishi.startEngine());
    }

    @ParameterizedTest
    @MethodSource("mitsubishiDataStream")
    void givenAccelerateMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car mitsubishi = new Mitsubishi(cylinders, name);
        assertEquals("Mitsubishi -> accelerate()", mitsubishi.accelerate());
    }

    @ParameterizedTest
    @MethodSource("mitsubishiDataStream")
    void givenBrakeMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car mitsubishi = new Mitsubishi(cylinders, name);
        assertEquals("Mitsubishi -> brake()", mitsubishi.brake());
    }

    private static Stream<Arguments> mitsubishiDataStream() {
        return Stream.of(
                arguments(true, "Big"),
                arguments(false, "Big"),
                arguments(false, "Red"),
                arguments(true, "Red")
        );
    }

}