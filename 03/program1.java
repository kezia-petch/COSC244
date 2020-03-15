import java.io.IOException;

public class program1{

    public static void main(String [] args){
        int inputChar;
        System.out.println("Enter a Character:");
        try {
            while ((inputChar = System.in.read()) > -1){
            System.out.write(inputChar);
            }
        }
        catch (IOException e){
            System.out.println("Input error from user");
        }
    }
}
