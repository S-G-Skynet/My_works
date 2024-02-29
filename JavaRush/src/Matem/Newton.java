package Matem;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
public class Newton {

    public static double[] calculateDividedDifference(double[] x, double[] y) {
        int n = x.length;
        double[][] dividedDifference = new double[n][n];

        for (int i = 0; i < n; i++) {
            dividedDifference[i][0] = y[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                dividedDifference[i][j] = (dividedDifference[i + 1][j - 1] - dividedDifference[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        double[] coefficients = new double[n];
        for (int i = 0; i < n; i++) {
            coefficients[i] = dividedDifference[0][i];
        }
        return coefficients;
    }

    public static double interpolate(double[] x, double[] coefficients, double value) {
        double result = coefficients[0];
        double term = 1.0;
        for (int i = 1; i < x.length; i++) {
            term *= (value - x[i - 1]);
            result += term * coefficients[i];
        }
        return result;
    }

    public static void main(String[] args) {

        int n = 4;

        double[] x = {0.1, 1.2, 4.3, 6.4};
        double[] y = {0.7, 20.5, 23.5, 69.7};

        double[] coefficients = calculateDividedDifference(x, y);

        System.out.println("Коэффициенты:");
        for (int i = 0; i < coefficients.length; i++) {
            System.out.println("F(X" + i + "): " + coefficients[i]);
        }

        SwingUtilities.invokeLater(() -> {
            XYSeries series = new XYSeries("Interpolation");

            for (double xi = x[0]; xi <= x[n - 1]; xi += 0.1) {
                double yi = interpolate(x, coefficients, xi);
                series.add(xi, yi);
            }

            for (int i = 0; i < n; i++) {
                series.add(x[i], y[i]);
            }

            XYSeriesCollection dataset = new XYSeriesCollection(series);
            JFreeChart chart = ChartFactory.createXYLineChart(
                    "Newton Polynomial Interpolation",
                    "x",
                    "y",
                    dataset
            );

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(800, 600));
            JFrame frame = new JFrame("Newton Polynomial Interpolation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(chartPanel, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
