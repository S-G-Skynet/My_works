package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YandexTask1 {
    public static void main(String[] args) {
        try(BufferedReader read = new BufferedReader(new InputStreamReader(System.in))) {
            String s = read.readLine();
            char[] chars = s.toCharArray();
            boolean isUpperCase = false;
            boolean isLowerCase = false;
            boolean isDigit = false;
            for (int i = 0; i < chars.length; i++) {
                if(Character.isUpperCase(chars[i]))
                    isUpperCase = true;
                if(Character.isLowerCase(chars[i]))
                    isLowerCase = true;
                if(Character.isDigit(chars[i]))
                    isDigit = true;
            }

            if(isUpperCase && isLowerCase && isDigit && s.length() >= 8)
                System.out.println("YES");
            else System.out.println("NO");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
