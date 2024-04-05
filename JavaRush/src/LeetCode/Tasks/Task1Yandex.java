package LeetCode.Tasks;

import java.util.Scanner;

public class Task1Yandex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] words = getWords(str);
        int maxLen = getLen(words);
        printParagraph(words,maxLen);
        scanner.close();
    }
    private static String[] getWords(String string) {
        string = string.replaceAll("\\s+,", ",");
        string = string.replaceAll(",{2,}", ",");
        string = string.replaceAll(",", ", ");
        string = string.strip();
        String[] words = string.split("\\s+");
        return words;
    }
    private static int getLen(String[] words) {
        int maxLen = -1;
        for (var word : words) {
            var len = word.length();
            if (word.charAt(len - 1) == ',') {
                len--;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen * 3;
    }
    private static void printParagraph(String[] words, int lineLen) {
        System.out.print(words[0]);
        var currentLineLenRemainder = lineLen - words[0].length();
        for (int i = 1; i < words.length; i++) {
            var word = words[i];
            if (word.length() + 1 <= currentLineLenRemainder) {
                System.out.print(" " + word);
                currentLineLenRemainder -= word.length() + 1;
            } else {
                System.out.print("\n" + word);
                currentLineLenRemainder = lineLen - word.length();
            }
        }
    }
}
