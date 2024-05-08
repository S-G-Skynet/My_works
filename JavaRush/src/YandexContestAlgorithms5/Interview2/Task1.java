package YandexContestAlgorithms5.Interview2;

import java.util.HashMap;

public class Task1 {
    public static void main(String[] args) {
        String s = "asddsassaddsfsadfg";
        String t = "ads";
        System.out.println(solve(s,t));
    }
    public static int solve(String s, String t) {
//        initialization
        HashMap<Character,Integer> mapSubstring = new HashMap<>();
        HashMap<Character,Integer> mapAnagram = stringToMap(t);

        char[] subChars = s.substring(0,t.length()).toCharArray();
        for (char symbol : subChars) {
            if (mapAnagram.containsKey(symbol)) {
                if(mapSubstring.containsKey(symbol)) {
                    mapSubstring.put(symbol, mapSubstring.get(symbol) + 1);
                }
                else mapSubstring.put(symbol,1);
            }
        }

//        solve
        int answer = 0;
        int count = 0;

        for(var key : mapSubstring.keySet()) {
            if(mapAnagram.containsKey(key) && !mapAnagram.get(key).equals(mapSubstring.get(key))) {
                count++;
            }
        }

        if(count == 0)
            answer++;

        char[] chars = s.toCharArray();
        for(int i = t.length(); i < chars.length; i++) {
            char charOut = chars[i - t.length()];
            if(mapAnagram.containsKey(charOut)) {
                int getSub = mapSubstring.get(charOut);
                int getAna = mapAnagram.get(charOut);
                mapSubstring.put(charOut, getSub - 1);
                getSub--;
                if(getSub + 1 == getAna) {
                    count++;
                }
                else if(getSub == getAna) {
                    count--;
                }
            }

            char charIn = chars[i];
            if(mapAnagram.containsKey(charIn)) {
                int getSub = mapSubstring.get(charIn);
                int getAna = mapAnagram.get(charIn);
                if(mapSubstring.get(charIn) == null) {
                    mapSubstring.put(charIn, 1);
                }
                else mapSubstring.put(charIn, getSub + 1);
                getSub++;
                if(getSub == getAna) {
                    count--;
                }
                else if(getSub - 1 == getAna) {
                    count++;
                }
            }
            if(count == 0)
                answer++;
        }
        return answer;
    }

    public static HashMap<Character,Integer> stringToMap(String t) {
        char[] chars = t.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
            else map.put(chars[i],1);
        }
        return map;
    }
}




