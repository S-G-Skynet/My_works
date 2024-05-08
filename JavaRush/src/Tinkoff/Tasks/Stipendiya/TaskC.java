package Tinkoff.Tasks.Stipendiya;


import java.util.*;

public class TaskC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();

        System.out.println(solve(a,b,c,d));
    }
    /*
    8 1 5 2
    * */
    public static int solve(int a,int b,int c,int d) {
        int sum = a + b + c + d;
        int[] array = {a,b,c,d};
        if(sum % 4 != 0) {
            return -1;
        }

        int avg = sum / 4;
        int count = 0;

        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if(array[right] > avg) {
                array[right] -= (avg - array[left]);
                array[left] = avg;
                left++;
                count++;
            }
            else right--;
        }

        return count;
    }
    public static int max(int[] array) {
        int max = array[0];

        for(int i = 0; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}



