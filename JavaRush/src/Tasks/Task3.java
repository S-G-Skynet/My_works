package Tasks;

import java.util.Scanner;

public class Task3 {
    static Scanner scanner = new Scanner(System.in);
    static int n = scanner.nextInt();
    static int m = scanner.nextInt();
    static int[][] dp = new int[n][m];

    public static void main(String[] args) {
        if (n > 50 || n < 1 || m > 50 || m < 1) {
            throw new IllegalArgumentException();
        }
        initial();
        System.out.printf("%d", solve(n - 1, m - 1));
    }

    static void initial() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 1;
    }

    static boolean good(int i, int j) {
        return (i >= 0) && (j >= 0) && (i < n) && (j < m);
    }

    static int solve(int i, int j) {
        if (good(i, j)) {
            if (dp[i][j] == -1)
                dp[i][j] = solve(i - 2, j - 1) + solve(i - 1, j - 2);
        } else
            return 0;
        return dp[i][j];
    }
}
