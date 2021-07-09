package oop.task37;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BedroomTest {
    @ParameterizedTest
    @MethodSource
    void givenMakeBedMethodWhenHavingAnyInstanceVarsThenReturnsCorrespondingMessage(String name,
                                                                                    Wall wall1,
                                                                                    Wall wall2,
                                                                                    Wall wall3,
                                                                                    Wall wall4,
                                                                                    Ceiling ceiling,
                                                                                    Bed bed,
                                                                                    Lamp lamp,
                                                                                    String expectedMessage) {

        assertEquals(expectedMessage, new Bedroom(name, wall1, wall2, wall3, wall4, ceiling, bed, lamp).makeBed());
    }

    private static Stream<Arguments> givenMakeBedMethodWhenHavingAnyInstanceVarsThenReturnsCorrespondingMessage() {
        return Stream.of(
                arguments("Room", new Wall("West"), new Wall("East"), new Wall("South"),
                        new Wall("North"), new Ceiling(12, 55),
                        new Bed("Modern", 4, 3, 2, 1),
                        new Lamp("Classic", false, 75),
                        "The bad is being made\nThe bed is ready"
                )
        );
    }
}