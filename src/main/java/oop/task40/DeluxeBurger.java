package oop.task40;

public class DeluxeBurger extends Hamburger {
    public DeluxeBurger() {
        super("deluxe","ham","wheat",19.10);
        super.addHamburgerAddition1("chips",0);
        super.addHamburgerAddition1("drink",0);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        throw new UnsupportedOperationException("No additional items can be added to this burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        throw new UnsupportedOperationException("No additional items can be added to this burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        throw new UnsupportedOperationException("No additional items can be added to this burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        throw new UnsupportedOperationException("No additional items can be added to this burger");
    }
}
