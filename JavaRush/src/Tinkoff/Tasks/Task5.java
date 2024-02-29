package Tinkoff.Tasks;

import java.util.Scanner;

public class Task5 {
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
}
