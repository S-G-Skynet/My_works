package YandexContestAlgorithms5.HomeWork4_BinSearch;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        long[] array = new long[n];
        long[] sumArray = new long[n + 1];
        long sum = 0;
        sumArray[0] = sum;
        for (int i = 0; i < array.length; i++) {
            int x = scan.nextInt();
            array[i] = x;
            sum += x;
            sumArray[i + 1] = sum;
        }
        for (int i = 1; i <= m; i++) {
            int l = scan.nextInt();
            long s = scan.nextLong();

            int ans1 = binarySearch1(sumArray, l, s);
            int ans2 = binarySearch2(sumArray, l, s);
            System.out.println(Math.max(ans1,ans2));
        }
    }

    public static int binarySearch1(long[] sumArray, int l, long s) {
        int len = sumArray.length;
        int left = 0;
        int right = len - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = mid + l < len ? sumArray[mid + l] - sumArray[mid] : Long.MAX_VALUE;
            if (sum < s) {
                left = mid + 1;
            } else if (sum > s) {
                right = mid - 1;
            } else {
                index = mid + 1;
                break;
            }

        }
        return index;
    }

    public static int binarySearch2(long[] sumArray, int l, long s) {
        int len = sumArray.length;
        int left = 0;
        int right = len - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = mid - l >= 0 ? sumArray[mid] - sumArray[mid - l] : Long.MAX_VALUE;
            if (sum < s) {
                left = mid + 1;
            } else if (sum > s) {
                right = mid - 1;
            } else {
                index = mid - l + 1;
                break;
            }
        }
        return index;
    }

}


