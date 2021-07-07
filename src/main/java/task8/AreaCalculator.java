package task8;

import java.math.BigDecimal;

public class AreaCalculator {
    public static double area(double radius) {
        if(radius<0)
            throw new IllegalArgumentException("Radius must be non-negative number");
       return radius*radius*Math.PI;
        /*
            if I want to check if overflows:

            BigDecimal res = BigDecimal.valueOf(Math.PI).multiply(BigDecimal.valueOf(radius)).
                multiply(BigDecimal.valueOf(radius));
            double resDouble = res.doubleValue();
            if(resDouble == Double.POSITIVE_INFINITY)
                throw new IllegalArgumentException("The radius is too big");
            return res.doubleValue();

         */
    }
    public static double area(double x, double y) {
        if(x<0 || y<0)
            throw new IllegalArgumentException("Sides must be non-negative numbers");
        return x*y;
        /*
            if I want to check if overflows:

            BigDecimal res = BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y));
            double resDouble = res.doubleValue();
            if(resDouble == Double.POSITIVE_INFINITY)
                throw new IllegalArgumentException("The sides are too big");
            return res.doubleValue();
         */
    }
}
