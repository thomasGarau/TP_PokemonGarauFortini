import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

class ServerClientThread extends Thread {
    Socket serverClient;
    int clientNo;
  
    ServerClientThread(Socket inSocket,int counter){
      serverClient = inSocket;
      clientNo=counter;
    }
  
    public void run(){
      try{
        DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
        DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
        String clientMessage="", serverMessage="";
        while(!clientMessage.equals("quit")){
          clientMessage=inStream.readUTF();
          System.out.println("From Client-" +clientMessage);
          if(clientMessage.equals("joueur")){
            serverMessage="liste des joueurs connecté\n"+MultithreadedSocketServer.listeCo;
            outStream.writeUTF(serverMessage);
            outStream.flush();   
          }
          else if(clientMessage.equals("combat")){
              //checrhe adv
          }
          else{
            serverMessage=clientMessage;
            outStream.writeUTF(serverMessage);
            outStream.flush();
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