package YandexContestAlgorithms5.HomeWork1_Simple_Algorithms;

import java.util.Scanner;

public class TaskG {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int y = scan.nextInt();
        int p = scan.nextInt();

        int solve1 = solve1(x, y, p);
        int solve2 = solve2(x, y, p);
        if (solve1 > 0 && solve2 > 0) {
            System.out.println(Math.min(solve1, solve2));
        } else if (solve1 < 0 && solve2 > 0) {
            System.out.println(solve2);
        } else if (solve1 > 0 && solve2 < 0) {
            System.out.println(solve1);
        } else
            System.out.println(-1);

    }

    public static int solve1(int x, int y, int p) {
        int count = 0;
        y -= x;
        count++;
        while (y > 0) {
            int a = x - p;
            if (a <= 0) {
                count = -1;
                break;
            }
            int b = x - y;
            if (y <= a) {
                count++;
                break;
            } else if (p - b <= x - (p - b)) {
                count += 2;
                break;
            } else {
                y -= a;
                count++;
            }
        }
        return count;
    }

    public static int solve2(int x, int y, int p) {
        int count = 0;
        int minCount = Integer.MAX_VALUE;
        int k = coefficient(x, p);
        y -= x;
        count++;
        while (y > 0) {
            int a = x - p;
            int b = x - y;
            if (y <= a) {
                count++;
                break;
            } else if (k <= 0 && y <= x) {
                while (y > 0) {
                    int otherCount = count;
                    int tempY = y;
                    int tempX = x;
                    int tempP = p;
                    do {
                        int temp = x - y;
                        y = 0;
                        p -= temp;
                        x -= p;
                        otherCount++;
                    } while (p > 0);
                    if (otherCount < minCount)
                        minCount = otherCount;
                    y = tempY;
                    y -= a;
                    x = tempX;
                    p = tempP;
                    count++;
                }
                return minCount;
            } else if ((y <= x - k) || p >= x) {
                while (y > 0) {
                    int otherCount = count;
                    int tempY = y;
                    int tempX = x;
                    int tempP = p;
                    do {
                        int temp = x - y;
                        p -= temp;
                        y = 0;
                        x -= p;
                        if (p > 0 && x <= 0) {
                            if(minCount == Integer.MAX_VALUE)
                                return -1;
                            else return minCount;
                        }
                        otherCount++;
                    } while (p > 0);
                    if (otherCount < minCount)
                        minCount = otherCount;
                    if(a > 0) {
                        y = tempY;
                        y -= a;
                        x = tempX;
                        p = tempP;
                        count++;
                    }
                    else break;
                }
                return minCount;
            } else {
                y -= a;
                count++;
            }
        }
        return count;
    }


    public static int coefficient(int x, int p) {
        int k1 = (int) (x / 1.618);
        return p - k1;
    }
}




