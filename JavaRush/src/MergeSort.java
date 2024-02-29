import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] A, int p, int r) {
        if (p > r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = A[q + j + 1];
        }

        int i = 0, j = 0;
        int k = p;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                A[k] = leftArray[i];
                i++;
            } else {
                A[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
