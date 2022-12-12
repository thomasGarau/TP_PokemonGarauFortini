import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class MultithreadedSocketServer {
    public static ArrayList <ServerClientThread> listeCo = new ArrayList<>();

    public static void sendToOther() {
        System.out.println("abrbllbl");;
        for(int i=0; i< listeCo.size(); i++){
            listeCo.get(i).fromServer("bblolbolbolo");
 

        }
    }
    public static void main(String[] args) throws Exception {
        try{
            ServerSocket server=new ServerSocket(8888);
            int counter=0;
            System.out.println("Server Started ....");
            while(true){
                counter++;
                Socket serverClient=server.accept();  //server accept the client connection request
                System.out.println(" >> " + "Client No:" + counter + " started!");
                ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread
                MultithreadedSocketServer.listeCo.add(sct);
                System.out.println(listeCo.size() + "size");
                sct.start();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
