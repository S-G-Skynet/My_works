package Tinkoff.Tasks;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        System.out.println(new Task1().tariff(a,b,c,d));
    }

    public int tariff(int a, int b, int c, int d) {
        int sumTariff = a;
        if (d > b) {
            sumTariff += (d - b) * c;
        }
        return sumTariff;
    }
}
