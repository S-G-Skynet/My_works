package YandexContestAlgorithms5.HomeWork2_linear_complexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskH {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] all = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                all[i][j] = scan.nextInt();
            }
        }
        solve(all);
        if(count > 31) {
            solve2(all);
        }
    }

    public static void solve2(int[][] arrays) {
        List<int[]> indexesOfMax = indexesOfMax(arrays, max(arrays));
        System.out.println((indexesOfMax.get(0)[0] + 1) + " " + (indexesOfMax.get(1)[1] + 1));
    }

    public static void solve(int[][] arrays) {
        int max = max(arrays);
        int solve = Integer.MAX_VALUE;
        int indexOfSolveRow = 0;
        int indexOfSolveCol = 0;
        List<int[]> indexesOfMax = indexesOfMax(arrays, max);
        if(count > 31)
            return;
        else count = 0;
        for (int[] indexes : indexesOfMax) {
            List<int[]> indexesOfRow = indexesOfMaxRow(arrays, indexes[0]);
            List<int[]> indexesOfCol = indexesOfMaxCol(arrays, indexes[1]);
            for (int[] ints : indexesOfRow) {
                if (ints[2] < solve) {
                    solve = ints[2];
                    indexOfSolveRow = ints[0];
                    indexOfSolveCol = ints[1];
                }
            }
            for (int[] ints : indexesOfCol) {
                if (ints[2] < solve) {
                    solve = ints[2];
                    indexOfSolveRow = ints[0];
                    indexOfSolveCol = ints[1];
                }
            }
        }
        System.out.println((indexOfSolveRow + 1) + " " + (indexOfSolveCol + 1));
    }

    public static int maxRow(int[][] arrays, int indexRow) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                if (i != indexRow) {
                    if (arrays[i][j] > max) {
                        max = arrays[i][j];
                    }
                }
            }
        }
        return max;
    }

    public static List<int[]> indexesOfMaxRow(int[][] arrays, int indexRow) {
        List<int[]> indexes = new ArrayList<>();
        int max = maxRow(arrays, indexRow);
        int k = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                if (arrays[i][j] == max) {
                    indexes.add(new int[3]);
                    indexes.get(k)[0] = indexRow;
                    indexes.get(k)[1] = j;
                    indexes.get(k)[2] = maxOfAll(arrays, indexRow, j);
                    k++;
                }
            }
        }
        return indexes;
    }

    public static int maxCol(int[][] arrays, int indexCol) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                if (j != indexCol) {
                    if (arrays[i][j] > max) {
                        max = arrays[i][j];
                    }
                }
            }
        }
        return max;
    }

    public static List<int[]> indexesOfMaxCol(int[][] arrays, int indexCol) {
        List<int[]> indexes = new ArrayList<>();
        int max = maxCol(arrays, indexCol);
        int k = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                if (arrays[i][j] == max) {
                    indexes.add(new int[3]);
                    indexes.get(k)[0] = i;
                    indexes.get(k)[1] = indexCol;
                    indexes.get(k)[2] = maxOfAll(arrays, i, indexCol);
                    k++;
                }
            }
        }
        return indexes;
    }

    public static int maxOfAll(int[][] arrays, int row, int col) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                if (row != i && col != j) {
                    if (arrays[i][j] > max)
                        max = arrays[i][j];
                }
            }
        }
        return max;
    }

    public static int max(int[][] array) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }


        }
        return max;
    }


    public static List<int[]> indexesOfMax(int[][] array, int max) {
        List<int[]> indexes = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == max) {
                    count++;
                    indexes.add(new int[2]);
                    indexes.get(k)[0] = i;
                    indexes.get(k)[1] = j;
                    k++;
                }
            }
        }
        return indexes;
    }
}
