package Tinkoff.Tasks.Stajirovka;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String direction = scan.next();
//        long[][] matrix = new long[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = scan.nextLong();
//            }
//        }

        int opCount = n * (n - 1) / 2 + (n % 2 == 0 ? n * n / 2 : n * (n - 1) / 2);
        System.out.println(opCount);

        if (direction.equals("L")) {
            printLMirroring(n);
        } else {
            printRMirroring(n);
        }
        printHorizMirroring(n);
    }

    private static void printLMirroring(int n) {
        for (int col = 1; col < n; col++) {
            for (int row = 0; row < col; row++) {
                System.out.println(row + " " + col + " " + col + " " + row);
            }
        }
    }

    private static void printRMirroring(int n) {
        for (int row = 0; row < n - 1; row++) {
            for (int col = 0; col < n - 1 - row; col++) {
                System.out.println(row + " " + col + " " + (n - 1 - col) + " " + (n - 1 - row));
            }
        }
    }

    private static void printHorizMirroring(int n) {
        for (int row = 0; row < n / 2; row++) {
            for (int col = 0; col < n; col++) {
                System.out.println(row + " " + col + " " + (n - 1 - row) + " " + col);
            }
        }
    }
}
