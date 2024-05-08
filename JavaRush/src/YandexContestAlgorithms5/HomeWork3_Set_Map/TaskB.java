package YandexContestAlgorithms5.HomeWork3_Set_Map;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        HashMap<Character,Integer> map1 = new HashMap<>();
        for(char chars : str1.toCharArray()) {
            if(map1.containsKey(chars)) {
                map1.put(chars, map1.get(chars) + 1);
            }
            else {
                map1.put(chars,1);
            }
        }
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(char chars : str2.toCharArray()) {
            if(map2.containsKey(chars)) {
                map2.put(chars, map2.get(chars) + 1);
            }
            else {
                map2.put(chars,1);
            }
        }

        if(map1.equals(map2)) {
            System.out.println("YES");
        }
        else System.out.println("NO");
    }
}
