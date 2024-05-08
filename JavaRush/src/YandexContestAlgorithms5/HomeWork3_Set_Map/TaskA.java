package YandexContestAlgorithms5.HomeWork3_Set_Map;

import java.util.Scanner;
import java.util.TreeMap;

public class TaskA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            int k = scan.nextInt();
            for (int j = 1; j <= k; j++) {
                String key = scan.next();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }
        map.entrySet().removeIf(x -> x.getValue() != n);

        System.out.println(map.size());
        for (String str : map.keySet()) {
            System.out.print(str + " ");
        }
    }
}
