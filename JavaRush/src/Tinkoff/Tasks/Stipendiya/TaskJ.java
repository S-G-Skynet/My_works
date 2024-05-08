package Tinkoff.Tasks.Stipendiya;

import java.util.HashSet;
import java.util.Scanner;

public class TaskJ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int q = scan.nextInt();
        HashSet<Integer> set = new HashSet<>();
        int[] array = new int[n + 1];
        array[0] = 0;

        for (int i = 1; i < array.length; i++) {
            array[i] = scan.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            int count = 0;
            while (l <= r) {
                int right = l;
                set.add(array[right]);
                int cost = cost(set, l, right);
                while (cost <= k) {
                    right++;
                    if (right < array.length)
                        set.add(array[right]);
                    cost = cost(set, l, right);
                }
                count++;
                set.clear();
                l = right;
            }
            System.out.println(count);
        }
    }

    public static int cost(HashSet<Integer> set, int l, int r) {
        return set.size() * (r - l + 1);
    }
}
