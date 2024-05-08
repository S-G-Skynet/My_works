package Tinkoff.Tasks.Stipendiya;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class TaskE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        LinkedHashSet<String> ansSet = new LinkedHashSet<>();
        String firsWord = scan.next();
        ansSet.add(firsWord);
        set.add(firsWord);
        for (int i = 2; i <= 2*n; i++) {
            set.add(scan.next());
        }

        char lastChar = firsWord.charAt(firsWord.length() - 1);
        for (int i = 2; i < 2*n; i++) {
            for(String s : set) {
                if(s.startsWith(Character.toString(lastChar))) {
                    ansSet.add(s);
                    lastChar = s.charAt(s.length() - 1);
                }
            }
        }
        for(String s : ansSet) {
            System.out.println(s);
        }
    }

}
