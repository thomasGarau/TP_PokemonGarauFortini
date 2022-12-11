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

    public int getWinrate(){
        if(this.victoire + this.defaite > 0){
            return ((this.victoire / (this.defaite + this.victoire)) * 100);
        }
        return 0;
    }

    public String toString(){
        int winrate = this.getWinrate();
        String a = "";
        for(int i=0; i< listePokemeon.size(); i++){
            a+= listePokemeon.get(i) + ", ";
        }
        return (
            "nom" + this.pseudo + "\n" +
            "posséde " + this.nbPokemon + " Pokemon" + "\n" +
            a + "\n" +
            "a gagné " + this.victoire + " combat dans l'arène " + "\n" +
            "en a perdu" + this.defaite + "\n" +
            "winrate de " + winrate + "%"
        );


    }
}
