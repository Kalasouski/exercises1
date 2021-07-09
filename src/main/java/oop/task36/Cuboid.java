package oop.task36;

import lombok.Getter;

public class Cuboid extends Rectangle{
    @Getter
    private final double height;

    public Cuboid(double width, double length, double height) {
        super(width, length);
        if (height<0)
            throw new IllegalArgumentException("Height must me non-negative");
        this.height=height;
    }

    public double getVolume() {
        return getArea() * height;
    }
}
