package basics.task8;

public class AreaCalculator {
    public static double area(double radius) {
        if (radius < 0)
            throw new IllegalArgumentException("Radius must be non-negative number");
        return radius * radius * Math.PI;
    }

    public static double area(double x, double y) {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException("Sides must be non-negative numbers");
        return x * y;
    }
}
