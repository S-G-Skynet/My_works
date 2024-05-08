package YandexContestAlgorithms5.HomeWork1_Simple_Algorithms;

import java.util.Scanner;

public class TaskB {
    /*
      home
      hg1 = 0
      gg2 = 2
      gg1 = 5
      hg2 = 3
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        final int l = scan.nextInt();

        boolean home = l == 1;
        int ans = 0;
        int homeGoals1;
        int guestGoals2;
        int guestGoals1;
        int homeGoals2;
        if (home) {
            homeGoals1 = Integer.parseInt(String.valueOf(str1.charAt(0)));
            guestGoals2 = Integer.parseInt(String.valueOf(str1.charAt(2)));
            guestGoals1 = Integer.parseInt(String.valueOf(str2.charAt(0)));
            homeGoals2 = Integer.parseInt(String.valueOf(str2.charAt(2)));
        } else {
            guestGoals1 = Integer.parseInt(String.valueOf(str1.charAt(0)));
            homeGoals2 = Integer.parseInt(String.valueOf(str1.charAt(2)));
            homeGoals1 = Integer.parseInt(String.valueOf(str2.charAt(0)));
            guestGoals2 = Integer.parseInt(String.valueOf(str2.charAt(2)));
        }
        int currentGoals1 = guestGoals1 + homeGoals1;
        int currentGoals2 = guestGoals2 + homeGoals2;

        if (currentGoals1 < currentGoals2) {
            if (home) {
                ans = currentGoals2 - currentGoals1;
                if (ans + guestGoals1 <= guestGoals2)
                    ans++;
            } else {
                if (guestGoals1 <= guestGoals2) {
                    ans = currentGoals2 - currentGoals1 + 1;
                } else ans = currentGoals2 - currentGoals1;
            }
        } else if (currentGoals1 == currentGoals2) {
            if (guestGoals1 <= guestGoals2) {
                ans = 1;
            }
        }
        System.out.println(ans);
    }
}
