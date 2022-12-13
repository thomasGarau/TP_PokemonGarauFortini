import java.net.*;
import java.util.ArrayList;

public class MultithreadedSocketServer {
    public static ArrayList <Socket> listeCo;

    public static ArrayList<Socket> getListeCo() {
        return listeCo;
    }
    public static void main(String[] args) throws Exception {
        try{
            ServerSocket server=new ServerSocket(8888);
            ArrayList <ServerClientThread> listeCo=new ArrayList<>();
            int counter=0;
            System.out.println("Server Started ....");
            while(true){
                counter++;
                Socket serverClient=server.accept();  //server accept the client connection request
                System.out.println(" >> " + "Client No:" + counter + " started!");
                ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread
                listeCo.add(sct);
                sct.start();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
