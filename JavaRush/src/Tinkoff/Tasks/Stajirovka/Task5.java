package Tinkoff.Tasks.Stajirovka;

import java.util.Scanner;

import static java.lang.Math.max;

public class Task5 {
    public static final char
            TEETH = 'W',
            GRASS = '.',
            MUSHROOM = 'C';

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] wood = new int[n][3];
        for (int i = 0; i < n; i++) {
            String line = scan.next();
            wood[i][0] = line.charAt(0);
            wood[i][1] = line.charAt(1);
            wood[i][2] = line.charAt(2);
        }

        int[][] mushroomCount = new int[n][3];
        mushroomCount[n - 1][0] = wood[n - 1][0] == MUSHROOM ? 1 : 0;
        mushroomCount[n - 1][1] = wood[n - 1][1] == MUSHROOM ? 1 : 0;
        mushroomCount[n - 1][2] = wood[n - 1][2] == MUSHROOM ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            mushroomCount[i][0] = fillMushroomCount(i, 0, wood, mushroomCount);
            mushroomCount[i][1] = fillMushroomCount(i, 1, wood, mushroomCount);
            mushroomCount[i][2] = fillMushroomCount(i, 2, wood, mushroomCount);
        }

        System.out.println(max(max(mushroomCount[0][0], mushroomCount[0][1]), mushroomCount[0][2]));
    }

    private static int fillMushroomCount(int i, int row, int[][] wood, int[][] mushroomCount) {
        if (wood[i][row] == TEETH) {
            return 0;
        }

        int upperCount = row - 1 >= 0 ? mushroomCount[i + 1][row - 1] : 0;
        int middleCount = mushroomCount[i + 1][row];
        int lowerCount = row + 1 < 3 ? mushroomCount[i + 1][row + 1] : 0;

        int maxCount = max(max(upperCount, lowerCount), middleCount);
        return maxCount + (wood[i][row] == MUSHROOM ? 1 : 0);
    }
}
