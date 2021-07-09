package oop.task33;

import lombok.Getter;

public class Carpet {
    @Getter
    private final double cost;

    public Carpet(double cost) {
        if (cost < 0)
            throw new IllegalArgumentException("Cost must be non-negative");
        this.cost = cost;
    }
}
