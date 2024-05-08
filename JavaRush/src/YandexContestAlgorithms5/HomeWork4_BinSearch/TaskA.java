package YandexContestAlgorithms5.HomeWork4_BinSearch;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        Arrays.sort(array);

        int k = scan.nextInt();
        for (int i = 0; i < k; i++) {
            int L = scan.nextInt();
            int R = scan.nextInt();
            int index1;
            int index2;
            if(L <= array[0]) {
                index1 = 0;
            }else
                index1 = binarySearchForLeft(array, L);
            if(R >= array[n-1]) {
                index2 = n-1;
            }
            else index2 = binarySearchForRight(array, R);
            if (array.length == 1 && (array[0] < L || array[0] > R)) {
                System.out.println(0);
            } else if (array.length == 1) {
                System.out.println(1);
            } else
                System.out.println((index2 - index1) + 1);
        }

        scan.close();
    }

    public static int binarySearchForLeft(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid - 1;
                if (arr[mid] == target)
                    index = mid;
            } else {
                left = mid + 1;
            }
        }

        if (index == -1 && right >= 0 && right < arr.length)
            index = right + 1;
        return index;
    }

    public static int binarySearchForRight(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
                if (arr[mid] == target)
                    index = mid;
            } else {
                right = mid - 1;
            }
        }

        if (index == -1 && left >= 0 && left < arr.length)
            index = left - 1;
        return index;
    }
}


