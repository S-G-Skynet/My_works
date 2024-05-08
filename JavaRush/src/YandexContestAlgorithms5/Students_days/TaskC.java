package YandexContestAlgorithms5.Students_days;

import java.util.HashMap;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        String s = scan.next();
        String t = scan.next();

        System.out.println(solve(s, t, k));
        scan.close();
    }

    public static String solve(String s, String t, int k) {
        String subString = s.substring(0, k);
        int countIncorrect = 0;

        HashMap<Character, Integer> mapOfS = new HashMap<>();
        HashMap<Character, Integer> mapOfT = mapOfSymbols(t);

        for (char ch : subString.toCharArray()) {
            if (mapOfT.containsKey(ch)) {
                if (!mapOfS.containsKey(ch)) {
                    mapOfS.put(ch, 1);
                } else {
                    mapOfS.put(ch, mapOfS.get(ch) + 1);
                    if (mapOfS.get(ch) > mapOfT.get(ch)) {
                        countIncorrect++;
                    }
                }
            } else {
                countIncorrect++;
            }
        }
        String ans = countIncorrect == 0 ? "YES" : "NO";
        if (ans.equals("YES")) {
            return ans;
        }
        for (int i = 1; i <= s.length() - k; i++) {
            int left = i - 1;
            int right = i + k - 1;
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);
            if (mapOfS.containsKey(charLeft)) {
                int number = mapOfS.get(charLeft);
                if (number - 1 <= 0) {
                    mapOfS.remove(charLeft);
                } else {
                    mapOfS.put(charLeft, number - 1);
                    if ((number - 1) <= mapOfT.get(charLeft) && number > mapOfT.get(charLeft)) {
                        countIncorrect--;
                    }
                }
            } else {
                countIncorrect--;
            }

            if (mapOfS.containsKey(charRight)) {
                int number = mapOfS.get(charRight);
                mapOfS.put(charRight, number + 1);
                if (number + 1 > mapOfT.get(charRight)) {
                    countIncorrect++;
                }
            } else {
                if (mapOfT.containsKey(charRight)) {
                    mapOfS.put(charRight, 1);
                } else {
                    countIncorrect++;
                }
            }
            if (countIncorrect == 0) {
                ans = "YES";
                break;
            }
        }
        return ans;
    }


    public static HashMap<Character, Integer> mapOfSymbols(String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.merge(ch,1,Integer::sum);
        }
        return map;
    }
}
