package YandexContestAlgorithms5.HomeWork3_Set_Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskF {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>(List.of(reader.readLine().split(" ")));
        Set<String> finalset = new HashSet<>(set);
        for (String s : set) {
            finalset.removeIf(x -> x.startsWith(s) && !(x.equals(s)));
        }

        String[] words = reader.readLine().split(" ");

        String[] ansWords = new String[words.length];
        int i = 0;
        for (String word : words) {
            for (String s : finalset) {
                if (word.startsWith(s)) {
                    ansWords[i] = s;
                    break;
                }
            }
            if (ansWords[i] == null)
                ansWords[i] = word;
            i++;
        }

        for (String word : ansWords) {
            System.out.print(word + " ");
        }

        reader.close();
    }
}
