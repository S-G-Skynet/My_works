package Matem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Integral {

    public static double left(List<Double> valuesX, double h) {
        double xi;

        double sum = 0;

        for (int i = 0; i < valuesX.size(); i++) {
            xi = valuesX.get(i);
            double function = function(xi);
            sum += function * h;
        }
        return sum >= 0 ? sum : -sum;
    }

    public static double right(List<Double> valuesX, double h) {
        double xi;

        double sum = 0;

        for (int i = valuesX.size() - 1; i >= 0; i--) {
            xi = valuesX.get(i);
            double function = function(xi);
            sum += function * h;
        }
        return sum >= 0 ? sum : -sum;
    }

    public static double middle(List<Double> valuesX, double h) {
        double xi;

        double sum = 0;

        for (int i = 0; i < valuesX.size() - 1; i++) {
            xi = (valuesX.get(i) + valuesX.get(i + 1))/2;
            double function = function(xi);
            sum += function * h;
        }
        return sum >= 0 ? sum : -sum;
    }

    public static double trapezoid(List<Double> valuesX, double h) {
        double sum = 0;

        for (int i = 0; i < valuesX.size() - 1; i++) {
            double x0 = valuesX.get(i);
            double x1 = valuesX.get(i) + h;

            double y0 = function(x0);

            double y1 = function(x1);

            sum += (y0 + y1)/2 * h;
        }
        return sum >= 0 ? sum : -sum;
    }
    public static double simpson(List<Double> valuesX, double h) {
        double sum = 0;
        for (int i = 0; i < valuesX.size() - 1; i++) {
            double x0 = valuesX.get(i);
            double x1 = (valuesX.get(i) + valuesX.get(i + 1))/2;
            double x2 = valuesX.get(i) + h;

            double y0 = function(x0);

            double y1 = function(x1);

            double y2 = function(x2);

            sum += (y0 + y1*4 + y2) * h/6;
        }
        return sum >= 0 ? sum : -sum;
    }

    public static double function(double x) {
//        double function = 0.7+18*(x-0.1)-(880.0)/(217.0)*(x-0.1)*(x-1.2)+
//                (22.85)/(0.7*1.3*3.1*6.3)*(x-0.1)*(x-1.2)*(x-4.3);
        double function = x;
        return function;
    }

    public static void main(String[] args) {
        double[] x = {0,10};
        double h = 0.1;
        List<Double> valuesX = new ArrayList<>();
        for (double i = x[0]; i <= x[1]; i+=h) {
            valuesX.add((double) Math.round((i) * 1000) / 1000);
        }
        System.out.println("Метод прямоугольников:");
        System.out.println("Левая: S = " + left(valuesX,h));
        System.out.println("Правая S = " + right(valuesX,h));
        System.out.println("Средняя: S = " + middle(valuesX,h));
        System.out.println("\n" + "Метод трапеции:");
        System.out.println("S = " + trapezoid(valuesX,h));
        System.out.println("\n" + "Метод Симпсона (Парабол): ");
        System.out.println("S = " + simpson(valuesX,h));
    }
}

