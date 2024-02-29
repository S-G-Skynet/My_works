package Algorithms.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static double[] mergeSort(double[] sortArr) {
        double[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        double[] buffer2 = new double[sortArr.length];
        double[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    public static double[] mergeSortInner(double[] buffer1, double[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        double[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        double[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        // слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        double[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
