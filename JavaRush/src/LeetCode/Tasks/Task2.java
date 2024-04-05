package LeetCode.Tasks;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n > 100 || n < 1 || m > 100 || m < 1) {
            throw new IllegalArgumentException();
        }

        int[][] fines = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                fines[i][j] = scanner.nextInt();
                if (fines[i][j] > 100 || fines[i][j] < 0) {
                    throw new IllegalArgumentException();
                }
            }
        }

        Result result = findMaximumFoodWeightWithRoute(n, m, fines);

        System.out.println(result.minWeight);
        System.out.println(result.route);

        scanner.close();
    }

    static class Result {
        int minWeight;
        String route;

        Result(int minWeight, String route) {
            this.minWeight = minWeight;
            this.route = route;
        }
    }

    private static Result findMaximumFoodWeightWithRoute(int n, int m, int[][] fines) {
        int[][] maxWeightArray = new int[n][m];

        String[][] routeArray = new String[n][m];

        maxWeightArray[0][0] = fines[0][0];
        routeArray[0][0] = "";
        for (int i = 1; i < n; i++) {
            maxWeightArray[i][0] = maxWeightArray[i - 1][0] + fines[i][0];
            routeArray[i][0] = routeArray[i - 1][0] + "D ";
        }
        for (int j = 1; j < m; j++) {
            maxWeightArray[0][j] = maxWeightArray[0][j - 1] + fines[0][j];
            routeArray[0][j] = routeArray[0][j - 1] + "R ";
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (maxWeightArray[i - 1][j] > maxWeightArray[i][j - 1]) {
                    maxWeightArray[i][j] = fines[i][j] + maxWeightArray[i - 1][j];
                    routeArray[i][j] = routeArray[i - 1][j] + "D ";
                } else {
                    maxWeightArray[i][j] = fines[i][j] + maxWeightArray[i][j - 1];
                    routeArray[i][j] = routeArray[i][j - 1] + "R ";
                }
            }
        }

        return new Result(maxWeightArray[n - 1][m - 1], routeArray[n - 1][m - 1]);
    }
}
