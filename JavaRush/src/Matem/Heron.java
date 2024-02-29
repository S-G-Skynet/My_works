package Matem;

import java.util.Scanner;

public class Heron {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double s = scan.nextInt();
        int n = scan.nextInt();
        double x0 = s / 2;
        double Xn = x0;
        double x;

        for(int i = 0; i < n; i++) {
            x = Xn;
            Xn = 0.5 * (x + s / x);
            System.out.printf("%.7f \n", Xn);
        }
    }
}
