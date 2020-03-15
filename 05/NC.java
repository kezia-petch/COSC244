import java.util.Scanner;
import java.io.*;

public class NC {

    public static void main(String[] args) throws IOException
    {
        int shift = Integer.parseInt(args[0]);
        InputStreamReader in = new InputStreamReader(System.in);
        OutputStream out = System.out;
        int b;
        int sn = 0;
        while ((b = in.read()) != -1) {
            sn = (b + shift) % 256;
            out.write(sn);
        }
        out.flush();
        out.close();
    }
}
