package oop.task39;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CarTest {
    @ParameterizedTest
    @MethodSource("carDataStream")
    void givenStartEngineMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car car = new Car(cylinders, name);
        assertEquals("Car -> startEngine()", car.startEngine());
    }

    @ParameterizedTest
    @MethodSource("carDataStream")
    void givenAccelerateMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car car = new Car(cylinders, name);
        assertEquals("Car -> accelerate()", car.accelerate());
    }

    @ParameterizedTest
    @MethodSource("carDataStream")
    void givenBrakeMethodWhenInvokingThenReturnsCorrespondingMessage(boolean cylinders, String name) {
        Car car = new Car(cylinders, name);
        assertEquals("Car -> brake()", car.brake());
    }

    private static Stream<Arguments> carDataStream() {
        return Stream.of(
                arguments(true, "Big"),
                arguments(false, "Big"),
                arguments(false, "Red"),
                arguments(true, "Red")
        );
    }
}