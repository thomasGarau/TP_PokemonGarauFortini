import java.util.*;

public class Dresseur {
    private String pseudo;
    private int nbPokemon = 0;
    //nombre de victoire dans l'arène
    private int victoire = 0; 
    //nombre de défaite dans l'arène
    private int defaite = 0;
    private ArrayList<Pokemon> listePokemeon = new ArrayList<>();
    //le pokemon principale du dresseur celui avec lequelle il combat par défaut
    //le pokemon principale est l'index mainPokemon dans la liste listePokemon
    private int mainPokemon;

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

    public void setMainPokemon(int value){
        if(this.listePokemeon.size() >= value){
            this.mainPokemon = value; 
        }
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
