import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Calendar;
import java.text.*;

public class TCP_date_time1 {
    private PrintWriter output;
    private BufferedReader input;
    public TCP_date_time1(Socket socket) throws Exception {
        output = new PrintWriter(socket.getOutputStream(), true);
        input =
            new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
        
    public void startReceiving() throws Exception {
        String line;
        Scanner stdin1 = new Scanner(System.in);
        while ((line = input.readLine()) != null) {
            System.out.println(line);
            if (stdin1.hasNextLine()) {
                output.println(stdin1.nextLine());
            }
        }
    }
        
    public void startSending() throws IOException {
        Scanner stdin = new Scanner(System.in);
        String dateTime;
        System.err.println("Please enter data here");
        while (stdin.hasNextLine()) {
            output.println(stdin.nextLine());
            dateTime = input.readLine();
            System.out.println(dateTime);
        }
    }
        
    public static void main(String[] args) {
        Socket socket = null;
        try {
            int port = Integer.parseInt(args[0]);
            if (args.length > 1) {
                socket = new Socket(args[1], port);
                System.err.println("Connected to " + args[1] + " on port " + port);
                TCP_date_time1 example = new TCP_date_time1(socket);
                example.startSending();
            } else {
                ServerSocket serverSocket = new ServerSocket(port);
                System.err.println("Waiting for someone to connect");
                socket = serverSocket.accept();
                System.err.println("Accepted connection on port " + port);
                TCP_date_time1 example = new TCP_date_time1(socket);
                example.startReceiving();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("\nUsage: java TCP_date_time1 <port> [host]");
        }
    }
}
