package Tinkoff.Tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        List<Long> b = new ArrayList<>();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            long x = 1;
            while (a[i] > 0) {
                long ch = a[i] % 10;
                a[i] /= 10;

                b.add((long) ((9-ch) * x));
                x *= 10;
            }
        }
        b.sort(Collections.reverseOrder());
        long ans = 0;

        for (int i = 0; i < Math.min(k, b.size()); i++) {
            ans += b.get(i);
        }
        System.out.println(ans);
    }
}
