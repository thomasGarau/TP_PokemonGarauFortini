import java.util.*;

public class Dresseur {
    private String pseudo;
    private String sexe;
    private int nbPokemon = 0;
    //nombre de victoire dans l'arène
    private int victoire = 0; 
    //nombre de défaite dans l'arène
    private int defaite = 0;
    private ArrayList<Pokemon> listePokemeon = new ArrayList<>();
    //le pokemon principale du dresseur celui avec lequelle il combat par défaut
    //le pokemon principale est l'index mainPokemon dans la liste listePokemon
    private int mainPokemon = 0;

    public Dresseur(String pseudo, int sexe, Pokemon starter){
        this.pseudo = pseudo;
        if(sexe ==1){
            this.sexe = "homme";
        }else{
            this.sexe = "femme";
        }
        listePokemeon.add(starter);
    }

    public void capturePokemon(Pokemon pokemon){
        Scanner myObj = new Scanner(System.in);
        System.out.println("quelle nom souhaiter vous donner a votre" + pokemon.getNom() + "?");
        String surnom = myObj.nextLine();
        myObj.close();
        pokemon.setSurnom(surnom);
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

    public Pokemon getMainPokemon(){
        return this.listePokemeon.get(mainPokemon);
    }

    public void setMainPokemon(int value){
        if(this.listePokemeon.size() >= value){
            this.mainPokemon = value; 
        }else {
            System.out.print("input invalide");
        }
    }   

    public void changeMainPokemon(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("veuillez taper le n° correspondant au pokemon que vous souhaiter définir comme principale");
        for(int i=1; i != this.listePokemeon.size(); i++){
            System.out.print("i: " + this.listePokemeon.get(i - 1).getSurnom());
        }
        int value = myObj.nextInt();
        myObj.close();
        this.setMainPokemon(value);
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
