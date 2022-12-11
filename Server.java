import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.DataInputStream;
import java.io.InputStream;

public class Server extends Thread{
    private static final int PORT = 8080;
    private static int nb_client=-1;
    private static List<Socket> connectedClients = new ArrayList<>();

    public static List<Socket> getConnectedClients() {
        return connectedClients;
    }

    public void printClient(){
        for(int i=0;i<getConnectedClients().size();i++){
            System.out.println(getConnectedClients().get(i));
        }
    }

    public void inputHandler(String input){
        if(input.equals("deco")){
            //deconexion
        }
        else if(input.equals("joueur")){
            printClient();
        }
        else if(input.equals("combat")){
            //checrhe adv
        }
        else{
            System.out.println("Message from client: " + input);
        }
    }

    public void run(){
        Socket clientSocket =getConnectedClients().get(nb_client);
        while(true){
            try{
                InputStream inFromClient = clientSocket.getInputStream();
                DataInputStream in = new DataInputStream(inFromClient);
                String message = in.readUTF();
                inputHandler(message);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        while(true){
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket clientSocket = serverSocket.accept();
                nb_client++;
                connectedClients.add(clientSocket);
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());
                Server routine = new Server();
                routine.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


