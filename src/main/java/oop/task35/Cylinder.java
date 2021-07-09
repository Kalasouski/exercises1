package oop.task35;

import lombok.Getter;

public class Cylinder extends Circle {
    @Getter
    private final double height;

    public Cylinder(double radius, double height) {
        super(radius);
        if (height < 0)
            throw new IllegalArgumentException("Height must be non-negative");
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }
}