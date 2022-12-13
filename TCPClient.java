 
import java.net.*;
import java.io.*;
public class TCPClient {
  public static void main(String[] args) throws Exception {
  try{
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
        System.out.println("Server message: "+serverMessage);
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