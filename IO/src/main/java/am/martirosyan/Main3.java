package am.martirosyan;

import java.io.*;

public class Main3 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("our_text.txt"))){

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Прочитано: " + line);
            }

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}