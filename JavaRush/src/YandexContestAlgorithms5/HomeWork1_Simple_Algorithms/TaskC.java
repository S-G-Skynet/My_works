package YandexContestAlgorithms5.HomeWork1_Simple_Algorithms;

import java.util.Scanner;

/*
    13 - 4*3 + 1 = 4
    15 - 4 * 4 - 1 = 5
    22 - 4 * 5 + 2 = 7
* */

public class TaskC {

    static final int SPACE = 1;
    static final int TAB = 4;
    static final int BACKSPACE = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] array = new int[n];

        for(int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }

        System.out.println(sumSpace(array));
    }

    public static long sumSpace(int[] array) {
        long sum = 0;
        int ceil = Math.round(15/4);
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0)
                continue;
            int mod = array[i] % TAB;
            switch(mod) {
                case 0 -> sum += array[i]/TAB;
                case 1 -> sum += array[i]/TAB + SPACE;
                case 2 -> sum += array[i]/TAB + 2 * SPACE;
                case 3 -> sum += (array[i] + 1)/TAB + BACKSPACE;
            }
        }
        return sum;
    }
}
