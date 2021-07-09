package oop.task38;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PrinterTest {
    @ParameterizedTest
    @MethodSource
    void givenAddTonerMethodWhenPassingInvalidValuesThenThrowsException(int tonerLevel,
                                                                        boolean duplex,
                                                                        int tonerAmount) {
        assertThrows(IllegalArgumentException.class, () -> new Printer(tonerLevel, duplex).addToner(tonerAmount));
    }

    @ParameterizedTest
    @MethodSource
    void givenPrintPagesMethodWhenPassingAnyValuesThenReturnsNumberOfPagesToPrint(int tonerLevel,
                                                                                  boolean duplex,
                                                                                  int pages,
                                                                                  int expected) {
        assertEquals(expected, new Printer(tonerLevel, duplex).printPages(pages));
    }

    private static Stream<Arguments> givenAddTonerMethodWhenPassingInvalidValuesThenThrowsException() {
        return Stream.of(
                arguments(50, true, 51),
                arguments(50, false, -1)
        );
    }

    private static Stream<Arguments> givenPrintPagesMethodWhenPassingAnyValuesThenReturnsNumberOfPagesToPrint() {
        return Stream.of(
                arguments(50, true, 51,25),
                arguments(50, false, 3,3)
        );
    }
}