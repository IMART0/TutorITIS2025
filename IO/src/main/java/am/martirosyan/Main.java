package am.martirosyan;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("img.jpg");
                OutputStream outputStream = new FileOutputStream("img_copy.jpg");
                ){

            int input = inputStream.read();
            while (input != -1) {
                outputStream.write(input);
                input = inputStream.read();
            }

            System.out.println("Файл скопирован");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}