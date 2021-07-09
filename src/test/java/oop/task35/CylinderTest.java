package oop.task35;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CylinderTest {
    @ParameterizedTest(name = "When radius={0} then exception")
    @MethodSource
    void givenCylinderConstructorWhenSettingNegativeValuesThenThrowsException(double radius, double height) {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(radius, height));
    }

    @ParameterizedTest(name = "When radius={0} and height={1} then volume={2}")
    @MethodSource
    void givenVolumeGetterMethodWhenPassingAnyArgsThenReturnsCorrespondingVolume(double radius,
                                                                                 double height,
                                                                                 double expectedVolume) {
        assertEquals(expectedVolume, new Cylinder(radius, height).getVolume(), 0.0001);
    }

    private static Stream<Arguments> givenCylinderConstructorWhenSettingNegativeValuesThenThrowsException() {
        return Stream.of(
                arguments(3.4, -4),
                arguments(-3.4, 4),
                arguments(-3.4, -4)
        );
    }

    private static Stream<Arguments> givenVolumeGetterMethodWhenPassingAnyArgsThenReturnsCorrespondingVolume() {
        return Stream.of(
                arguments(3.4, 5, 181.5840),
                arguments(5, 5, 392.6990),
                arguments(0, 5, 0)
        );
    }
}