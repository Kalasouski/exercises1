package oop.task29;


import oop.task29.SimpleCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SimpleCalculatorTest {
    @ParameterizedTest(name = "When firstNumber={0} and secondNumber={1} then result={2}")
    @MethodSource
    void givenDivisionMethodWhenPassingValidArgumentsThenReturnsDivisionResult(double firstNumber, double secondNumber, double result) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        assertEquals(result, calculator.getDivisionResult(), 0.001);
    }

    @ParameterizedTest(name = "When firstNumber={0} and secondNumber={1} then exception")
    @MethodSource
    void givenDivisionMethodWhenPassingZeroDenominatorThenThrowsException(double firstNumber, double secondNumber) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        assertThrows(ArithmeticException.class, calculator::getDivisionResult);
    }

    private static Stream<Arguments> givenDivisionMethodWhenPassingValidArgumentsThenReturnsDivisionResult() {
        return Stream.of(
                arguments(4.0, 6.7, 0.5970149253731343),
                arguments(3.25, 1.4, 2.3214285714285716)
        );
    }

    private static Stream<Arguments> givenDivisionMethodWhenPassingZeroDenominatorThenThrowsException() {
        return Stream.of(
                arguments(4.0, 0),
                arguments(3.25, 0)
        );
    }
}