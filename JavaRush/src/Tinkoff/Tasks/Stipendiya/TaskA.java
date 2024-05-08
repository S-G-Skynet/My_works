package Tinkoff.Tasks.Stipendiya;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        long ans = n * m - 1;
        System.out.println(ans);
    }
}
