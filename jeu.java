import java.io.IOException;
import java.util.*;

public class jeu {
    public static void main(String[] args) throws ClassNotFoundException, IOException { 
         
        Pokedex poke = new Pokedex();
        Scanner myObj = new Scanner(System.in);
        System.out.println("souhaiter vous charger une sauvegarde ou créer une nouvelle partie ?" + "\n" +
                            "1:charger une sauvegarde" + "\n" +
                            "2: nouvelle partie"
        );
        String loadOrNew = myObj.nextLine();
        Dresseur dresseur;

        if(loadOrNew.equals("1")){
            dresseur = Sauvegarde.loadSauvegarde();

        }else{
            System.out.println("comment vous appeler vous ?");
            String pseudo = myObj.nextLine();

            System.out.println("êtes vous un garcon: taper 1 ou une fille: taper 2");
            int sexe = myObj.nextInt();

            System.out.println("avez qu'elle pokemon souhaiter vous commencer votre aventure?" + "\n" + 
            "taper 1 pour Bulbizarre le pokemon de type plante" + "\n" +
            "2 pour salamèche le pokemon de type feu" + "\n" +
            "3 pour carapuce le pokemon de type eau");
            int choixStarter = myObj.nextInt();

            Pokemon starter = new Pokemon(Pokedex.getPokedex().get(choixStarter -1));
            dresseur = new Dresseur(pseudo, sexe, starter);
            starter.setDresseur(dresseur);
            dresseur.addBonbon(starter.getNom());

            System.out.print("quelle surnom souhaiter vous donné a votre pokemon");
            String surnom = myObj.nextLine();
            starter.setSurnom(surnom);
        }

        String action = "";
        while(true){
            System.out.println("que souhaiter vous faire :" + "\n" +
                                "1: pour marcher" + "\n" +
                                "2: pour effectuer un combat dans l'arène" + "\n" +
                                "3: pour acheté des pakeball" + "\n" +
                                "4: pour faire evoluer un pokemon" + "\n" +
                                "5: pour changé votre pokemon compagnon" + "\n" +
                                "6: pour effectuer une sauvegarde" + "\n" +
                                "7: pour quiter"
            );
            action = myObj.nextLine();
            switch(action){
                case "1":
                    new Capture(dresseur);
                    break;

                case "2":
                    // ne pas oublié de lancer le serveur avant
                    System.out.println("combat");
                    TCPClient tcpClient = new TCPClient();
                    dresseur.addBonbon(dresseur.getMainPokemon().getNom());
                    break;

                case "3":
                    System.out.println("souhaiter vous acheter des pokeball ? 1 pts bonus au TP pour 20pokeball oui=y, non=n");
                    action = myObj.nextLine();
                    if (action.equals("y")){
                        dresseur.addPokeball();
                        System.out.println("vous venez de recevoir 20 pokeball vous en avez désormais " + dresseur.getNbPokeball());
                    }
                    break;

                case "4":
                    System.out.println("a quelle pokemon souhaiter vous donner un bonbon ?");
                    int j = 0;
                    for(j =0; j< dresseur.getListePokemon().size(); j++){
                        System.out.println("" + j + ": pour donner un bonbon a votre "  + dresseur.getListePokemon().get(j).getNom() + " surnomer " + dresseur.getListePokemon().get(j).getSurnom() + " nb bonbon posséder = " + dresseur.getBonbonPokemon().get(dresseur.getListePokemon().get(j).getNom()));
                    }
                    System.out.println(" " + j+1 + "pour annuler");
                    action = myObj.nextLine();
                    if(Integer.parseInt(action) == j+1){
                        break;
                    }
                    dresseur.getListePokemon().get(Integer.parseInt(action)).evoluer();
                    break;

                case "5":
                    int i;
                    for(i=0; i< dresseur.getListePokemon().size(); i++){
                        System.out.println(i + ": pour que votre " + dresseur.getListePokemon().get(i).getNom() +  " " + dresseur.getListePokemon().get(i).getSurnom() + " devienne votre nouveau compagnon");
                    }
                    System.out.println(" " + i+1 + "pour annuler");
                    action = myObj.nextLine();
                    if(Integer.parseInt(action) == i+1){
                        break;
                    }
                    dresseur.setMainPokemon(Integer.parseInt(action));
                    System.out.println("nouveau compagnon = " + dresseur.getMainPokemon().getNom());
                    break;

                case "6":
                    Sauvegarde.sauvegarde(dresseur);
                    break;

                case "7":
                    System.out.println("Aurevoire");
                    return;
            }

        }
    }
}
