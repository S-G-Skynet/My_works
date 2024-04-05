package Algorithms;

public class TernarySearch {
    public static void main(String[] args) {
        int[] array = {-2, 0, 1, 1, 4, 5, 7};
        System.out.println(ternarySearch(array, 1));
    }
    public static int ternarySearch(int[] array, int element) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int h = (r - l)/3;
            int m1 = l + h;
            int m2 = r - h;
            if(array[m1] == element)
                return m1;
            if(array[m2] == element)
                return m2;
            if(array[m1] < element && element < array[m2]) {
                l = m1 + 1;
                r = m2 - 1;
            }
            else if(element < array[m1]) {
                r = m1 - 1;
            }
            else {
                l = m2 + 1;
            }
        }
        return -1;
    }

}
