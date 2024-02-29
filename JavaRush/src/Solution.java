import com.sun.tools.javac.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

}
//task6
/*
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
* */

//task5
/*
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    long l = scan.nextLong(), r = scan.nextLong();
    final long MAX = Long.MAX_VALUE;
    long ans = 0;
    for (int i = 1; i <= 9 ; i++) {
        long ch = i;
        while (true) {
            if(ch > r) {
                break;
            }
            if(ch >= l && ch <= r) {
                ans++;
            }
            if(ch * 2 > MAX) {
                break;
            }
            ch = ch * 10 + i;
        }
    }
    System.out.println(ans);
}
*/

//taks4
/*
* public static void main(String[] args) {
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
    * */
//task3
/*
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int a = scanner.nextInt();
        int t = scanner.nextInt();
        int[] floors = new int[a];
        for (int i = 0; i < floors.length ; i++) {
            floors[i] = scanner.nextInt();
        }
        sum = floors[floors.length - 1] - floors[0];
        int leave = scanner.nextInt();
        if(t < floors[leave - 1] - floors[0] && floors[floors.length - 1] - floors[leave - 1] > t) {
            if(floors[leave-1] - floors[0] < floors[floors.length-1] - floors[leave-1]) {
                sum = floors[leave - 1] - floors[0] + floors[floors.length - 1] - floors[0];
            }
            else sum = floors[floors.length - 1] - floors[leave - 1] + floors[floors.length - 1] - floors[0];
        }
        System.out.println(sum);
    }
    */
//task2
/*
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double b = log2(a);
        System.out.println((int) Math.ceil(b));
    }
    public static double log2(int x) {
        return Math.log(x) / Math.log(2);
    }
 */

//task1
/*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        System.out.println(new Solution().tariff(a,b,c,d));
    }

    public int tariff(int a, int b, int c, int d) {
        int sumTariff = a;
        if (d > b) {
            sumTariff += (d - b) * c;
        }
        return sumTariff;
    }
    }*/
