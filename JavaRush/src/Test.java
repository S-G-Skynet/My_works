    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class Test {
        static long count = 0;
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int k = scan.nextInt();
            generateNumbers("", n, k);


            System.out.println(count);
        }

        public static void generateNumbers(String number, long length, int k) {
            if (number.length() == length) {
                if(Long.parseLong(number) % k == 0)
                    count++;
                return;
            }

            if (number.isEmpty() || Character.getNumericValue(number.charAt(number.length() - 1)) % 2 == 0) {
                for (int i = 1; i <= 9; i += 2) {
                    generateNumbers(number + i, length, k);
                }
            } else {
                for (int i = 0; i <= 8; i += 2) {
                    generateNumbers(number + i, length, k);
                }
            }
        }
    }