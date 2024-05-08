package Matem;

import java.util.function.Function;

public class Berrut {
    public static void main(String[] args) {
        double[] xValues = {0.1, 1.2, 4.3, 6.4};
        double[] yValues = {0.7, 20.5, 23.5, 69.7};

        System.out.println(getBerrutRationalFunction(xValues,yValues).apply(0.1).toString());
        System.out.println(getBerrutRationalFunction(xValues,yValues).apply(1.2).toString());
        System.out.println(getBerrutRationalFunction(xValues,yValues).apply(4.3).toString());
    }
    public static Function<Double, Double> getBerrutRationalFunction(double[] xValue, double[] yValue) {
        Function<Double, Double> rationalFunction = (x) -> {
            double dividentSum = 0;
            double divisorSum = 0;
            int n = xValue.length;
            int mulFactor = -1;
            for (int k = 0; k < n; k++) {
                double productX = 1;
                for (int i = 0; i < n; i++) {
                    if (k != i) {
                        productX *= (x - xValue[i]);
                    }
                }
                mulFactor *= -1;
                dividentSum += mulFactor * yValue[k] * productX;
                divisorSum += mulFactor * productX;
            }
            return dividentSum / divisorSum;
        };
        return rationalFunction;
    }
}
