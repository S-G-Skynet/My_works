package Contests;

import java.util.Scanner;

public class YandexTask2 {
    public static final String
            LEFT = "<left>",
            RIGHT = "<right>",
            BSPACE = "<bspace>",
            DELETE = "<delete>";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rightInput = scan.nextLine();
        String inputSequence = scan.nextLine();

        System.out.println(check(rightInput, inputSequence) ? "Yes" : "No");

        var sb = new StringBuilder();

    }

    private static boolean check(String rightIn, String seqIn) {
        var prompt = new StringBuilder();
        int currentIndex = 0;
        for (int i = 0; i < seqIn.length(); i++) {
            if (seqIn.startsWith(LEFT, i)) {
                currentIndex--;
                currentIndex = Math.max(currentIndex, 0);
                i += LEFT.length() - 1;
            } else if (seqIn.startsWith(RIGHT, i)) {
                currentIndex++;
                currentIndex = Math.min(currentIndex, prompt.length());
                i += RIGHT.length() - 1;
            } else if (seqIn.startsWith(DELETE, i)) {
                if (currentIndex < prompt.length()) {
                    prompt.deleteCharAt(currentIndex);
                }
                i += DELETE.length() - 1;
            } else if (seqIn.startsWith(BSPACE, i)) {
                if (currentIndex > 0) {
                    prompt.deleteCharAt(currentIndex - 1);
                    currentIndex--;
                }
                i += BSPACE.length() - 1;
            } else {
                if (currentIndex < prompt.length()) {
                    prompt.insert(currentIndex, seqIn.charAt(i));
                } else {
                    prompt.append(seqIn.charAt(i));
                }
                currentIndex++;
            }
        }
        return prompt.toString().equals(rightIn);
    }
}