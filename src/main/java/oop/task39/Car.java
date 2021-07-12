package oop.task39;

public class Car {
    private final boolean engine = true;
    private final boolean cylinders;
    private final String name;
    private final int wheels = 4;

    public Car(boolean cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
    }

    public String startEngine() {
        return "Car -> startEngine()";
    }

    public String accelerate() {
        return "Car -> accelerate()";
    }

    public String brake() {
        return "Car -> brake()";
    }

    public boolean isCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}
