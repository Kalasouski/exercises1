package oop.task41;

import oop.task39.Car;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortedArrayTest {
    @ParameterizedTest
    @MethodSource
    void givenArraySorterWhenPassingAnyArrayThenReturnsSortedArray(int[] arr, int[] expected) {
        assertArrayEquals(expected, SortedArray.sortIntegers(arr));
    }

    @ParameterizedTest
    @MethodSource
    void givenReverseIntegersMethodWhenPassingAnyArrayThenReturnsReversedArray(int[] arr, int[] expected) {
        assertArrayEquals(expected, SortedArray.reverseIntegers(arr));
    }

    private static Stream<Arguments> givenArraySorterWhenPassingAnyArrayThenReturnsSortedArray() {
        return Stream.of(
                arguments(new int[]{3,1,5,7,1,2},new int[]{7,5,3,2,1,1}),
                arguments(new int[]{2,5,5,7,1,2},new int[]{7,5,5,2,2,1})
        );
    }

    private static Stream<Arguments> givenReverseIntegersMethodWhenPassingAnyArrayThenReturnsReversedArray() {
        return Stream.of(
                arguments(new int[]{1,2,3,4,5},new int[]{5,4,3,2,1}),
                arguments(new int[]{1,2,3,4,5,6},new int[]{6,5,4,3,2,1})
        );
    }
}