package oop.task37;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LampTest {
    @ParameterizedTest(name = "When style={0} and battery={1} and globRating={2} then message={3}")
    @MethodSource
    void givenTurnOnMethodWhenHavingAnyInstanceVarsThenReturnsCorrespondingMessage(String style, boolean battery, int globRating, String expectedMessage) {
        assertEquals(expectedMessage, new Lamp(style, battery, globRating).turnOn());
    }

    private static Stream<Arguments> givenTurnOnMethodWhenHavingAnyInstanceVarsThenReturnsCorrespondingMessage() {
        return Stream.of(
                arguments("Classic", true, 5, "The lamp is turned on"),
                arguments("Modern", false, 4, "The lamp is turned on")
        );
    }

}