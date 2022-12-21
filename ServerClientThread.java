import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

//thread demarré par le serveur unique à chaque client
//permet au client de communiqué avec le serveur
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
    //cela permettra au thread de communiqué des message spécifiquement au thread de l'adverssaire
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

        //le joueur décide de quitter le combat
        while(!clientMessage.equals("quit")){
          clientMessage=inStream.readUTF();

          //le joueur souhaite connaitre la liste des autres joueur connecté à l'arène
          if(clientMessage.equals("joueur")){
            serverMessage="liste des joueur connectés:\n"+MultithreadedSocketServer.format();
            outStream.writeUTF(serverMessage);
            outStream.flush();   
          }
          //le joueur souhaite effectué un combat 
          //il est placé dans la liste d'attente jusqu'a qu'un adversaire rejoigne la salle d'attente
          else if(clientMessage.equals("combat")){
            MultithreadedSocketServer.arene(this);
          }
          //renome le nom du thread
          else if(clientMessage.contains("name")){
            MultithreadedSocketServer.rename(serverClient,clientMessage.split(" ")[1]);
          }
          //communication utilisé lors du combat afin de transmettre les dégat infligé de parte et d'autre
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