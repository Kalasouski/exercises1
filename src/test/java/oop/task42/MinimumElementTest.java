package oop.task42;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumElementTest {
    private static Stream<Arguments> givenFindMinMethodWhenPassingAnyArrayThenReturnsMinValue() {
        return Stream.of(
                arguments(new int[]{4, 1, 5, 6, 4}, 1),
                arguments(new int[]{-5, 6, -19, 32}, -19)
        );
    }

    @ParameterizedTest
    @MethodSource
    void givenFindMinMethodWhenPassingAnyArrayThenReturnsMinValue(int[] arr, int expected) {
        assertEquals(expected, MinimumElement.findMin(arr));
    }
}