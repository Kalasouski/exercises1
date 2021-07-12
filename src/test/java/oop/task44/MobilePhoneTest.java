package oop.task44;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MobilePhoneTest {
    @Test
    void givenAddNewContactMethodWhenAddingAnyContactThenAddsToContactList() {
        MobilePhone phone = new MobilePhone("297765431");
        phone.addNewContact(new Contact("Paul", "335475869"));
        assertEquals(Collections.singletonList("Paul -> 335475869"), phone.printContacts());
    }

    @Test
    void givenUpdateContactMethodWhenUpdatingNonExistingContactThenReturnsFalse() {
        MobilePhone phone = new MobilePhone("297765431");
        assertFalse(phone.updateContact(new Contact("Paul", "335475869"), new Contact("abc", "34")));
    }

    @Test
    void givenUpdateContactMethodWhenUpdatingExistingContactThenUpdatesContactList() {
        MobilePhone phone = new MobilePhone("297765431");
        Contact contact = new Contact("Paul", "335475869");
        phone.addNewContact(contact);
        phone.updateContact(contact, new Contact("Derek", "123456789"));
        assertEquals(Collections.singletonList("Derek -> 123456789"), phone.printContacts());
    }

    @Test
    void givenRemoveContactMethodWhenRemovingNonExistingContactThenThenReturnsFalse() {
        MobilePhone phone = new MobilePhone("297765431");
        phone.addNewContact(new Contact("Paul", "335475869"));
        assertFalse(phone.removeContact(new Contact("Jack", "8")));
    }


}