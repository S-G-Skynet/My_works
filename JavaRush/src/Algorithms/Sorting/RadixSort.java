package Algorithms.Sorting;

import java.util.*;
 
class RadixSort {
 
    static double getMax(double arr[], int n)
    {
        double mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    static void countSort(double arr[], int n, double exp)
    {
        double output[] = new double[n]; 
        int i;
        double count[] = new double[10];
        Arrays.fill(count, 0);
 
        for (i = 0; i < n; i++)
            count[(int) ((arr[i] / exp) % 10)]++;
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (i = n - 1; i >= 0; i--) {
            output[(int) (count[(int) ((arr[i] / exp) % 10)] - 1)] = arr[i];
            count[(int) ((arr[i] / exp) % 10)]--;
        }
 
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    static void radixsort(double arr[], int n)
    {
        double m = getMax(arr, n);
 
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
 
    static void print(double arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}