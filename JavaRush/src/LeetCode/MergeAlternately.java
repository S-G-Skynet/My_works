package LeetCode;

public class MergeAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abasd","pqr"));
    }
    public static String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        int lengthAll = len1 + len2;
        char[] merged = new char[lengthAll];
        while(i < Math.max(len1,len2)) {
            if(i < len1) {
                merged[j] = word1.charAt(i);
                j++;
            }
            else {
                merged[j] = word2.charAt(i);
                i++;
                j++;
                continue;
            }
            if(i < len2) {
                merged[j] = word2.charAt(i);
                j++;
            }
            i++;
        }
        return new String(merged);
    }
}
