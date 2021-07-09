package oop.task35;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CylinderTest {
    @ParameterizedTest(name = "When radius={0} then exception")
    @MethodSource
    void givenCylinderConstructorWhenSettingNegativeValuesThenThrowsException(double radius, double height) {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(radius,height));
    }

    private static Stream<Arguments> givenCylinderConstructorWhenSettingNegativeValuesThenThrowsException() {
        return Stream.of(
                arguments(3.4,-4),
                arguments(-3.4,4),
                arguments(-3.4,-4)
        );
    }
}