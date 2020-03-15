import java.io.IOException;
import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.*;

public class program2{

    public static void main(String[] args){
        
        BufferedReader reader = new BufferedReader
            (new InputStreamReader(System.in));
            String line;
            System.out.println("Enter text:");
            try {
                while ((line = reader.readLine())!= null){
                
                    StringBuilder lineRead = new StringBuilder(line);

                    System.out.print("Entered text in reverse: ");
                    System.out.println(lineRead.reverse());
                }
            }
            catch (IOException e){
                System.out.println("Input error from user");
        }
    }
}
