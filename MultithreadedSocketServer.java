import java.net.*;
import java.util.ArrayList;


public class MultithreadedSocketServer {
    public static ArrayList <ServerClientThread> listeCo = new ArrayList<>();

    public static void sendToOther() {
        for(ServerClientThread i :listeCo){
            i.fromServer("bblolbolbolo");
        }
    }

    public static String format(){
        String mess="";
        for(ServerClientThread i:listeCo){
            mess+=i+"\n";
        }
        return mess;
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
