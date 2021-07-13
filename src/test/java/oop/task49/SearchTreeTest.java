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

class SearchTreeTest {
    @ParameterizedTest
    @MethodSource
    void givenAddItemMethodWhenPassingNonNullListItemsThenAddsToTree(List<Integer> givenValues,
                                                                     List<Integer> expected) {
        NodeList<Integer> myList = new SearchTree<>();
        for (Integer val : givenValues)
            myList.addItem(new Node<>(val));
        List<Integer> convertedList = myList.traverse(myList.getRoot());
        assertEquals(expected, convertedList);
    }

    @ParameterizedTest
    @MethodSource
    void givenRemoveItemMethodWhenPassingNonNullListItemsThenRemovesFromTree(List<Integer> givenValues,
                                                                             List<Integer> toBeDeleted,
                                                                             List<Integer> expected) {
        NodeList<Integer> myList = new SearchTree<>();
        for (Integer val : givenValues)
            myList.addItem(new Node<>(val));
        for (Integer val : toBeDeleted)
            myList.removeItem(new Node<>(val));
        List<Integer> convertedList = myList.traverse(myList.getRoot());
        assertEquals(expected, convertedList);
    }

    private static Stream<Arguments> givenAddItemMethodWhenPassingNonNullListItemsThenAddsToTree() {
        return Stream.of(
                arguments(Arrays.asList(2, 1, 3), Arrays.asList(1, 2, 3)),
                arguments(Arrays.asList(6, 4, 8, 7, 10), Arrays.asList(4, 6, 7, 8, 10))
        );
    }

    private static Stream<Arguments> givenRemoveItemMethodWhenPassingNonNullListItemsThenRemovesFromTree() {
        return Stream.of(
                arguments(Arrays.asList(2, 1, 3), Collections.singletonList(1), Arrays.asList(2, 3)),
                arguments(Arrays.asList(6, 4, 8, 7, 10), Collections.singletonList(8), Arrays.asList(4, 6, 7, 10))
        );
    }
}