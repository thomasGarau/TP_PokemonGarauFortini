import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.DataInputStream;
import java.io.InputStream;

public class Server extends Thread{
    private static final int PORT = 8080;

    private static List<Socket> connectedClients = new ArrayList<>();

    public static List<Socket> getConnectedClients() {
        return connectedClients;
    }

    public void run(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                connectedClients.add(clientSocket);
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());
                InputStream inFromClient = clientSocket.getInputStream();
                DataInputStream in = new DataInputStream(inFromClient);
                String message = in.readUTF();
                System.out.println("Message from client: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server routine = new Server();
        routine.start();
    }
}


