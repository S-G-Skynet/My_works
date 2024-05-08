package YandexContestAlgorithms5.HomeWork1_Simple_Algorithms;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int P = scan.nextInt();
        final int V = scan.nextInt();
        final int Q = scan.nextInt();
        final int M = scan.nextInt();

        int max1 = P + V;
        int min1 = P - V;

        int max2 = Q + M;
        int min2 = Q - M;

        int max = Math.max(max1, max2);
        int min = Math.min(min1, min2);

        int ans = 0;
        if (min2 > max1 || max2 < min1) {
            ans = Math.abs(max1 - min1) + Math.abs(max2 - min2) + 2;
        } else
            ans = Math.abs(max - min) + 1;

        System.out.println(ans);
    }
}
