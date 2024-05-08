import java.io.*;

public class FileReaderAndWriter {
    public static void main(String[] args) {
        String s;
        String result = null;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            while ((s = br.readLine()) != null) {
                String[] arr = s.split(" ");
                Long a = Long.parseLong(arr[0]);
                Long b = Long.parseLong(arr[1]);
                result = String.valueOf(a + b);
                System.out.println(s);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            bw.write(result);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    /*import java.io.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        StreamTokenizer in = new StreamTokenizer(
            new BufferedInputStream(
                new FileInputStream(new File("input.txt"))));
        PrintStream out = new PrintStream(new File("output.txt"));
        int a, b;
        in.nextToken();
        a = (int) in.nval;
        in.nextToken();
        b = (int) in.nval;
        out.println(a + b);
    }
}*/
}
