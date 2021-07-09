package oop.task35;


import lombok.Getter;

public class Circle {
    @Getter
    private final double radius;

    public Circle(double radius) {
        if(radius<0)
            throw new IllegalArgumentException("Radius must be non-negative");
        this.radius = radius;
    }

    public double getArea() {
        return radius*radius*Math.PI;
    }
}
