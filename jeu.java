import java.util.*;
public class jeu {
    public static void main(String[] args) { 
         
        Pokedex poke = new Pokedex();
        
        Scanner myObj = new Scanner(System.in);
        System.out.println("comment vous appeler vous ?");
        String pseudo = myObj.nextLine();
        myObj.close();

        Scanner choix = new Scanner(System.in);
        System.out.println("êtes vous un garcon: taper 1 ou une fille: taper 2");
        int sexe = choix.nextInt();
        choix.close();

        Scanner choix2 = new Scanner(System.in);
        System.out.println("avez qu'elle pokemon souhaiter vous commencer votre aventure?" + "\n" + 
        "taper 1 pour Bulbizarre le pokemon de type plante" + "\n" +
        "2 pour salamèche le pokemon de type feu" + "\n" +
        "3 pour carapuce le pokemon de type eau");
        int choixStarter = myObj.nextInt();
        choix2.close();

        Dresseur dresseur = new Dresseur(pseudo, sexe, Pokedex.getPokedex().get(choixStarter -1));
        
        for(int i=0; i < Pokedex.getPokedex().size(); i++){
            System.out.print(Pokedex.getPokedex().get(i).toString());
        }
        
        for(int i=0; i < Pokedex.getListCompetence().size(); i++){
            System.out.print(Pokedex.getListCompetence().get(i).toString());   
        }
        
        System.out.print("\n" + Pokedex.getListCompetence().size() + "\n");
        System.out.print(Pokedex.getPokedex().size());
        System.out.print(dresseur.toString());
        Capture capture = new Capture(dresseur);
        capture = null;
        Capture capture2 = new Capture(dresseur);
        Capture capture3 = new Capture(dresseur);
        Capture capture4 = new Capture(dresseur);

    }
}
