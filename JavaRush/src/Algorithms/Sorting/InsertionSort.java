package Algorithms.Sorting;

public class InsertionSort {
    public static void insertionSort(double[] sortArr) {
        int j;
        for (int i = 1; i < sortArr.length; i++) {
            double swap = sortArr[i];
            for (j = i; j > 0 && swap < sortArr[j - 1]; j--) {
                sortArr[j] = sortArr[j - 1];
            }
            sortArr[j] = swap;
        }
    }
}
