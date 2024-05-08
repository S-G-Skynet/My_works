package Tinkoff.Tasks.Stajirovka;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    private static boolean debug = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        long[][] matrix = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scan.nextLong();
            }
        }

        log("n = " + n);
        log("m = " + m);
        log("matrix = " + Arrays.deepToString(matrix));

        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void log(Object o) {
        if (debug) {
            System.out.println(o);
        }
    }
}