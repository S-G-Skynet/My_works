//package test;
//
//import java.io.Reader;
//import java.io.StringReader;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Scanner;
//
//public class TaskDYandex {
//    public static void main(String[] args) {
//        new TaskDYandex.task4Starter();
//    }
//
//    public static char LEFT = 'L', RIGHT = 'R', FORWARD = 'F';
//
//    private void task4Starter() {
//        System.out.println("=============================");
//        task4Opt("RLF");
//        task4("RLF");
//        System.out.println("=============================");
//        task4Opt("LRFFLR");
//        task4("LRFFLR");
//        System.out.println("=============================");
//        task4Opt("FFF");
//        task4("FFF");
//        System.out.println("=============================");
//        task4Opt("F");
//        task4("F");
//    }
//
//    record FCountAndNextStableSubsequenceCost(int fCount, int nextStableSubsequenceCost) {
//    }
//
//    private void task4Opt(String input) {
//        System.out.printf("input = '%s'\n", input);
//
//        var commands = input.toCharArray();
//        var direction = RIGHT;
//        var position = 0;
//
//        for (char command : commands) {
//            if (command == FORWARD) {
//                position += direction == LEFT ? -1 : 1;
//            } else {
//                direction = command;
//            }
//        }
//
//        var res = getFCountAndNextStableSubsequenceCost(commands,
//                -1, position);
//        System.out.println("init cost = " + position);
//        System.out.println("init res = " + res);
//
//        position = 0;
//        direction = RIGHT;
//        var fCount = res.fCount;
//        var nextStableSubsequenceCost = res.nextStableSubsequenceCost;
//        var positions = new HashSet<Integer>();
//
//        for (int i = 0; i < commands.length; i++) {
//            if (commands[i] == FORWARD) {
//                fCount--;
//            } else {
//                assert fCount == 0;
//                res = getFCountAndNextStableSubsequenceCost(commands,
//                        i, position);
//                fCount = res.fCount;
//                nextStableSubsequenceCost = res.nextStableSubsequenceCost;
//            }
//
//            if (commands[i] != LEFT) {
//                positions.add(position - fCount + nextStableSubsequenceCost);
//            }
//            if (commands[i] != RIGHT) {
//                positions.add(position + fCount + nextStableSubsequenceCost);
//            }
//            if (commands[i] != FORWARD) {
//                positions.add(position + (direction == LEFT ? -(fCount + 1) : (fCount + 1))
//                        + nextStableSubsequenceCost);
//            }
//
//            if (commands[i] == FORWARD) {
//                position += direction == LEFT ? -1 : 1;
//            } else {
//                direction = commands[i];
//            }
//        }
//
//        System.out.println(positions);
//        System.out.println(positions.size());
//    }
//
//    private FCountAndNextStableSubsequenceCost getFCountAndNextStableSubsequenceCost(char[] commands,
//                                                                                     int index,
//                                                                                     int currentCost) {
//        assert index == -1 || commands[index] != FORWARD;
//        var direction = index == -1 ? RIGHT : commands[index];
//        var fCount = 0;
//        var cost = currentCost;
//        index++;
//        while (index < commands.length && commands[index] == FORWARD) {
//            fCount++;
//            index++;
//        }
//        cost += direction == LEFT ? fCount : -fCount;
//        return new FCountAndNextStableSubsequenceCost(fCount, cost);
//    }
//
//    private void task4(String input) {
//        var commands = input.toCharArray();
//        var direction = RIGHT;
//        var position = 0;
//
//        var positions = new HashSet<Integer>();
//        System.out.printf("input = '%s'\n", input);
//        for (int i = 0; i < commands.length; i++) {
//            if (commands[i] != LEFT) {
//                positions.add(position + getOffset(LEFT, commands, i));
//            }
//            if (commands[i] != RIGHT) {
//                positions.add(position + getOffset(RIGHT, commands, i));
//            }
//            if (commands[i] != FORWARD) {
//                positions.add(position + getOffset(direction, commands, i) + (direction == LEFT ? -1 : 1));
//            }
//
//            if (commands[i] == FORWARD) {
//                position += direction == LEFT ? -1 : 1;
//            } else {
//                direction = commands[i];
//            }
//        }
//        System.out.println(positions);
//        System.out.println(positions.size());
//    }
//
//    private int getOffset(char direction, char[] commands, int index) {
//        var offset = 0;
//        for (int i = index + 1; i < commands.length; i++) {
//            if (commands[i] == LEFT) {
//                direction = LEFT;
//            } else if (commands[i] == RIGHT) {
//                direction = RIGHT;
//            } else {
//                offset += direction == LEFT ? -1 : 1;
//            }
//        }
//        return offset;
//    }
//
//    private void task2() {
//        var scan = new Scanner(getReader());
//        int dictionaryCount = scan.nextInt();
//        int queryCount = scan.nextInt();
//        var dictionary = new String[dictionaryCount];
//        for (int i = 0; i < dictionaryCount; i++) {
//            dictionary[i] = scan.next();
//        }
//        for (int i = 0; i < queryCount; i++) {
//            int k = scan.nextInt();
//            String prefix = scan.next();
//
//            var startIndex = Arrays.binarySearch(dictionary, prefix);
////            var startIndex = Arrays.binarySearch(dictionary, prefix,
////                    (o1, o2) -> o1.substring(0, Math.min(o1.length(), o2.length())).compareTo(o2));
//            startIndex = startIndex >= 0 ? startIndex : Math.abs(startIndex) - 1;
////            while (startIndex >= 1 && dictionary[startIndex - 1].startsWith(prefix)) {
////                startIndex--;
////            }
//
//            System.out.println("prefix = " + prefix + ", k = " + k + ", startIndex = " + startIndex);
//
//            var resultIndex = startIndex + k - 1;
//            System.out.println(
//                    resultIndex < dictionaryCount && dictionary[resultIndex].startsWith(prefix)
//                            ? resultIndex + 1 : -1);
//        }
//    }
//
//    private Reader getReader() {
//        /*
//         * 4 9 -1
//         *
//         * */
//        var inputs = Map.of(
//                1, """
//                        11 11
//                        2
//                        aa
//                        aaa
//                        aab
//                        ab
//                        abc
//                        ac
//                        ba
//                        daa
//                        dab
//                        dadba
//                        4 a
//                        2 da
//                        4 da
//                        3 er
//                        1 dadba
//                        1 dadb
//                        2 dadb
//                        1 1
//                        1 2
//                        1 b
//                        2 b
//                        """,
//                2, """
//                        1 3
//                        a
//                        1 a
//                        2 a
//                        1 b
//                        """
//        );
//
//        return new StringReader(inputs.get(1));
//    }
//
//
//    private void task1() {
//        var string = "  as sd s, asd ,  , sad, , , asd     , s";
//        var words = getWords(string);
//        System.out.println(Arrays.toString(words));
//        var lineLen = getLineLen(words);
//        System.out.println(lineLen);
//        printParagraph(words, lineLen);
//    }
//
//    private String[] getWords(String input) {
//        return input.replaceAll("\\s+,", ",")
//                .replaceAll(",{2,}", ",")
//                .replaceAll(",", ", ")
//                .strip()
//                .split("\\s+");
//    }
//
//    private int getLineLen(String[] words) {
//        int maxLen = -1;
//        for (var word : words) {
//            var len = word.length();
//            if (word.charAt(len - 1) == ',') {
//                len--;
//            }
//            maxLen = Math.max(maxLen, len);
//        }
//        return maxLen * 3;
//    }
//
//    private void printParagraph(String[] words, int lineLen) {
//        print(words[0]);
//        var currentLineLenRemainder = lineLen - words[0].length();
//        for (int i = 1; i < words.length; i++) {
//            var word = words[i];
//            if (word.length() + 1 <= currentLineLenRemainder) {
//                print(" " + word);
//                currentLineLenRemainder -= word.length() + 1;
//            } else {
//                print("\n" + word);
//                currentLineLenRemainder = lineLen - word.length();
//            }
//        }
//    }
//
//    private void print(String s) {
//        System.out.print(s);
//    }
//
//}
