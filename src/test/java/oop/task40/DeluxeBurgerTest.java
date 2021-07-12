package oop.task40;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DeluxeBurgerTest {
    @Test
    public void givenItemizeHamburgerMethodThenReturnsFixedTotalPrice() {
        Hamburger hamburger = new DeluxeBurger();
        assertEquals(19.10, hamburger.itemizeHamburger());
    }

    @Test
    public void givenAddHamburgerAddition1MethodThenThrowsException() {
        Hamburger hamburger = new DeluxeBurger();
        assertThrows(UnsupportedOperationException.class,()->hamburger.addHamburgerAddition1("name",5));
    }

    @Test
    public void givenAddHamburgerAddition2MethodThenThrowsException() {
        Hamburger hamburger = new DeluxeBurger();
        assertThrows(UnsupportedOperationException.class,()->hamburger.addHamburgerAddition2("name",5));
    }

    @Test
    public void givenAddHamburgerAddition3MethodThenThrowsException() {
        Hamburger hamburger = new DeluxeBurger();
        assertThrows(UnsupportedOperationException.class,()->hamburger.addHamburgerAddition3("name",5));
    }

    @Test
    public void givenAddHamburgerAddition4MethodThenThrowsException() {
        Hamburger hamburger = new DeluxeBurger();
        assertThrows(UnsupportedOperationException.class,()->hamburger.addHamburgerAddition4("name",5));
    }
}