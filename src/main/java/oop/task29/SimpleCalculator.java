package oop.task29;

import lombok.Getter;
import lombok.Setter;

public class SimpleCalculator {
    @Getter
    @Setter
    private double firstNumber;

    @Getter
    @Setter
    private double secondNumber;

    public double getAdditionResult(){
        return firstNumber+secondNumber;
    }

    public double getSubtractionResult(){
        return firstNumber-secondNumber;
    }

    public double getMultiplicationResult(){
        return firstNumber*secondNumber;
    }

    public double getDivisionResult(){
        if(secondNumber==0)
            throw new ArithmeticException("Division by zero is prohibited");
        return firstNumber/secondNumber;
    }
}
