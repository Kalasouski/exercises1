package oop.task36;

import lombok.Getter;

public class Rectangle {
    @Getter
    private final double width;
    @Getter
    private final double length;

    public Rectangle(double width, double length) {
        if (width < 0 || length < 0)
            throw new IllegalArgumentException("Args must me non-negative");
        this.width = width;
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }
}