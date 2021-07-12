package oop.task44;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MobilePhoneTest {
    @ParameterizedTest
    @MethodSource
    void givenAddNewContactMethodWhenAddingAnyContactThenAddsToContactList(Contact contact, List<String> expected) {
        MobilePhone phone = new MobilePhone("297765431");
        phone.addNewContact(contact);
        assertEquals(expected, phone.printContacts());
    }

    @ParameterizedTest
    @MethodSource
    void givenUpdateContactMethodWhenUpdatingNonExistingContactThenReturnsFalse(Contact contact) {
        MobilePhone phone = new MobilePhone("297765431");
        assertFalse(phone.updateContact(contact, new Contact("abc", "34")));
    }

    @ParameterizedTest
    @MethodSource
    void givenUpdateContactMethodWhenUpdatingExistingContactThenUpdatesContactList(Contact oldContact,
                                                                                   Contact newContact,
                                                                                   List<String> expected) {
        MobilePhone phone = new MobilePhone("297765431");
        phone.addNewContact(oldContact);
        phone.updateContact(oldContact, newContact);
        assertEquals(expected, phone.printContacts());
    }

    private static Stream<Arguments> givenAddNewContactMethodWhenAddingAnyContactThenAddsToContactList() {
        return Stream.of(
                arguments(new Contact("Paul","335475869"),
                        Collections.singletonList("Paul -> 335475869"))
        );
    }

    private static Stream<Arguments> givenUpdateContactMethodWhenUpdatingNonExistingContactThenReturnsFalse() {
        return Stream.of(
                arguments(new Contact("Paul","335475869"))
        );
    }

    private static Stream<Arguments> givenUpdateContactMethodWhenUpdatingExistingContactThenUpdatesContactList() {
        return Stream.of(
                arguments(
                        new Contact("Paul","335475869"),
                        new Contact("Derek","123456789"),
                        Collections.singletonList("Derek -> 123456789"))
        );
    }
}