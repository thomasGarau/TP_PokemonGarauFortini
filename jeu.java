import java.util.*;
public class jeu {
    public static void main(String[] args) { 
         
        Pokedex poke = new Pokedex();
        Scanner myObj = new Scanner(System.in);
        System.out.println("comment vous appeler vous ?");
        String pseudo = myObj.nextLine();
        myObj.close();
        Dresseur dresseur = new Dresseur(pseudo);
        
        for(int i=0; i < Pokedex.getPokedex().size(); i++){
            System.out.print(Pokedex.getPokedex().get(i).toString());
        }
        
        for(int i=0; i < Pokedex.getListCompetence().size(); i++){
            System.out.print(Pokedex.getListCompetence().get(i).toString());   
        }
        
        System.out.print("\n" + Pokedex.getListCompetence().size() + "\n");
        System.out.print(Pokedex.getPokedex().size());
        System.out.print(dresseur.toString());


    }
}
