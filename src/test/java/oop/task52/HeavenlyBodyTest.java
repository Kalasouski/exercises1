package oop.task52;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HeavenlyBodyTest {
    @ParameterizedTest
    @MethodSource
    void givenEqualsMethodWhenPassingAnyArgumentsThenReturnsCorrespondingBooleanValue(HeavenlyBody thisBody,
                                                                                      HeavenlyBody argumentBody,
                                                                                      boolean expected) {
        assertEquals(expected, thisBody.equals(argumentBody));
    }

    private static Stream<Arguments> givenEqualsMethodWhenPassingAnyArgumentsThenReturnsCorrespondingBooleanValue() {
        return Stream.of(
                arguments(new HeavenlyBody("Earth", 6.7, HeavenlyBody.BodyType.PLANET),
                        new HeavenlyBody("Earth", -5, HeavenlyBody.BodyType.PLANET),
                        true),
                arguments(new HeavenlyBody("Earth", 6.7, HeavenlyBody.BodyType.PLANET),
                        new Planet("Earth", -5),
                        true),
                arguments(new HeavenlyBody("Earth", 6.7, HeavenlyBody.BodyType.PLANET),
                        new Planet("Venus", -5),
                        false),
                arguments(new HeavenlyBody("Earth", 6.7, HeavenlyBody.BodyType.PLANET),
                        new HeavenlyBody("Earth", -5, HeavenlyBody.BodyType.DWARF_PLANET),
                        false)
        );
    }
}