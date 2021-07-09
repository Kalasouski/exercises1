package oop.task34;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
public class ComplexNumber {
    @Getter
    private final double real;
    @Getter
    private final double imaginary;

    public ComplexNumber add(double real, double imaginary) {
        return new ComplexNumber(this.real + real, this.imaginary + imaginary);
    }

    public ComplexNumber add(ComplexNumber complexNumber) {
        return add(complexNumber.real, complexNumber.imaginary);
    }

    public ComplexNumber subtract(double real, double imaginary) {
        return new ComplexNumber(this.real - real, this.imaginary - imaginary);
    }

    public ComplexNumber subtract(ComplexNumber complexNumber) {
        return subtract(complexNumber.real, complexNumber.imaginary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return that.real == real && that.imaginary == imaginary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }
}
