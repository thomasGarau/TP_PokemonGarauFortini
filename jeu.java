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
        String action = "";
        while(true){
            System.out.println("que souhaiter vous faire :" + "\n" +
                                "1: pour marcher" + "\n" +
                                "2: pour effectuer un combat dans l'arène" + "\n" +
                                "3: pour acheté des pakeball" + "\n" +
                                "4: pour faire evoluer un pokemon"
            );
            action = myObj.nextLine();
            switch(action){
                case "1":
                    new Capture(dresseur);
                    break;

                case "2":
                    System.out.println("combat");
                    break;

                case "3":
                    System.out.println("souhaiter vous acheter des pokeball ? 1 pts bonus au TP pour 20pokeball");
                    action = myObj.nextLine();

                case "4":
                    System.out.println("a quelle pokemon souhaiter vous donner un bonbon ?");
                    for(int i =0; i < dresseur.getListePokemon().size(); i++){
                        System.out.println("" + i + ": pour donner un bonbon a" + dresseur.getListePokemon().get(i).getNom());
                    }
                    action = myObj.nextLine();
                    dresseur.getListePokemon().get(Integer.parseInt(action)).evoluer();

            }

        }
    }
}
