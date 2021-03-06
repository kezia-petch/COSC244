import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Calendar;
import java.text.*;

public class TCP_date_time {
    private PrintWriter output;
    private BufferedReader input;
    public TCP_date_time(Socket socket) throws Exception {
        output = new PrintWriter(socket.getOutputStream(), true);
        input =
            new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
        
    public void startReceiving() throws Exception {
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            output.println(formatter.format(calendar.getTime()));
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
                TCP_date_time example = new TCP_date_time(socket);
                example.startSending();
            } else {
                ServerSocket serverSocket = new ServerSocket(port);
                System.err.println("Waiting for someone to connect");
                socket = serverSocket.accept();
                System.err.println("Accepted connection on port " + port);
                TCP_date_time example = new TCP_date_time(socket);
                example.startReceiving();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("\nUsage: java TCPExample <port> [host]");
        }
    }
}
