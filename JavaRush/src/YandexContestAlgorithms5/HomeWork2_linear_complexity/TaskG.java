package YandexContestAlgorithms5.HomeWork2_linear_complexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskG {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for(int i = 0; i < n; i++) {
            int k = scan.nextInt();
            int[] array = new int[k];
            for (int j = 0; j < k; j++) {
                array[j] = scan.nextInt();
            }
            solve(array);
        }
    }
    public static void solve(int[] array) {
        int min = array[0];
        int j = 0;
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int i = 0; i < array.length; i++) {
            if(array[i] < min)
                min = array[i];
            if(lists.get(j).size() < min) {
                lists.get(j).add(array[i]);
            }
            else {
                lists.add(new ArrayList<>());
                j++;
                lists.get(j).add(array[i]);
                min = array[i];
            }
        }
        System.out.println(lists.size());
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(lists.get(i).size() + " ");
        }

    }
}