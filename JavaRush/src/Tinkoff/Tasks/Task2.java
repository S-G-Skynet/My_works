package Tinkoff.Tasks;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double b = log2(a);
        System.out.println((int) Math.ceil(b));
    }
    public static double log2(int x) {
        return Math.log(x) / Math.log(2);
    }
}
