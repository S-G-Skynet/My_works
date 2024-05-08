package YandexContestAlgorithms5.HomeWork2_linear_complexity;

import java.util.Scanner;

public class TaskF {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] sectors = new int[n * 2 + 1];
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            sectors[i] = a;
            sectors[n + i] = a;
        }
        sectors[sectors.length - 1] = sectors[0];
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        int k = scan.nextInt();

        int y = v1 / k;
        int max = max(sectors);
        if (v1 % k == 0) {
            y--;
        }
        int y2 = v2 / k;
        if (v2 % k == 0) {
            y2--;
        }

        if (v1 < k && y2 >= n - 1) {
            System.out.println(max);
        } else if (v1 < k)
            v1 = k;

        int sector = y % n;

        int maxAnswer = Math.max(right(sector, sectors, v2, v1, k), left(sector, sectors, v2, v1, k));
        System.out.println(maxAnswer);
    }

    public static int right(int sector, int[] array, int v2, int v1, int k) {
        int j = 0;
        int max = array[sector];
        for (int i = sector; i < array.length / 2 + sector; i++) {
            if (sector == 0) {
                if (v1 + j * k >= v2)
                    break;
                else {
                    j++;
                    if (array[i + 1] > max)
                        max = array[i + 1];
                }
            }
            if (v1 + j * k >= v2)
                break;
            else {
                j++;
                if (array[i] > max)
                    max = array[i];
            }
        }
        return max;
    }

    public static int left(int sector, int[] array, int v2, int v1, int k) {
        int j = 0;
        int max = array[(array.length - 1) - sector];
        for (int i = (array.length - 1) - sector; i > (array.length / 2 - 1) - sector; i--) {
            if (sector == 0) {
                if (v1 + j * k >= v2)
                    break;
                else {
                    j++;
                    if (array[i - 1] > max)
                        max = array[i - 1];
                }
            }
            if (v1 + j * k >= v2)
                break;
            else {
                j++;
                if (array[i] > max)
                    max = array[i];
            }
        }
        return max;
    }

    public static int max(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}