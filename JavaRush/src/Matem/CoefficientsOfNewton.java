package Matem;

public class CoefficientsOfNewton {
    public static void main(String[] args) {

        double[] x = {0.1, 1.2, 4.3, 6.4};
        double[] y = {0.7, 20.5, 23.5, 69.7};

        double[] coefficients = calculateCoefficients(x, y);

        // Display the coefficients
        System.out.println("\nКоэффициенты полинома Ньютона");
        for (int i = 0; i < coefficients.length; i++) {
            System.out.println("f(X" + i + ") = " + coefficients[i]);
        }

    }

    public static double[] calculateCoefficients(double[] x, double[] y) {
        int n = x.length;
        double[] f = new double[n];
        double[] coefficients = new double[n];

        for (int i = 0; i < n; i++) {
            f[i] = y[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                f[j] = (f[j] - f[j - 1]) / (x[j] - x[j - i]);
            }
        }

        for (int i = 0; i < n; i++) {
            coefficients[i] = f[i];
        }

        return coefficients;
    }
}
