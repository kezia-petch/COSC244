import java.util.Scanner;
import java.io.*;

public class BitLevel{
    
    public static void main(String[] args) throws IOException, FileNotFoundException{

        FileInputStream in = new FileInputStream(args[0]);
        FileOutputStream out = new FileOutputStream(args[1]);

        Scanner sc = new Scanner(System.in);
        System.out.println("Key: ");
        byte[] key = sc.nextLine().getBytes();
        int index = 0;
        int xorResult = 0;
        int input;

        while ((input = in.read()) > -1){
            xorResult =  key[index++] ^ input;
            index = index % key.length;
            out.write(xorResult);
        }

        out.close();
       
    }
}
