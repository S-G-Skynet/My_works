package YandexContestAlgorithms5.HomeWork1_Simple_Algorithms;

import java.util.Scanner;

public class TaskE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        solve(array);
    }
    public static void solve(int[] array) {
        int a = array[0];
        boolean odd = a % 2 == 1 || a % 2 == -1;
        for (int i = 0; i < array.length - 1; i++) {
            if(a == 0 && array[i+1] == 0) {
                System.out.print("+");
                continue;
            }
            if(odd && isOdd(array[i+1])) {
                System.out.print("x");
            }
            else if(!odd && isOdd(array[i+1])) {
                odd = true;
                System.out.print("+");
            }
            else if(odd && !isOdd(array[i+1])) {
                System.out.print("+");
            }
            else if(!odd && !isOdd(array[i+1])) {
                System.out.print("+");
            }
        }
    }
    public static boolean isOdd(int a) {
        return a % 2 == 1 || a % 2 == -1;
    }
}
