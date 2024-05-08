package YandexContestAlgorithms5.Students_days;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(solve(s));
    }

    public static char solve(String s) {
        char[] chars = s.toCharArray();
        char maxChar = chars[0];
        int sum = 0;

        for (int i = 0; i < chars.length; i++) {
            int a = 91 - chars[i];
            sum += a;
            if (chars[i] > maxChar) {
                maxChar = chars[i];
            }
        }
        double d = ((double) sum / s.length()) + 0.1;
        int average = 91 - (int) Math.round(d);
        char ans = (char) average;
        if (ans < maxChar) {
            ans = (char) (maxChar - 1);
        }
        return ans;
    }
}
