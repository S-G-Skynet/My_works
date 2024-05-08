package Tinkoff.Tasks.Stajirovka;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] array = test(n);
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = scan.nextInt();
//        }
        System.out.println(solve(array));
    }

    public static int solve(int[] array) {
        int count = 0;
        int maxCount = -1;
        int left = 0;
        int right = 0;
        while (right < array.length) {
            if ((right - left + 1) == 7) {
                if (array[right] == 5) {
                    count++;
                } else if (array[right] == 3 || array[right] == 2) {
                    left = right;
                    left++;
                    right++;
                    count = 0;
                }
                if (maxCount < count)
                    maxCount = count;
                right++;
                left++;
                count--;
                continue;
            }
            if (array[right] == 5) {
                count++;
                right++;
                if (maxCount < count && (right - left + 1) == 7)
                    maxCount = count;
            } else if (array[right] == 3 || array[right] == 2) {
                left = right;
                left++;
                right++;
                count = 0;
            } else {
                if (maxCount < count && (right - left + 1) == 7)
                    maxCount = count;
                right++;
            }

        }
        return maxCount;
    }
    public static int[] test(int n){
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(2, 6);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(array[i]).append(" ");
        }
        return array;
    }
}
