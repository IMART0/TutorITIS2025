package am.martirosyan;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(System.in);
        int len = dis.readUnsignedShort();
        byte[] array = new byte[len];
        dis.read(array);
        String s = new String(array, StandardCharsets.UTF_8);

    }
}
