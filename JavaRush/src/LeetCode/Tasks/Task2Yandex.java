package LeetCode.Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task2Yandex {
    public static void main(String[] args) {
        new Task2Yandex().task2();
    }

    private void task2() {
        var scan = new Scanner(System.in);
        int dictionaryCount = scan.nextInt();
        int queryCount = scan.nextInt();
        var dictionary = new String[dictionaryCount];
        for (int i = 0; i < dictionaryCount; i++) {
            dictionary[i] = scan.next();
        }
        for (int i = 0; i < queryCount; i++) {
            int k = scan.nextInt();
            String prefix = scan.next();

            var startIndex = Arrays.binarySearch(dictionary, prefix);
            startIndex = startIndex >= 0 ? startIndex : Math.abs(startIndex) - 1;
            var resultIndex = startIndex + k - 1;
            System.out.println(
                    resultIndex < dictionaryCount && dictionary[resultIndex].startsWith(prefix)
                            ? resultIndex + 1 : -1);
        }
    }
}
