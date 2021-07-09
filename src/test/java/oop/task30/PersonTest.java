package oop.task30;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PersonTest {
    @ParameterizedTest(name = "When age={0} then result={1}")
    @ValueSource(ints = {-1, -3})
    void givenAgeSetterWhenPassingInvalidArgumentsThenThrowsException(int age) {
        Person person = new Person();
        assertThrows(IllegalArgumentException.class, () -> person.setAge(age));
    }

    @ParameterizedTest(name = "When age={0} then result={1}")
    @MethodSource
    void givenIsTeenMethodWhenSettingAnyAgeThenReturnsCorrespondingBooleanValue(int age, boolean expected) {
        Person person = new Person();
        person.setAge(age);
        assertEquals(expected, person.isTeen());
    }

    @ParameterizedTest(name = "When firstName={0} and lastName={1} then result={2}")
    @MethodSource
    void givenFullNameGetterWhenSettingAnyNamesThenReturnsCorrespondingFullName(String firstName, String lastName, String fullName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        assertEquals(fullName, person.getFullName());
    }

    private static Stream<Arguments> givenIsTeenMethodWhenSettingAnyAgeThenReturnsCorrespondingBooleanValue() {
        return Stream.of(
                arguments(12, false),
                arguments(13, true),
                arguments(19, true),
                arguments(25, false)
        );
    }

    private static Stream<Arguments> givenFullNameGetterWhenSettingAnyNamesThenReturnsCorrespondingFullName() {
        return Stream.of(
                arguments("John", "Smith", "John Smith"),
                arguments("John", "", "John"),
                arguments("", "Smith", "Smith"),
                arguments("", "", "")
        );
    }
}