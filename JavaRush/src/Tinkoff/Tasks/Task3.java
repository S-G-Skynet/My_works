package Tinkoff.Tasks;

import java.util.Scanner;

public class Task3 {
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
}
