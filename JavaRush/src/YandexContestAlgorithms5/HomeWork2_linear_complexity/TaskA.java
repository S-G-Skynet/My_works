package YandexContestAlgorithms5.HomeWork2_linear_complexity;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arrayX = new int[n];
        int[] arrayY = new int[n];
        for(int i = 0; i < n; i++) {
            arrayX[i] = scan.nextInt();
            arrayY[i] = scan.nextInt();
        }

        System.out.printf("%d %d %d %d",min(arrayX),min(arrayY),max(arrayX),max(arrayY));
    }

    public static int max(int[] array) {
        int max = array[0];

        for(int i = 0; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int min(int[] array) {
        int min = array[0];

        for(int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
