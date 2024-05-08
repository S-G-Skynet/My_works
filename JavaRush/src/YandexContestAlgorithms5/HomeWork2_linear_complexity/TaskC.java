package YandexContestAlgorithms5.HomeWork2_linear_complexity;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(solve(array));
    }

    public static int solve(int[] array) {

        int max = max(array);
        int sum = -max;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        if(max > sum) {
            return max - sum;
        }
        else
            return max + sum;
    }
    public static int max(int[] array) {
        int max = array[0];

        for(int i = 0; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
