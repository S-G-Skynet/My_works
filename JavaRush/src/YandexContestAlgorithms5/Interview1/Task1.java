package YandexContestAlgorithms5.Interview1;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {7, 20, 28, 29,36};
        int target = 50;
        System.out.println(Arrays.toString(solve(array, target)));
    }

    public static int[] solve(int[] array, int target) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        int[] prevSolveR = {array[left] + array[right],0,0};
        int[] prevSolveL = {array[left] + array[right],0,0};
        while (left < right) {
            int solve = array[left] + array[right];
            if (solve < target) {
                prevSolveL[0] = solve;
                prevSolveL[1] = left;
                prevSolveL[2] = right;
                left++;
            } else if (solve > target) {
                prevSolveR[0] = solve;
                prevSolveR[1] = left;
                prevSolveR[2] = right;
                right--;
            } else {
                return new int[]{left, right};
            }
        }
        if (Math.abs(target - prevSolveL[0]) < Math.abs(target - prevSolveR[0])) {
            return new int[]{prevSolveL[1]+1, prevSolveL[2]+1};
        } else return new int[]{prevSolveR[1]+1, prevSolveR[2]+1};
    }
}