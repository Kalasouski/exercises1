package oop.task37;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BedTest {
    @ParameterizedTest(name = "When style={0} and pillows={1} and height={2} and sheets={3} and quilt={4} then message={5}")
    @MethodSource
    void givenMakeMethodWhenHavingAnyInstanceVarsThenReturnsCorrespondingMessage(String style, int pillows, int height, int sheets, int quilt, String expectedMessage) {
        assertEquals(expectedMessage, new Bed(style, pillows, height, sheets, quilt).make());
    }

    private static Stream<Arguments> givenMakeMethodWhenHavingAnyInstanceVarsThenReturnsCorrespondingMessage() {
        return Stream.of(
                arguments("Classic", 5, 6, 7, 8, "The bed is ready")
        );
    }
}