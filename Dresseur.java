import java.util.*;

public class Dresseur {
    private String pseudo;
    private int nbPokemon = 0;
    private int victoire = 0; 
    private int defaite = 0;
    private ArrayList<Pokemon> listePokemeon = new ArrayList<>();

    public Dresseur(String pseudo){
        this.pseudo = pseudo;
    }

    public void capturePokemon(Pokemon pokemon){
        this.listePokemeon.add(pokemon);
        this.nbPokemon ++;
    }

    public void winCombat(){
        this.victoire ++;
    }

    public void looseCombat(){
        this.defaite ++;
    }

    

    public void getWinrate(){
        System.out.print((this.victoire / (this.defaite + this.victoire)) * 100);
    }
}
