package Matem;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Lagrange extends JFrame {

    public Lagrange() {
        super("Lagrange Interpolation Plot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
    }

    private JPanel createChartPanel() {
        String chartTitle = "Lagrange Interpolation";
        String xAxisLabel = "X";
        String yAxisLabel = "Y";

        XYSeriesCollection dataset = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset);

        return new ChartPanel(chart);
    }

    private XYSeriesCollection createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        double[] xValues = {0.1, 1.2, 4.3, 6.4};
        double[] yValues = {0.7, 20.5, 23.5, 69.7};

        List<Double> interpolatedXValues = new ArrayList<>();
        List<Double> interpolatedYValues = new ArrayList<>();

        double startX = -5;
        double endX = 10;
        double stepSize = 0.1;

        for (double x = startX; x <= endX; x += stepSize) {
            double interpolatedY = lagrangeInterpolate(xValues, yValues, x);
            interpolatedXValues.add(x);
            interpolatedYValues.add(interpolatedY);
        }

        XYSeries series = new XYSeries("Interpolated Data");
        for (int i = 0; i < interpolatedXValues.size(); i++) {
            series.add(interpolatedXValues.get(i), interpolatedYValues.get(i));
        }
        dataset.addSeries(series);

        return dataset;
    }

    private double lagrangeInterpolate(double[] xValues, double[] yValues, double x) {
        double result = 0;
        for (int i = 0; i < xValues.length; i++) {
            double term = yValues[i];
            for (int j = 0; j < xValues.length; j++) {
                if (j != i) {
                    term *= (x - xValues[j]) / (xValues[i] - xValues[j]);
                }
            }
            result += term;
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Lagrange ex = new Lagrange();
            ex.setVisible(true);
        });
    }
}