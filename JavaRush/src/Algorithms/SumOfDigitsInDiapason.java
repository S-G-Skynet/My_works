package Algorithms;

import java.util.Scanner;

public class SumOfDigitsInDiapason {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();

        int sum = 0;
        int ans = 0;
        for (int i = n; i <= m; i++) {
            int x = i;
            while(x != 0) {
                int b = x % 10;
                sum += b;
                x /= 10;
            }
            if(sum >= k) {
                ans = i;
                break;
            }
        }
        System.out.println(sum);
        System.out.println(ans);
    }
}
