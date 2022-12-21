import java.io.IOException;
import java.util.*;

//classe principale consistant en une boucle infinie
public class jeu {
    public static void main(String[] args) throws ClassNotFoundException, IOException { 
         
        //on initialise un pokedex pour avoir la reférence de tous les pokemon
        Pokedex poke = new Pokedex();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Charger une sauvegarde ou nouvelle partie ?\n" +
                            "1:charger une sauvegarde\n" +
                            "2: nouvelle partie"
        );
        int loadOrNew = myObj.nextInt();
        Dresseur dresseur;
        myObj.nextLine();

        if(loadOrNew==1){
            //on load le fichier sauvegarde qui contient l'instance du dresseur sauvegarder
            dresseur = Sauvegarde.loadSauvegarde();

        }else{
            //si non le joueur créer un nouveau dresseur
            System.out.println("Votre nom ?");
            String pseudo = myObj.nextLine();

            System.out.println("êtes vous un garcon:1 ou une fille:2");
            int sexe = myObj.nextInt();

            System.out.println("avec quel pokemon souhaiter vous commencer votre aventure?\n"+ 
            "1 pour Bulbizarre le pokemon de type plante\n"+
            "2 pour salamèche le pokemon de type feu\n"+
            "3 pour carapuce le pokemon de type eau");
            int choixStarter = myObj.nextInt();

            Pokemon starter = new Pokemon(Pokedex.getPokedex().get(choixStarter -1));
            dresseur = new Dresseur(pseudo, sexe, starter);
            starter.setDresseur(dresseur);
            dresseur.addBonbon(starter.getNom());
            myObj.nextLine();

            System.out.print("quel surnom souhaiter vous donné a votre pokemon\n");
            String surnom = myObj.nextLine();
            starter.setSurnom(surnom);
        }

        String action = "";
        while(true){
            System.out.println("que souhaiter vous faire :\n" +
                                "1: marcher\n" +
                                "2: effectuer un combat dans l'arène\n" +
                                "3: acheter des pokeballs\n" +
                                "4: faire evoluer un pokemon\n" +
                                "5: changer votre pokemon compagnon\n" +
                                "6: pour afficher votre ratio de victoire dans l'arène\n" +
                                "7: sauvegarder\n" +
                                "8: quiter"
            );
            action = myObj.nextLine();
            switch(action){
                
                //capture de pokemon
                case "1":
                    new Capture(dresseur);
                    break;

                //combat arène
                case "2":
                    // ne pas oublié de lancer le serveur avant
                    System.out.println("combat");
                    TCPClient tcpClient = new TCPClient(dresseur);
                    break;

                //achat de pokeball
                case "3":
                    System.out.println("souhaiter vous acheter des pokeballs ? 1 pts bonus au TP pour 20pokeball oui=y, non=n");
                    action = myObj.nextLine();
                    if (action.equals("y")){
                        dresseur.addPokeball();
                        System.out.println("vous recevez 20 pokeballs, vous en avez désormais " + dresseur.getNbPokeball());
                    }
                    break;
                
                //evolution de pokemon
                case "4":
                    System.out.println("à quel pokemon souhaiter vous donner un bonbon ?");
                    int j = 0;
                    for(j =0; j< dresseur.getListePokemon().size(); j++){
                        System.out.println("" + j + ": pour donner un bonbon a votre "  + dresseur.getListePokemon().get(j).getNom() + " nommé: " + dresseur.getListePokemon().get(j).getSurnom() + " nb bonbons possédés = " + dresseur.getBonbonPokemon().get(dresseur.getListePokemon().get(j).getNom()));
                    }
                    System.out.println(" " + j + "pour annuler");
                    action = myObj.nextLine();
                    if(Integer.parseInt(action) == j){
                        break;
                    }
                    dresseur.getListePokemon().get(Integer.parseInt(action)).evoluer();
                    break;
                
                //changement du pokemon compagnon
                case "5":
                    int i;
                    for(i=0; i< dresseur.getListePokemon().size(); i++){
                        System.out.println(i + ": pour que votre " + dresseur.getListePokemon().get(i).getNom() +  " " + dresseur.getListePokemon().get(i).getSurnom() + " devienne votre nouveau compagnon");
                    }
                    System.out.println(" " + i + "pour annuler");
                    action = myObj.nextLine();
                    if(Integer.parseInt(action) == i){
                        break;
                    }
                    dresseur.setMainPokemon(Integer.parseInt(action));
                    System.out.println("nouveau compagnon = " + dresseur.getMainPokemon().getNom());
                    break;
                
                //affichage du taux de victoire dans l'arène
                case "6":
                    dresseur.getWinrate();
                    break;
                
                //sauvegarde la partie (serialise le dresseur)
                case "7":
                    Sauvegarde.sauvegarde(dresseur);
                    break;
                
                //quite la partie
                case "8":
                    System.out.println("Aurevoir");
                    return;
            }

        }
    }
}
