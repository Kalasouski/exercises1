package oop.task33;

public class Floor {
    private final double width;
    private final double length;

    public Floor(double width, double length) {
        if(width<0 || length<0)
            throw new IllegalArgumentException("Args must me non-negative");
        this.width = width;
        this.length = length;
    }

    public double getArea() {
        return width*length;
    }
}
