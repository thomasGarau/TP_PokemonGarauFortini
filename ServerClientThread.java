import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

//thread demarré par le serveur unique à chaque client
class ServerClientThread extends Thread {
    Socket serverClient;
    int clientNo;
    String threadDest;
  
    ServerClientThread(Socket inSocket,int counter){
      serverClient = inSocket;
      clientNo=counter;
    }

    //redistribut un message venant du serveur
    //fait le pont entre serveur et TCP
    public void fromServer(String mess){
      try {
        DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
        outStream.writeUTF(mess);
        outStream.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public void setAdverssaire(String name){
      this.threadDest = name;
    }
    
    //redef de la fonction run()
    public void run(){
      try{
        DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
        DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
        String clientMessage="", serverMessage="";
        //on ecoute le client en continu et on attends de lui
        //soit un message soit une commande
        while(!clientMessage.equals("quit")){
          clientMessage=inStream.readUTF();
          if(clientMessage.equals("joueur")){
            serverMessage="liste des joueur connectés:\n"+MultithreadedSocketServer.format();
            outStream.writeUTF(serverMessage);
            outStream.flush();   
          }
          else if(clientMessage.equals("combat")){
            MultithreadedSocketServer.arene(this);
          }
          else if(clientMessage.contains("name")){
            MultithreadedSocketServer.rename(serverClient,clientMessage.split(" ")[1]);
          }
          else{
            MultithreadedSocketServer.messagePerso(threadDest,this,clientMessage);
          }
        }
        inStream.close();
        outStream.close();
        serverClient.close();
      }catch(Exception ex){
        System.out.println(ex);
      }finally{
        System.out.println("Client -" + clientNo + " exit!! ");
      }
    }
}