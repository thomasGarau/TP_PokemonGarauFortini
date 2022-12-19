 
import java.net.*;
import java.io.*;
public class TCPClient {

  public void combat(){

  }

  public TCPClient(){
    try{
      System.out.println("aaaa");
      Socket socket=new Socket("127.0.0.1",8888);
      DataInputStream inStream=new DataInputStream(socket.getInputStream());
      DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String clientMessage="",serverMessage="";
      while(!clientMessage.equals("quit")){
        System.out.println("message :");
        clientMessage=br.readLine();
        outStream.writeUTF(clientMessage);
        outStream.flush();
        serverMessage=inStream.readUTF();
        if(!serverMessage.equals("")){
          System.out.println("Server: "+serverMessage);
        }
        else if(!serverMessage.equals("tatakae")){
          System.out.println("le combat va commencer");
          combat();
        }
      }
      outStream.close();
      inStream.close();
      socket.close();
    }catch(Exception e){
      System.out.println(e);
    }
  }
}