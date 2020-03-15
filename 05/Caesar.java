import java.util.Scanner;
import java.io.*;

public class Caesar{
    
    public static void main(String[] args) throws IOException{
        int shift = Integer.parseInt(args[0]);
        InputStreamReader in = new InputStreamReader(System.in);
        OutputStream out = System.out;
        int bb = 0;

        int shiftedNum = 0;
        
        while ((bb = in.read()) != -1){
            shiftedNum = (bb + shift) % 256;
            out.write(shiftedNum);
        }
        out.flush();
        out.close();
    }
}
