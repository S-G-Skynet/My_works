package YandexContestAlgorithms5.HomeWork2_linear_complexity;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskE {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        ArrayList<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            coordinates.add(new int[]{x, y, (i + 1), (x - y)});
        }
        ArrayList<int[]> sortList = mergeSort(coordinates);
        long sum = 0;
        int index = 0;
        long solve = Long.MIN_VALUE;
        for (int i = sortList.size() - 1; i >= 0; i--) {
            if (sortList.get(i)[3] >= 0) {
                count++;
                sum += sortList.get(i)[0];
                if (sum > solve)
                    solve = sum;
                sum -= sortList.get(i)[1];
            } else {
                index = i;
                break;
            }
        }
        int maxFromNegative = Integer.MIN_VALUE;
        int maxFromPositive = Integer.MIN_VALUE;
        int ansIndex = 0;
        int secondAnsIndex = 0;
        if (sortList.get(index)[3] < 0) {
            for (int i = index; i >= 0; i--) {
                if (sortList.get(i)[0] > maxFromNegative) {
                    maxFromNegative = sortList.get(i)[0];
                    ansIndex = i;
                }
            }

            for (int i = index + 1; i < sortList.size(); i++) {
                if (sortList.get(i)[1] > maxFromPositive) {
                    maxFromPositive = sortList.get(i)[1];
                    secondAnsIndex = i;
                }
            }

        }
        else {
            for (int i = 0; i < sortList.size(); i++) {
                if (sortList.get(i)[1] > maxFromPositive) {
                    maxFromPositive = sortList.get(i)[1];
                    secondAnsIndex = i;
                }
            }
        }

        long newSolve = sum + maxFromNegative;
        long secondSolve = sum + sortList.get(secondAnsIndex)[1];
        if (newSolve > solve) {
            solve = newSolve;
            int[] temp1 = sortList.get(ansIndex);
            sortList.set(ansIndex, sortList.get(index));
            sortList.set(index, temp1);
        }
        if((secondSolve > solve) && count > 0) {
            solve = secondSolve;
            if(index > 0 || sortList.get(index)[3] < 0) {
                int[] temp = sortList.get(secondAnsIndex);
                sortList.set(secondAnsIndex, sortList.get(index + 1));
                sortList.set(index + 1, temp);
            }
            else {
                int[] temp = sortList.get(secondAnsIndex);
                sortList.set(secondAnsIndex, sortList.get(0));
                sortList.set(0, temp);
            }
        }
        System.out.println(solve);
        for (int i = sortList.size() - 1; i >= 0; i--) {
            System.out.print(sortList.get(i)[2] + " ");
        }
        scan.close();
    }

    public static ArrayList<int[]> mergeSort(ArrayList<int[]> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        ArrayList<int[]> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<int[]> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static ArrayList<int[]> merge(ArrayList<int[]> left, ArrayList<int[]> right) {
        ArrayList<int[]> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            // Compare last elements first
            int leftLast = left.get(leftIndex)[3];
            int rightLast = right.get(rightIndex)[3];

            if (leftLast <= rightLast) {
                merged.add(left.get(leftIndex));
                leftIndex++;
            } else {
                merged.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex));
            rightIndex++;
        }

        return merged;
    }
}