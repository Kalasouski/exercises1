package oop.task30;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PersonTest {
    @ParameterizedTest(name = "When age={0} result={1}")
    @ValueSource(ints = {-1, -3})
    void givenAgeSetterWhenPassingInvalidArgumentsThenThrowsException(int age) {
        Person person = new Person();
        assertThrows(IllegalArgumentException.class, () -> person.setAge(age));
    }

    @ParameterizedTest(name = "When age={0} result={1}")
    @MethodSource
    void givenIsTeenMethodThenReturnsCorrespondingBooleanValue(int age, boolean expected) {
        Person person = new Person();
        person.setAge(age);
        assertEquals(expected, person.isTeen());
    }

    private static Stream<Arguments> givenIsTeenMethodThenReturnsCorrespondingBooleanValue() {
        return Stream.of(
                arguments(13, true),
                arguments(12, false),
                arguments(25, false),
                arguments(19, true)
        );
    }
}