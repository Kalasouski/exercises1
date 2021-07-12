package oop.task44;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MobilePhone {
    @Getter
    private final String myNumber;
    private final List<Contact> myContacts = new ArrayList<>();

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public boolean addNewContact(Contact contact) {
        if (myContacts.contains(contact))
            return false;
        return myContacts.add(contact);
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = myContacts.indexOf(oldContact);
        if (index == -1)
            return false;
        myContacts.set(index, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int index = myContacts.indexOf(contact);
        if (index == -1)
            return false;
        myContacts.remove(index);
        return true;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String name) {
        return IntStream.range(0, myContacts.size()).filter(i -> myContacts.get(i).getName().equals(name)).findAny().
                orElse(-1);
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        return index == -1 ? null : myContacts.get(index);
    }

    public List<String> printContacts() {
        if (myContacts.isEmpty())
            return null;
        return myContacts.stream().map(contact -> contact.getName() + " -> " + contact.getPhoneNumber()).
                collect(Collectors.toList());
    }
}
