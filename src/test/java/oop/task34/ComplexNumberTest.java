package oop.task34;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ComplexNumberTest {
    @ParameterizedTest
    @MethodSource
    void givenDoubleArgsAddMethodWhenPassingAnyArgsThenReturnsCorrespondingComplexNumber(double instanceReal,
                                                                                         double instanceImaginary,
                                                                                         double real,
                                                                                         double imaginary,
                                                                                         ComplexNumber expected) {
        assertEquals(expected, new ComplexNumber(instanceReal, instanceImaginary).add(real, imaginary));
    }

    @ParameterizedTest
    @MethodSource
    void givenNumberArgAddMethodWhenPassingAnyArgsThenReturnsCorrespondingComplexNumber(double instanceReal,
                                                                                         double instanceImaginary,
                                                                                         ComplexNumber complexNumber,
                                                                                         ComplexNumber expected) {
        assertEquals(expected, new ComplexNumber(instanceReal, instanceImaginary).add(complexNumber));
    }

    @ParameterizedTest
    @MethodSource
    void givenDoubleArgsSubtractMethodWhenPassingAnyArgsThenReturnsCorrespondingComplexNumber(double instanceReal,
                                                                                         double instanceImaginary,
                                                                                         double real,
                                                                                         double imaginary,
                                                                                         ComplexNumber expected) {
        assertEquals(expected, new ComplexNumber(instanceReal, instanceImaginary).subtract(real, imaginary));
    }

    @ParameterizedTest
    @MethodSource
    void givenNumberArgSubtractMethodWhenPassingAnyArgsThenReturnsCorrespondingComplexNumber(double instanceReal,
                                                                                        double instanceImaginary,
                                                                                        ComplexNumber complexNumber,
                                                                                        ComplexNumber expected) {
        assertEquals(expected, new ComplexNumber(instanceReal, instanceImaginary).subtract(complexNumber));
    }

    private static Stream<Arguments> givenDoubleArgsAddMethodWhenPassingAnyArgsThenReturnsCorrespondingComplexNumber() {
        return Stream.of(
                arguments(2.0, 4.0, -2.0, -4.0, new ComplexNumber(0, 0)),
                arguments(2.0, 4.0, 2.0, 4.0, new ComplexNumber(4, 8))
        );
    }

    private static Stream<Arguments> givenNumberArgAddMethodWhenPassingAnyArgsThenReturnsCorrespondingComplexNumber() {
        return Stream.of(
                arguments(2.0, 4.0, new ComplexNumber(-2, -4), new ComplexNumber(0, 0)),
                arguments(2.0, 4.0, new ComplexNumber(2, 4), new ComplexNumber(4, 8))
        );
    }

    private static Stream<Arguments> givenDoubleArgsSubtractMethodWhenPassingAnyArgsThenReturnsCorrespondingComplexNumber() {
        return Stream.of(
                arguments(2.0, 4.0, -2.0, -4.0, new ComplexNumber(4, 8)),
                arguments(2.0, 4.0, 2.0, 4.0, new ComplexNumber(0, 0))
        );
    }

    private static Stream<Arguments> givenNumberArgSubtractMethodWhenPassingAnyArgsThenReturnsCorrespondingComplexNumber() {
        return Stream.of(
                arguments(2.0, 4.0, new ComplexNumber(-2, -4), new ComplexNumber(4, 8)),
                arguments(2.0, 4.0, new ComplexNumber(2, 4), new ComplexNumber(0, 0))
        );
    }
}