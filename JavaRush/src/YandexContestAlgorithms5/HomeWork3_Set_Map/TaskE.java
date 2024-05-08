package YandexContestAlgorithms5.HomeWork3_Set_Map;

import java.util.*;

public class TaskE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();

        int n1 = scan.nextInt();
        for (int i = 0; i < n1; i++) {
            int key = scan.nextInt();
            set1.add(key);
        }

        int n2 = scan.nextInt();
        for (int i = 0; i < n2; i++) {
            int key = scan.nextInt();
            set2.add(key);
        }

        int n3 = scan.nextInt();
        for (int i = 0; i < n3; i++) {
            int key = scan.nextInt();
            set3.add(key);
        }

        List<Integer> ans = new ArrayList<>();

        for (int s : set1) {
            if(set2.contains(s) || set3.contains(s)) {
                ans.add(s);
            }
        }
        for (int s : set2) {
            if(set1.contains(s) || set3.contains(s)) {
                ans.add(s);
            }
        }
        for (int s : set3) {
            if(set2.contains(s) || set1.contains(s)) {
                ans.add(s);
            }
        }

        ans.stream().distinct().sorted().forEach(x -> System.out.print(x + " "));
    }
}
