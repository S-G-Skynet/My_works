package YandexContestAlgorithms5.HomeWork4_BinSearch;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();

        long low = 1;
        long high = 10_000_000;
        long result = 0;

        while (low <= high) {
            long k = low + (high - low) / 2;
            long min = minCells(k);

            if (min <= n) {
                result = k;
                low = k + 1;
            } else {
                high = k - 1;
            }
        }

        System.out.println(result);
    }

    public static long minCells(long k) {
        long l = 1;
        long r = k;
        long sum = 0;
        long secondSum = 0;
        while (l <= k && r >= 1) {
            sum += r * l;
            secondSum += l;
            l++;
            r--;
        }
        secondSum = secondSum - 1;
        return sum + secondSum;
    }
}


