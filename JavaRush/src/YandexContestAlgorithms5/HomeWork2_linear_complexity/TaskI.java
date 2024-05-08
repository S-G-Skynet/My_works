package YandexContestAlgorithms5.HomeWork2_linear_complexity;

import java.util.*;

public class TaskI {
    /*
10
4 4
10 2
5 5
5 1
1 8
9 3
9 6
8 5
1 9
4 5


0 0 0 0 3 0 0 x x 0
0 0 0 0 5 0 0 0 0 0
0 0 0 0 2 0 0 0 0 0
0 0 0 x x 0 0 0 0 0
x 0 0 0 x 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 x 0 0 0 0 0
0 0 x 0 0 x 0 0 0 0
0 x 0 0 0 0 0 0 0 0
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int ans = 0;
        int solve = 0;
        int minSolve = Integer.MAX_VALUE;
        boolean[][] isShip = new boolean[n][n];
        int[] X = new int[n];
        int[] Y = new int[n];
        int[] tempX = new int[n];
        int[] tempY = new int[n];
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            X[i] = x;
            Y[i] = y;
            tempX[i] = x;
            tempY[i] = y;
            isShip[x - 1][y - 1] = true;
        }
        sort(tempX,tempY);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.abs(i - tempY[j]);
                solve += ans;
                if (!isShip[tempX[j] - 1][i - 1]) {
                    isShip[tempX[j] - 1][i - 1] = true;
                } else {
                    if(ans != 0) {
                        int f = 0;
                        int count = 0;
                        for (int k = tempX[j] - 1; k >= 0; k--) {
                            if(isShip[k][i - 1]){
                                count++;
                            }
                            else {
                                isShip[k][i - 1] = true;
                                solve += count;
                                f = 1;
                                break;
                            }
                        }
                        if(f == 1) {
                            continue;
                        }
                        for (int k = tempX[j] - 1; k < n; k++) {
                            if(isShip[k][i - 1]){
                                solve++;
                            }
                            else {
                                isShip[k][i - 1] = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(solve < minSolve)
                minSolve = solve;
            solve = 0;
        }
        System.out.println(minSolve);
    }
    public static void sort(int[] arrayX, int[] arrayY) {
        for (int i = 0; i < arrayX.length - 1; i++) {
            for (int j = 0; j < arrayX.length - i - 1; j++) {
                if (arrayX[j] > arrayX[j+1]) {
                    int swapX = arrayX[j];
                    int swapY = arrayY[j];

                    arrayX[j] = arrayX[j + 1];
                    arrayX[j + 1] = swapX;

                    arrayY[j] = arrayY[j + 1];
                    arrayY[j + 1] = swapY;
                }
                else if(arrayX[j] == arrayX[j+1]) {
                    if(arrayY[j] > arrayY[j+1]) {
                        int swapX = arrayX[j];
                        int swapY = arrayY[j];

                        arrayX[j] = arrayX[j + 1];
                        arrayX[j + 1] = swapX;

                        arrayY[j] = arrayY[j + 1];
                        arrayY[j + 1] = swapY;
                    }
                }
            }
        }
    }
}
