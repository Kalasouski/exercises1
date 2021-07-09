package oop.task36;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CuboidTest {
    private static Stream<Arguments> givenCuboidConstructorWhenSettingNegativeValuesThenThrowsException() {
        return Stream.of(
                arguments(-2.0, 3, 5),
                arguments(2.0, -3, 5),
                arguments(-2.0, -3, 5),
                arguments(-2.0, 3, -5),
                arguments(2.0, -3, -5),
                arguments(-2.0, -3, -5)
        );
    }

    @ParameterizedTest(name = "When width={0} and length={1} and height={2} then exception")
    @MethodSource
    void givenCuboidConstructorWhenSettingNegativeValuesThenThrowsException(double width,
                                                                            double length,
                                                                            double height) {
        assertThrows(IllegalArgumentException.class, () -> new Cuboid(width, length, height));
    }

    @ParameterizedTest(name = "When width={0} and length={1} and height={2} then area={3}")
    @MethodSource
    void givenVolumeGetterMethodWhenPassingAnyArgsThenReturnsCorrespondingVolume(double width,
                                                                                 double length,
                                                                                 double height,
                                                                                 double expectedArea) {
        assertEquals(expectedArea, new Cuboid(width, length, height).getVolume(), 0.0001);
    }

    private static Stream<Arguments> givenVolumeGetterMethodWhenPassingAnyArgsThenReturnsCorrespondingVolume() {
        return Stream.of(
                arguments(2.0, 3, 2.1, 12.6),
                arguments(2.0, 0, 3.4, 0)
        );
    }
}