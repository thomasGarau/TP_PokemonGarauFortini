import java.net.*;
import java.io.*;

//instance de client lorsqu'il décide de se connecter à l'arène
//TCPClient permet de connecter le dresseur à l'arène et de gérer le combat
public class TCPClient {

  public TCPClient(Dresseur dresseur){
    try{
      Socket socket=new Socket("127.0.0.1",8888);
      DataInputStream inStream=new DataInputStream(socket.getInputStream());
      DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
      String clientMessage="",serverMessage="";

      //rename le thread dans le server avec le pseudo du joueur
      clientMessage="name " + dresseur.getPseudo();
      outStream.writeUTF(clientMessage);
      outStream.flush();

      //demande de combattre dans l'arène et attend qu'un adversaire rejoigne 
      clientMessage="combat";
      outStream.writeUTF(clientMessage);
      outStream.flush();
      serverMessage=inStream.readUTF();
      System.out.println("vous venez d'entrer dans l'arène. Le combat commencera dès qu'un adversaire rejoindra");
      //le server désigne qui jouera en premier et qui jouera en second à pile ou face

      if(serverMessage.equals("premier")){
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
    //initialise les fonctions de communication avec le server
    DataInputStream inStream=new DataInputStream(socket.getInputStream());
    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
    String clientMessage="";

    Pokemon selfPokemon = dresseur.getMainPokemon();
    int selfHp = selfPokemon.getpv();
    int result = 0;
    
    //envoie les informations de son pokemon à l'adversaire
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

    //recois les informations du pokemon adverse
    int opponentHp = Integer.parseInt(inStream.readUTF());
    String opponentType1 = inStream.readUTF();
    String opponentType2 = inStream.readUTF();
    String opponentPokemon = inStream.readUTF();

    System.out.println("adversaire trouvé:le combat va bientôt commencer");
    System.out.println("vous êtes le 1er joueur");
    System.out.println("vous envoyer " + selfPokemon.getSurnom() + " au combat");
    System.out.println("l'adversaire envoi un " + opponentPokemon + " au combat");
    System.out.println("Pv de votre pokemon : " + selfHp + "; Pv du pokemon adverse " + opponentHp);

    //l'ordre est inverssé en fonction de permier ou second joueur
    //après l'attaque de l'adversaire si le pokemon est ko le combat s'arrête
    while(selfHp > 0){
      //attaque le pokemon adverse
      result = SystemCombat.attackOnline(selfPokemon, opponentType1, opponentType2);
      opponentHp -= result;
      System.out.println("vous venez d'infliger " + result + " au pokemon adverse");
      System.out.println("Pv restant du pokemon adverse " + opponentHp);
      clientMessage= String.valueOf(result);
      outStream.writeUTF(clientMessage);
      outStream.flush();
      //après cette attaque si l'adversaire et ko le combat s'arrête
      if(opponentHp < 1){
        break;
      }

      //se fait attaquer
      result = Integer.parseInt(inStream.readUTF());
      selfHp -= result;
      System.out.println("le pokemon adverse à attaqué, votre pokemon a subit " + result + " dégats");
      System.out.println("Pv restant de votre pokemon " + selfHp);
    }

    if(opponentHp < 1){
      System.out.println("Félicitation vous avez gagné!");
      dresseur.addBonbon(selfPokemon.getNom());
      dresseur.winCombat();
    }else if(selfHp < 1){
      System.out.println("Vous avez perdu!");
      dresseur.looseCombat();
    }else{
      System.out.println("erreur !!");
    }

  }

  //fonction combat si second joueur
  public void combat2(Dresseur dresseur, Socket socket) throws NumberFormatException, IOException{


    //initialise les fonctions de communication avec le server
    DataInputStream inStream=new DataInputStream(socket.getInputStream());
    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
    String clientMessage="";


    Pokemon selfPokemon = dresseur.getMainPokemon();
    int selfHp = selfPokemon.getpv();
    int result = 0;
  
    //recois les information du pokemon adverse
    int opponentHp = Integer.parseInt(inStream.readUTF());
    String opponentType1 = inStream.readUTF();
    String opponentType2 = inStream.readUTF();
    String opponentPokemon = inStream.readUTF();

    //envoie les information de son pokemon à l'adversaire
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

    System.out.println("adversaire trouvé :le combat va bientôt commencer ");
    System.out.println("vous êtes le second joueur");
    System.out.println("vous envoyer " + selfPokemon.getSurnom() + " au combat");
    System.out.println("l'adversaire envoi un " + opponentPokemon + " au combat");
    System.out.println("Pv de votre pokemon : " + selfHp + "; Pv du pokemon adverse " + opponentHp);

    //l'ordre est inversé en fonction de permier ou second joueur
    //après cette attaque si l'adversaire est ko le combat s'arrête
    while(opponentHp > 0){
      //ce fait attaquer 
      result = Integer.parseInt(inStream.readUTF());
      selfHp -= result;
      System.out.println("le pokemon adverse à attaqué ,votre pokemon a subit " + result + " dégats");
      System.out.println("Pv restant de votre pokemon " + selfHp);
      //après l'attaque de l'adversaire si le pokemon est ko le combat s'arrête
      if(selfHp < 1){
        break;
      }
      //attaque l'adversaire
      result = SystemCombat.attackOnline(selfPokemon, opponentType1, opponentType2);
      opponentHp -= result;
      System.out.println("vous venez d'infliger " + result + " au pokemon adverse");
      System.out.println("Pv restant du pokemon adverse " + opponentHp);
      clientMessage= String.valueOf(result);
      outStream.writeUTF(clientMessage);
      outStream.flush();
    }

    if(opponentHp < 1){
      System.out.println("Félicitation vous avez gagné!");
      dresseur.addBonbon(selfPokemon.getNom());
      dresseur.winCombat();
    }else if(selfHp < 1){
      System.out.println("Vous avez perdu!");
      dresseur.looseCombat();;
    }else{
      System.out.println("erreur !!");
    }

  }
}