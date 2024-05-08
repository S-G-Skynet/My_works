package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GCD {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String strA = scan.next();
        String strB = scan.next();
        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        gcd(a,b);
    }

    public static void gcd(int a, int b) {
        final int A = a;
        final int B = b;
        List<Integer> delA = new ArrayList<>();
        List<Integer> delB = new ArrayList<>();
        int lenA = a / 2 + 1;
        int lenB = b / 2 + 1;
        delA.add(1);
        delB.add(1);
        for (int i = 2; i <= lenA; i++) {
            while (a % i == 0) {
                a /= i;
                delA.add(i);
            }
            if (a == 1)
                break;
        }
        for (int j = 2; j <= lenB; j++) {
            while (b % j == 0) {
                b /= j;
                delB.add(j);
            }
            if (b == 1)
                break;
        }
        delA.add(A);
        delB.add(B);
        int ans = 1;
        System.out.print("Dividers of " + A + " = ");
        for (Integer integer : delA) {
            System.out.print(integer + " ");
            if (Collections.binarySearch(delB, integer) > 0) {
                ans *= integer;
            }
        }

        System.out.println();

        System.out.print("Dividers of " + B + " = ");
        for(Integer integer : delB) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println("GCD = " + ans);
    }

    public static int algorithmOfEuclid(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
