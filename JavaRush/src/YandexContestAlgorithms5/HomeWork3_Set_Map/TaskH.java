package YandexContestAlgorithms5.HomeWork3_Set_Map;

import java.util.*;

public class TaskH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<Point, List<Point>> bytype = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            if (x1 > x2 || (x1 == x2 && y1 > y2)) {
                int temp = x1; x1 = x2; x2 = temp;
                temp = y1; y1 = y2; y2 = temp;
            }
            int dx = x2 - x1;
            int dy = y2 - y1;
            Point key = new Point(dx, dy);
            bytype.putIfAbsent(key, new ArrayList<>());
            bytype.get(key).add(new Point(x1, y1));
        }

        Map<Point, Integer> mxmy = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            if (x1 > x2 || (x1 == x2 && y1 > y2)) {
                int temp = x1; x1 = x2; x2 = temp;
                temp = y1; y1 = y2; y2 = temp;
            }
            int dx = x2 - x1;
            int dy = y2 - y1;
            for (Point point : bytype.getOrDefault(new Point(dx, dy), new ArrayList<>())) {
                int mx = x1 - point.x;
                int my = y1 - point.y;
                Point mxmyKey = new Point(mx, my);
                mxmy.put(mxmyKey, mxmy.getOrDefault(mxmyKey, 0) + 1);
            }
        }

        int maxinplace = 0;
        for (int val : mxmy.values()) {
            maxinplace = Math.max(maxinplace, val);
        }

        System.out.println(n - maxinplace);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
