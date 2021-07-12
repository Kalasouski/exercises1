package oop.task47;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MonsterTest {
    @ParameterizedTest
    @MethodSource
    void givenWriteMethodWhenSettingAnyInstanceFieldsThenFieldsToStringList(ISaveable monster, List<String> expected) {
        assertEquals(expected, monster.write());
    }

    private static Stream<Arguments> givenWriteMethodWhenSettingAnyInstanceFieldsThenFieldsToStringList() {
        return Stream.of(
                arguments(new Monster("Jack",3,4), Arrays.asList("Jack","3","4"))
        );
    }
}