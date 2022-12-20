 
import java.net.*;
import java.nio.file.OpenOption;
import java.io.*;
public class TCPClient {

  public TCPClient(Dresseur dresseur){
    try{
      System.out.println("aaaa");
      Socket socket=new Socket("127.0.0.1",8888);
      DataInputStream inStream=new DataInputStream(socket.getInputStream());
      DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String clientMessage="",serverMessage="";
      clientMessage="combat";
      outStream.writeUTF(clientMessage);
      outStream.flush();
      serverMessage=inStream.readUTF();
      if(!serverMessage.equals("combat1")){
        System.out.println("Server: "+serverMessage);
        combat1(dresseur, socket);
      }else{
        System.out.println("Server: "+serverMessage);
        combat2(dresseur, socket);
      }
      
      outStream.close();
      inStream.close();
      socket.close();
    }catch(Exception e){
      System.out.println(e);
    }
  }

  //fonction combat si premier joueur
  public void combat1(Dresseur dresseur, Socket socket) throws NumberFormatException, IOException{
    DataInputStream inStream=new DataInputStream(socket.getInputStream());
    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String clientMessage="",serverMessage="";
    Pokemon selfPokemon = dresseur.getMainPokemon();
    int selfHp = selfPokemon.getpv();
    int opponentHp = Integer.parseInt(inStream.readUTF());
    String opponentType1 = inStream.readUTF();
    String opponentType2 = inStream.readUTF();
    double result = 0;

    //l'ordre est inverssé en fonction de permier ou second joueur
    while(selfHp > 0){
      result = SystemCombat.attackOnline(selfPokemon, opponentType1, opponentType2);
      opponentHp -= result;
      System.out.println("vous venez d'infliger " + result + " au pokemon adversse");
      System.out.println("hp restant du pokemon adversse " + opponentHp);
      if(opponentHp < 1){
        break;
      }
      clientMessage= String.valueOf(result);
      outStream.writeUTF(clientMessage);
      outStream.flush();
      result = Integer.parseInt(inStream.readUTF());
      selfHp -= result;
      System.out.println("le pokemon adverse à attaquer votre pokemon a subit " + result + " dégats");
      System.out.println("hp restant de votre pokemon " + selfHp);
    }

    if(opponentHp < 1){
      System.out.println("Félicitation vous avez gagné");
      dresseur.addBonbon(selfPokemon.getNom());
    }else if(selfHp < 1){
      System.out.println("Vous avez perdu, vous ferrais mieux la prochaine fois");
    }else{
      System.out.println("erreur ");
    }

  }

  //fonction combat si second joueur
  public void combat2(Dresseur dresseur, Socket socket) throws NumberFormatException, IOException{
    DataInputStream inStream=new DataInputStream(socket.getInputStream());
    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String clientMessage="",serverMessage="";
    Pokemon selfPokemon = dresseur.getMainPokemon();
    int selfHp = selfPokemon.getpv();
    int opponentHp = Integer.parseInt(inStream.readUTF());
    String opponentType1 = inStream.readUTF();
    String opponentType2 = inStream.readUTF();
    double result = 0;

    //l'ordre est inverssé en fonction de permier ou second joueur
    while(opponentHp > 0){
      result = Integer.parseInt(inStream.readUTF());
      selfHp -= result;
      System.out.println("le pokemon adverse à attaquer votre pokemon a subit " + result + " dégats");
      System.out.println("hp restant de votre pokemon " + selfHp);
      if(selfHp < 1){
        break;
      }
      result = SystemCombat.attackOnline(selfPokemon, opponentType1, opponentType2);
      opponentHp -= result;
      System.out.println("vous venez d'infliger " + result + " au pokemon adversse");
      System.out.println("hp restant du pokemon adversse " + opponentHp);
      clientMessage= String.valueOf(result);
      outStream.writeUTF(clientMessage);
      outStream.flush();
    }

    if(opponentHp < 1){
      System.out.println("Félicitation vous avez gagné");
      dresseur.addBonbon(selfPokemon.getNom());
    }else if(selfHp < 1){
      System.out.println("Vous avez perdu, vous ferrais mieux la prochaine fois");
    }else{
      System.out.println("erreur ");
    }

  }
}