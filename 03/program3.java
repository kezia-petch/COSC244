import java.io.IOException;
import java.lang.StringBuilder;
import java.io.*;
import java.util.*;

public class program3{

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        String line;
        System.out.println("Enter text:");
        while (sc.hasNextLine()){
            line = sc.nextLine();
            StringBuilder lineRead = new StringBuilder(line);

            System.out.print("Entered text in reverse: ");
                
            System.out.println(line.toUpperCase());
        }
    }
       
}
