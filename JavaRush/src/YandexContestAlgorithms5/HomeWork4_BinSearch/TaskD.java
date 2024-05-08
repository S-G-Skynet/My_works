package YandexContestAlgorithms5.HomeWork4_BinSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("input.txt"));
        Scanner scan = new Scanner(read);
        int w = scan.nextInt();
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] array1 = new int[n];
        int[] array2 = new int[m];
        for (int i = 0; i < n; i++) {
            array1[i] = scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            array2[i] = scan.nextInt();
        }
        int max1 = max(array1);
        int max2 = max(array2);


        System.out.println(solve(max1, max2, w, array1, array2));
    }

    public static int solve(int max1, int max2, int weight, int[] array1, int[] array2) {
        int left = 0;
        int right = 1_000_000;
        int ans = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int check = check(max1, max2, mid, weight, array1, array2);
            if (check > 0) {
                right = mid;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int check(int max1, int max2, int height, int weight, int[] array1, int[] array2) {
        int left = 0;
        int right = weight;
        int ans = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long minCells1 = minCells(array1, height, mid,max1);
            long minCells2 = minCells(array2, height, weight - mid,max2);
            if ((long) mid * height >= minCells1 && (long) (weight - mid) * height >= minCells2 && mid >= max1 && (weight - mid) >= max2) {
                ans = mid;
                return ans;
            } else {
                if (left + 1 == right) {
                    if ((long) left * height > minCells1 && (long) (weight - left) * height > minCells2 && left >= max1 && (weight - left) >= max2) {
                        ans = left;
                        return ans;
                    }
                    break;
                } else {
                    if ((long) mid * height <= minCells1 || mid < max1)
                        left = mid;
                    else if ((long) (weight - mid) * height <= minCells2 || (weight - mid) < max2)
                        right = mid;
                }
            }
        }
        return ans;
    }

    public static long minCells(int[] array, int height, int mid, int max) {
        int border = mid;
        if(border < max)
            return Long.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= border) {
                border -= (array[i] + 1);
            } else {
                border = mid;
                height--;
                if (height == 0)
                    return Long.MAX_VALUE;
                border -= (array[i] + 1);
            }
        }
        return 0;
    }

    public static int cells(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i] + 1;
        }
        return sum - 1;
    }

    public static int max(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}



