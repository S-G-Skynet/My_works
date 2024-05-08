package YandexContestAlgorithms5.HomeWork3_Set_Map;

import java.util.*;

public class TaskG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Set<Point> points = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            points.add(new Point(x, y));
        }
        ArrayList<Point> ans = solve(points);

        System.out.println(ans.size());
        ans.forEach(x -> System.out.println(x.toString()));
    }

    public static ArrayList<Point> solve(Set<Point> points) {
        ArrayList<Point> listPoints = new ArrayList<>();
        listPoints.add(new Point(1, 1));
        listPoints.add(new Point(1, 1));
        listPoints.add(new Point(1, 1));
        listPoints.add(new Point(1, 1));
        for (Point a : points) {
            if (points.size() == 1) {
                listPoints.add(new Point(a.getX(), a.getY() + 1));
                listPoints.add(new Point(a.getX() + 1, a.getY() + 1));
                listPoints.add(new Point(a.getX() + 1, a.getY()));
                break;
            }
            for (Point b : points) {
                if (a != b) {
                    int delX = b.getX() - a.getX();
                    int delY = b.getY() - a.getY();
                    Point c = new Point(a.getX() + delY, a.getY() - delX);
                    Point d = new Point(b.getX() + delY, b.getY() - delX);
                    Point e = new Point(a.getX() - delY, a.getY() + delX);
                    Point f = new Point(b.getX() - delY, b.getY() + delX);
                    if (Math.abs(delX) == Math.abs(delY)) {
                        Point g = new Point(b.getX(), a.getY());
                        Point h = new Point(a.getX(), b.getY());
                        if (points.contains(g) && listPoints.size() > 1) {
                            listPoints.clear();
                            listPoints.add(h);
                        } else if (points.contains(h) && listPoints.size() > 1) {
                            listPoints.clear();
                            listPoints.add(g);
                        } else if (points.contains(g) && points.contains(h)) {
                            listPoints.clear();
                            return listPoints;
                        } else if (!points.contains(g) && !points.contains(h) && listPoints.size() > 2) {
                            listPoints.clear();
                            listPoints.add(g);
                            listPoints.add(h);
                        }
                    }
                    if (points.contains(c) && listPoints.size() > 1) {
                        listPoints.clear();
                        listPoints.add(d);
                    } else if (points.contains(d) && listPoints.size() > 1) {
                        listPoints.clear();
                        listPoints.add(c);
                    } else if (points.contains(c) && points.contains(d)) {
                        listPoints.clear();
                        return listPoints;
                    } else if (!points.contains(c) && !points.contains(d) && listPoints.size() > 2) {
                        listPoints.clear();
                        listPoints.add(c);
                        listPoints.add(d);
                    }

                    if (points.contains(e) && listPoints.size() > 1) {
                        listPoints.clear();
                        listPoints.add(f);
                    } else if (points.contains(f) && listPoints.size() > 1) {
                        listPoints.clear();
                        listPoints.add(e);
                    } else if (points.contains(e) && points.contains(f)) {
                        listPoints.clear();
                        return listPoints;
                    } else if (!points.contains(e) && !points.contains(f) && listPoints.size() > 2) {
                        listPoints.clear();
                        listPoints.add(e);
                        listPoints.add(f);
                    }
                }
            }
        }
        return listPoints;
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
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
            return 31 * x + y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}