package am.martirosyan;

import java.io.*;

public class MainForOOS {
    public static void main(String[] args) {

        User user = new User("Михаил", 18, "qwerty228");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))) {

            oos.writeObject(user);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))){
            User restoredUser = (User) ois.readObject();
            System.out.println(restoredUser);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
