package Tasks;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args)  throws Exception {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n > 20 || n < 1 || m > 20 || m < 1) {
            throw new IllegalArgumentException();
        }

        int[][] fines = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                fines[i][j] = scanner.nextInt();
                if(fines[i][j] > 100 || fines[i][j] < 0) {
                    throw new IllegalArgumentException();
                }
            }
        }

        int minWeight = findMinimumFoodWeight(n, m, fines);

        System.out.println(minWeight);

        scanner.close();
    }

    private static int findMinimumFoodWeight(int n, int m, int[][] fines) {
        int[][] minWeightArray = new int[n][m];

        minWeightArray[0][0] = fines[0][0];
        for (int i = 1; i < n; i++) {
            minWeightArray[i][0] = minWeightArray[i - 1][0] + fines[i][0];
        }
        for (int j = 1; j < m; j++) {
            minWeightArray[0][j] = minWeightArray[0][j - 1] + fines[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                minWeightArray[i][j] = fines[i][j] + Math.min(minWeightArray[i - 1][j], minWeightArray[i][j - 1]);
            }
        }
        return minWeightArray[n - 1][m - 1];
    }

}
