package Matem;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Gauss {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new FileReader("input.txt"));
        sc.useLocale(Locale.US);

        int n = sc.nextInt();
        double[][] a = new double[n + 1][n + 1];
        double[] b = new double[n + 1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextDouble();
            }
            b[i] = sc.nextDouble();
        }

        int[] alpha = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            alpha[i] = i;
        }

        for (int m = 1; m <= n; m++) {
            double max = Math.abs(a[m][m]);
            int count = m;
            for (int i = m + 1; i <= n; i++) {
                if (Math.abs(a[m][i]) > max) {
                    max = Math.abs(a[m][i]);
                    count = i;
                }
            }

            int tmp = alpha[m];
            alpha[m] = alpha[count];
            alpha[count] = tmp;

            for (int i = m; i <= n; i++) {
                double tmp2 = a[i][m];
                a[i][m] = a[i][count];
                a[i][count] = tmp2;
            }

            for (int i = m + 1; i <= n; i++) {
                b[i] = b[i] - a[i][m] * b[m] / a[m][m];
                for (int j = m + 1; j < n; j++) {
                    a[i][j] = a[i][j] - a[i][m] * a[m][j] / a[m][m];
                }
            }

        }

        double[] x = new double[n+1];
        for (int i = n; i >= 1; i--) {
            double sum = 0;
            for (int j = i + 1; j <= n; j++) {
                sum += a[i][j] * x[alpha[j]];
            }
            x[alpha[i] - 1] = (b[i] - sum) / a[i][i];

        }


        PrintWriter pw = new PrintWriter("output.txt");
        for (int i = 0; i < n; i++) {
            pw.printf(Locale.US, "x%d = %.5f \n", i + 1, x[i]);
        }

        pw.flush();
        pw.close();

    }
}
