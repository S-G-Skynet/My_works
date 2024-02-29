package Tinkoff.Tasks;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = scan.nextInt();
        int[] children = new int[N + 1];
        children[0] = 0;
        for (int i = 1; i < children.length; i++) {
            children[i] = scan.nextInt();
        }
        solve(children);
    }
    public static void solve(int[] children) {
        int n = children.length - 1;
        int ans1 = 0, ans2 = 0;

        int C = n / 2, N = (n + 1) / 2;

        int countC = 0;
        int countN = 0;

        int A = 0, B = 0;

        for (int i = 1; i <= n; i++) {
            countC += children[i] % 2 == 0 ? 1 : 0;
            countN += children[i] % 2 == 1 ? 1 : 0;
            if(i % 2 == 1 && children[i] % 2 == 0) {
                A++;
                ans1 = i;
            }
            if(i % 2 == 0 && children[i] % 2 == 1) {
                B++;
                ans2 = i;
            }
        }
        if(A == 0 && B == 0) {
            if (countC >= 2) {
                System.out.println("2 4");
            }
            else if(countN >= 2) {
                System.out.println("1 3");
            }
            else System.out.println("-1 -1");
            return;
        }
        if(C == countC && countN == N && A == 1 && B == 1) {
            System.out.printf("%d %d",Math.min(ans1,ans2), Math.max(ans1,ans2));
        }
        else
            System.out.println("-1 -1");
    }
}
