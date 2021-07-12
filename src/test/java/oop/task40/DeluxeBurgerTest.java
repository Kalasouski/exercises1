package oop.task40;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeluxeBurgerTest {
    @Test
    public void givenItemizeHamburgerMethodThenReturnsFixedTotalPrice() {
        Hamburger hamburger = new DeluxeBurger();
        assertEquals(19.10, hamburger.itemizeHamburger());
    }
}