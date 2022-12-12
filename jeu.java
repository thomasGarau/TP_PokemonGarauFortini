import java.util.*;
public class jeu {
    public static void main(String[] args) { 
         
        Pokedex poke = new Pokedex();

        Scanner myObj = new Scanner(System.in);
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
        Dresseur dresseur = new Dresseur(pseudo, sexe, starter);
        starter.setDresseur(dresseur);
        System.out.print(dresseur); 
        Capture capture = new Capture(dresseur);
        capture = null;
        Capture capture2 = new Capture(dresseur);
        Capture capture3 = new Capture(dresseur);
        Capture capture4 = new Capture(dresseur);
    }
}
