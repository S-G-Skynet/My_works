package LeetCode.Tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task5 {
    static Scanner scanner = new Scanner(System.in);
    static int N = scanner.nextInt();
    static int K = scanner.nextInt();
    static int P = scanner.nextInt();
    static int operations = 0;
    static HashMap<Integer, Integer> valueCount = new HashMap<>();
    static ArrayList<Integer> carsOnShelf = new ArrayList<>();
    static ArrayList<Integer> playOrder = new ArrayList<>();
    static ArrayList<Integer> carsOnFloor = new ArrayList<>();

    public static void main(String[] args) {
        fill();
        for (int i = K; i < P; i++) {
            if (carsOnFloor.contains(playOrder.get(i))) {
                continue;
            }
            int number1 = carsOnFloor.get(carsOnFloor.indexOf(findKeyWithMinValue(carsOnFloor, valueCount)));
            int number2 = carsOnShelf.get(carsOnShelf.indexOf(playOrder.get(i)));
            carsOnFloor.remove(carsOnFloor.indexOf(number1));
            carsOnShelf.add(number1);
            carsOnShelf.remove(carsOnShelf.indexOf(number2));
            carsOnFloor.add(number2);
            operations++;
        }
        System.out.println(operations);
    }

    public static void fill() {
        for (int i = 0; i < N; i++) {
            carsOnShelf.add(i + 1);
        }
        for (int i = 0; i < P; i++) {
            playOrder.add(scanner.nextInt());
        }
        for (int i = 0; i < K; i++) {
            if (carsOnFloor.contains(playOrder.get(i))) {
                continue;
            }
            int number = carsOnShelf.get(carsOnShelf.indexOf(playOrder.get(i)));
            carsOnFloor.add(number);
            carsOnShelf.remove(carsOnShelf.indexOf(number));
            operations++;
        }
        valueCount = playOrder.stream().collect(Collectors.toMap(
                key -> key,
                value -> 1,
                Integer::sum,
                HashMap::new
        ));
    }

    public static int findKeyWithMinValue(ArrayList<Integer> keysList, HashMap<Integer, Integer> hashMap) {
        Integer minKey = keysList.get(0); // Предполагаем, что первый ключ имеет минимальное значение
        Integer minValue = hashMap.get(minKey); // Минимальное значение

        // Итерируемся по остальным ключам и ищем ключ с наименьшим значением
        for (int key : keysList) {
            int value = hashMap.get(key);
            if (value < minValue) {
                minValue = value;
                minKey = key;
            }
        }

        return minKey;
    }

}

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        int p = scanner.nextInt();
//        int[] a = new int[p];
//        int[] cars = new int[n + 1];
//        cars[0] = 0;
//        int[] operations = new int[p];
//        operations[0] = 0;
//        for (int i = 0; i < p; i++) {
//            a[i] = scanner.nextInt();
//        }
//        for (int i = 1; i < k; i++) {
//            cars[i] = a[i-1];
//            operations[i] = a[i-1];
//        }
//
//    }
//    public static int operation() {
//
//    }

