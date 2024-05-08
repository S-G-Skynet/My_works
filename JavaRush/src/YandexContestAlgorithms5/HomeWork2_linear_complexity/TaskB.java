package YandexContestAlgorithms5.HomeWork2_linear_complexity;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(solve(array, k));
    }

    public static int solve(int[] array, int k) {

        int maxProfit = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i + j >= array.length)
                    break;
                if (array[i + j] - array[i] > maxProfit) {
                    maxProfit = array[i + j] - array[i];
                }
            }
        }
        return maxProfit;
    }
}
