package oop.task30;

import lombok.Getter;
import lombok.Setter;

public class Person {
    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private int age;

    public boolean isTeen() {
        return age > 12 && age < 20;
    }

    public String getFullName() {
        if(firstName.isEmpty())
            return lastName;
        if(lastName.isEmpty())
            return firstName;
        return firstName+" "+lastName;
    }
}
