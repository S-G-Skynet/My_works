package YandexContestAlgorithms5.HomeWork3_Set_Map;

import java.util.HashMap;
import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        solve(array,k);
    }

    public static void solve(int[] array, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean ans = false;
        for(int i = 0; i < array.length; i++) {
            if(!map.containsKey(array[i])) {
                map.put(array[i],i);
            } else {
                if(k >= i - map.get(array[i])) {
                    ans = true;
                    break;
                } else {
                    map.put(array[i],i);
                }
            }
        }
        if(ans) {
            System.out.println("YES");
        }
        else System.out.println("NO");
    }
}
