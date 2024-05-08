package Tinkoff.Tasks.Stipendiya;


import java.util.ArrayList;
import java.util.Scanner;

public class TaskG {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var orangeCount = scanner.nextInt();
        var guestCount = scanner.nextInt();
        var orangeMass = new ArrayList<Integer>();
        for (int i = 0; i < orangeCount; i++) {
            orangeMass.add(scanner.nextInt());
        }

        var orangeTotalMass = orangeMass.stream().mapToInt(x -> x).sum();

        var iter = orangeMass.listIterator();
        while (iter.hasNext()) {
            var mass = iter.next();
            iter.set(mass * guestCount);
        }        var avgMass = orangeTotalMass;

        var cutCount = 0;
        int massRemainder = 0;

        orangeMass.sort(Integer::compareTo);

        for (var mass : orangeMass) {
            if (massRemainder < avgMass) {
                massRemainder += mass;
            }
            while (massRemainder >= avgMass) {
                massRemainder -= avgMass;
                if (massRemainder != 0) {
                    cutCount++;
                }
            }
        }

        System.out.println(cutCount);
    }
}
