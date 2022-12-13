import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class ServerClientThread extends Thread {
    Socket serverClient;
    int clientNo;
  
    ServerClientThread(Socket inSocket,int counter){
      serverClient = inSocket;
      clientNo=counter;
    }

    public void fromServer(String mess){
      try {
        System.out.println("bonjour");
        DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
        outStream.writeUTF("aaa");
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
        outStream.writeInt(1);
        while(!clientMessage.equals("quit")){
          clientMessage=inStream.readUTF();
          System.out.println("From Client-" +clientMessage);
          System.out.println(serverMessage + "from server");
          if(clientMessage.equals("joueur")){
            outStream.writeUTF(serverMessage);
            outStream.flush();   
          }
          else if(clientMessage.equals("combat")){
              MultithreadedSocketServer.sendToOther();
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