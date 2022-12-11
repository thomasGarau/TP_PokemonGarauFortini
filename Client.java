import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket(SERVER_IP, SERVER_PORT);
            Scanner myObj = new Scanner(System.in);
            while(true){
                System.out.println("message: ");
                String input = myObj.nextLine(); 
                OutputStream outToServer = clientSocket.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);
                out.writeUTF(input);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
