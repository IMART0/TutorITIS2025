package am.martirosyan;

import java.io.*;

public class Main2 {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("our_text.txt")){

            writer.write("Привет, друг! \nI/O крутая вещь!");




            }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}