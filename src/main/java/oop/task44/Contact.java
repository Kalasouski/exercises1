package oop.task44;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
public class Contact {
    @Getter
    private final String name;
    @Getter
    private final String phoneNumber;

    public static Contact createContact(String name, String phoneNumber){
        return new Contact(name, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}
