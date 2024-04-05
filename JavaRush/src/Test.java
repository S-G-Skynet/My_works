import java.io.*;
import java.util.ArrayList;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        String s;
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            while ((s = br.readLine()) != null) {
                if (s.startsWith("Total goals for")) {
                    result.append(s).append("\n");
                }
                if (s.startsWith("Total goals by")) {
                    result.append(s).append("\n");
                }
                if (s.startsWith("Mean goals per game for")) {
                    result.append(s).append("\n");
                }
                if (s.startsWith("Mean goals per game by")) {
                    result.append(s).append("\n");
                }
                if (s.startsWith("Goals on minute")) {
                    result.append(s).append("\n");
                }
                if (s.startsWith("Goals on first")) {
                    result.append(s).append("\n");
                }
                if (s.startsWith("Goals on last")) {
                    result.append(s).append("\n");
                }
                if (s.startsWith("Score opens by")) {
                    result.append(s).append("\n");
                }
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("outTest.txt"))) {

            bw.write(result.toString());
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}

