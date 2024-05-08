package YandexContestAlgorithms5.HomeWork3_Set_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(solve(array));
    }

    public static int solve(int[] array) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int maxCouples = 1;
        for (int a : array) {
            map1.put(a, a + 1);
            if (map2.containsKey(a)) {
                int value = map2.get(a);
                map2.put(a, value + 1);
                if ((value + 1) > maxCouples) {
                    maxCouples = value + 1;
                }
            } else map2.put(a, 1);
        }

        int sum = 0;
        int maxSum = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey()) && map2.containsKey(entry.getValue())) {
                sum = map2.get(entry.getKey()) + map2.get(entry.getValue());
                if (sum > maxSum)
                    maxSum = sum;
            }
        }
        if(maxCouples > maxSum) {
            maxSum = maxCouples;
        }
        return array.length - maxSum;
    }
}
