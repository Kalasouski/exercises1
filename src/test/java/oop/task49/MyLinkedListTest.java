package oop.task49;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MyLinkedListTest {
    @ParameterizedTest
    @MethodSource
    void givenAddItemMethodWhenPassingNonNullListItemsThenAddsToList(List<Integer> expected) {
        NodeList<Integer> myList = new MyLinkedList<>();
        for (Integer val : expected)
            myList.addItem(new Node<>(val));
        List<Integer> convertedList = myList.traverse(myList.getRoot());
        assertEquals(expected, convertedList);
    }

    @ParameterizedTest
    @MethodSource
    void givenRemoveItemMethodWhenPassingNonNullListItemsThenThenRemovesFromList(List<Integer> givenValues,
                                                                                 List<Integer> toBeDeleted,
                                                                                 List<Integer> expected
    ) {
        NodeList<Integer> myList = new MyLinkedList<>();
        for (Integer val : givenValues)
            myList.addItem(new Node<>(val));
        for (Integer val : toBeDeleted)
            myList.removeItem(new Node<>(val));
        List<Integer> convertedList = myList.traverse(myList.getRoot());
        assertEquals(expected, convertedList);
    }

    private static Stream<Arguments> givenAddItemMethodWhenPassingNonNullListItemsThenAddsToList() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4)),
                arguments(Arrays.asList(-1, 2)),
                arguments(Arrays.asList(-1, 2, 3)),
                arguments(Collections.singletonList(-1)),
                arguments(Collections.emptyList())
        );
    }

    private static Stream<Arguments> givenRemoveItemMethodWhenPassingNonNullListItemsThenThenRemovesFromList() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5), Collections.singletonList(1), Arrays.asList(2, 3, 4, 5)),
                arguments(Arrays.asList(1, 2, 3, 4, 5), Collections.singletonList(4), Arrays.asList(1, 2, 3, 5)),
                arguments(Arrays.asList(1, 2, 3, 4, 5), Collections.singletonList(5), Arrays.asList(1, 2, 3, 4)),
                arguments(Arrays.asList(1, 2, 3, 7, 8), Collections.singletonList(4), Arrays.asList(1, 2, 3, 7, 8)),
                arguments(Arrays.asList(1, 2, 3, 7, 8), Arrays.asList(2, 7), Arrays.asList(1, 3, 8))
        );

    }

}