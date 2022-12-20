 
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

      //rename le thread dans le server avec le pseudo du joueur
      clientMessage="name " + dresseur.getPseudo();
      outStream.writeUTF(clientMessage);
      outStream.flush();

      //demande de combattre dans l'arène est attend qu'un adverssaire rejoigne 
      clientMessage="combat";
      outStream.writeUTF(clientMessage);
      outStream.flush();
      serverMessage=inStream.readUTF();
      System.out.println("vous venez d'entrer dans l'arène. Le combat commenceras dès qu'un adverssaire joindra");
      //le server désigne qui joueras en premier et qui joueras en second à pile ou face

      if(serverMessage.equals("combat1")){
        System.out.println(serverMessage);
        combat1(dresseur, socket);
      }else{
        System.out.println(serverMessage);
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
    System.out.println("entrer combat1");
    //initialise les fonction de communication avec le server
    DataInputStream inStream=new DataInputStream(socket.getInputStream());
    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String clientMessage="",serverMessage="";

    Pokemon selfPokemon = dresseur.getMainPokemon();
    System.out.println("pc =====" + selfPokemon.getpc());
    int selfHp = selfPokemon.getpv();
    int result = 0;
    
    //envoie les information de sont pokemon à l'adverssaire
    outStream.writeUTF(String.valueOf(selfHp));
    outStream.flush();
    outStream.writeUTF(selfPokemon.getType().get(0));
    outStream.flush();
    if(selfPokemon.getType().size() == 2){
      outStream.writeUTF(selfPokemon.getType().get(1));
      outStream.flush();
    }else{
      outStream.writeUTF("none");
      outStream.flush();
    }
    outStream.writeUTF(selfPokemon.getNom());

    //recois les information du pokemon adversse
    int opponentHp = Integer.parseInt(inStream.readUTF());
    String opponentType1 = inStream.readUTF();
    String opponentType2 = inStream.readUTF();
    String opponentPokemon = inStream.readUTF();

    System.out.println("adverssaire trouvé le combat va bientôt commencé");
    System.out.println("vous êtes le 1er joueur");
    System.out.println("vous envoyer " + selfPokemon.getSurnom() + " au combat");
    System.out.println("l'adverssaire envoi un " + opponentPokemon + " au combat");
    System.out.println("HP de votre pokemon : " + selfHp + "; HP du pokemon adversse " + opponentHp);

    //l'ordre est inverssé en fonction de permier ou second joueur
    while(selfHp > 0){
      result = SystemCombat.attackOnline(selfPokemon, opponentType1, opponentType2);
      opponentHp -= result;
      System.out.println("vous venez d'infliger " + result + " au pokemon adversse");
      System.out.println("hp restant du pokemon adversse " + opponentHp);
      clientMessage= String.valueOf(result);
      outStream.writeUTF(clientMessage);
      outStream.flush();
      if(opponentHp < 1){
        break;
      }
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
    System.out.println("entrer combat 2");

    //initialise les fonction de communication avec le server
    DataInputStream inStream=new DataInputStream(socket.getInputStream());
    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String clientMessage="",serverMessage="";


    Pokemon selfPokemon = dresseur.getMainPokemon();
    int selfHp = selfPokemon.getpv();
    int result = 0;
    System.out.println("pc =====" + selfPokemon.getpc());

    //recois les information du pokemon adversse
    int opponentHp = Integer.parseInt(inStream.readUTF());
    String opponentType1 = inStream.readUTF();
    String opponentType2 = inStream.readUTF();
    String opponentPokemon = inStream.readUTF();

    //envoie les information de sont pokemon à l'adverssaire
    outStream.writeUTF(String.valueOf(selfHp));
    outStream.flush();
    outStream.writeUTF(selfPokemon.getType().get(0));
    outStream.flush();
    if(selfPokemon.getType().size() == 2){
      outStream.writeUTF(selfPokemon.getType().get(1));
      outStream.flush();
    }else{
      outStream.writeUTF("none");
      outStream.flush();
    }
    outStream.writeUTF(selfPokemon.getNom());
    outStream.flush();

    System.out.println("adverssaire trouvé le combat va bientôt commencé");
    System.out.println("vous êtes le second joueur");
    System.out.println("vous envoyer " + selfPokemon.getSurnom() + " au combat");
    System.out.println("l'adverssaire envoi un " + opponentPokemon + " au combat");
    System.out.println("HP de votre pokemon : " + selfHp + "; HP du pokemon adversse " + opponentHp);

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