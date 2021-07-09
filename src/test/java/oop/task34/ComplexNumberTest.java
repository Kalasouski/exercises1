package oop.task34;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ComplexNumberTest {
    private static Stream<Arguments> givenDoubleArgsAddMethodWhenPassingAnyArgsThenReturnsCorrespondingComplexNumber() {
        return Stream.of(
                arguments(2.0, 4.0, -2.0, -4.0, new ComplexNumber(0, 0))
        );
    }

    @ParameterizedTest
    @MethodSource
    void givenDoubleArgsAddMethodWhenPassingAnyArgsThenReturnsCorrespondingComplexNumber(double instanceReal, double instanceImaginary, double real, double imaginary, ComplexNumber expected) {
        assertEquals(expected, new ComplexNumber(instanceReal, instanceImaginary).add(real, imaginary));
    }
}