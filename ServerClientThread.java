import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


class ServerClientThread extends Thread {
    Socket serverClient;
    int clientNo;
  
    ServerClientThread(Socket inSocket,int counter){
      serverClient = inSocket;
      clientNo=counter;
    }

    public void fromServer(String mess){
      try {
        DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
        outStream.writeUTF(mess);
        outStream.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  
    public void run(){
      try{
        DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
        DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
        String clientMessage="", serverMessage="";
        while(!clientMessage.equals("quit")){
          clientMessage=inStream.readUTF();
          if(clientMessage.equals("joueur")){
            serverMessage="liste des joueur connectés:\n"+MultithreadedSocketServer.format();
            outStream.writeUTF(serverMessage);
            outStream.flush();   
          }
          else if(clientMessage.equals("combat")){
            MultithreadedSocketServer.sendToOther();
          }
          else{
            System.out.println("From Client-" +clientMessage);
            outStream.writeUTF("");
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