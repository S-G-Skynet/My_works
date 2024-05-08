package Tinkoff.Tasks.Stajirovka;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Task3 {
    public static Dir root;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scan.next();
        }
        solve(strings);
        print(root, 0);
    }

    public static void solve(String[] strings) {
        for (String str : strings) {
            String[] result = str.split("/");
            String firstDirectory = result[0];
            if (root == null) {
                root = new Dir();
                root.setName(firstDirectory);
            }
            Dir prevDir = root;
            for (int i = 1; i < result.length; i++) {
                String name = result[i];

                Dir dir = prevDir.getMap().get(name);

                if (dir == null) {
                    dir = new Dir();
                    dir.setName(name);
                    prevDir.getMap().put(name, dir);
                }

                prevDir = dir;
            }
        }
    }

    public static void print(Dir dir, int count) {
        System.out.println(spaces(count) + dir.name);
        var dirs = dir.getMap().values().stream().sorted(Comparator.comparing(Dir::getName)).toList();
        dirs.forEach(d -> print(d, count + 2));
    }

    static class Dir {
        String name;

        HashMap<String, Dir> map = new HashMap<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HashMap<String, Dir> getMap() {
            return map;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dir dir = (Dir) o;
            return Objects.equals(name, dir.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static String spaces(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
