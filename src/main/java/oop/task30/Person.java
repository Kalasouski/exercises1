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
    private int age;

    public void setAge(int age) {
        if(age<0)
            throw new IllegalArgumentException("Age must be non-negative number");
        this.age = age;
    }

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