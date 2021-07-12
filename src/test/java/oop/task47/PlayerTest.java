package oop.task47;

import oop.task42.MinimumElement;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PlayerTest {
    @ParameterizedTest
    @MethodSource
    void givenWriteMethodWhenSettingAnyInstanceFieldsThenFieldsToStringList(ISaveable player, List<String> expected) {
        assertEquals(expected, player.write());
    }

    private static Stream<Arguments> givenWriteMethodWhenSettingAnyInstanceFieldsThenFieldsToStringList() {
        return Stream.of(
                arguments(new Player("Jack",5,6), Arrays.asList("Jack","Sword","5","6"))
        );
    }
}