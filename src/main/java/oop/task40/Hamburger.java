package oop.task40;

import lombok.Getter;

public class Hamburger {
    @Getter
    private final String name;
    @Getter
    private final String meat;
    @Getter
    private final String breadRollType;
    private final double price;

    @Getter
    private String addition1Name;
    private double addition1Price;

    @Getter
    private String addition2Name;
    private double addition2Price;

    @Getter
    private String addition3Name;
    private double addition3Price;

    @Getter
    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String meat, String breadRollType, double price) {
        this.name = name;
        this.meat = meat;
        this.breadRollType = breadRollType;
        this.price = price;
    }

    public void addHamburgerAddition1(String name, double price) {
        addition1Name = name;
        addition1Price = price;
    }

    public void addHamburgerAddition2(String name, double price) {
        addition2Name = name;
        addition2Price = price;
    }

    public void addHamburgerAddition3(String name, double price) {
        addition3Name = name;
        addition3Price = price;
    }

    public void addHamburgerAddition4(String name, double price) {
        addition4Name = name;
        addition4Price = price;
    }

    public double itemizeHamburger() {
        return price + addition1Price + addition2Price + addition3Price + addition4Price;
    }
}