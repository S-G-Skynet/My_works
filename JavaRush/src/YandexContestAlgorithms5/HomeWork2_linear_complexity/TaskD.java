package YandexContestAlgorithms5.HomeWork2_linear_complexity;

import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int count = 0;
        int[][] array = new int[8][8];
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;
            array[x][y] = 1;
            count++;
        }
        System.out.println(4 * count - intersections(array));
    }

    public static int intersections(int[][] array) {
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == 1) {
                    if (i - 1 >= 0 && array[i - 1][j] == 1)
                        ans++;
                    if (i + 1 < array.length && array[i + 1][j] == 1)
                        ans++;
                    if (j - 1 >= 0 && array[i][j - 1] == 1)
                        ans++;
                    if (j + 1 < array[0].length && array[i][j + 1] == 1)
                        ans++;
                }
            }
        }
        return ans;
    }
}
