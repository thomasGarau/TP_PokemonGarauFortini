import java.io.Serializable;
import java.util.*;

//dresseur est la classe representant le joueur.
//on implemente serializable pour pouvoir le savegarder
public class Dresseur implements Serializable {
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
    //on fait un hashmap pour associer un bonbon a un pokemon
    private HashMap<String, Integer> bonbonPokemon = new HashMap<String, Integer>();
    private int nbPokeball = 0;

    public Dresseur(String pseudo, int sexe, Pokemon starter){
        this.pseudo = pseudo;
        switch(sexe){
            case 1:
                this.sexe="homme";
                break;
            default:
                this.sexe="femme";
                break;
        }
        this.listePokemeon.add(starter);
        this.nbPokemon++;
        //on assigne le starter en pokemon principal
        setMainPokemon(0);
    }

    public HashMap<String, Integer> getBonbonPokemon(){
        return this.bonbonPokemon;
    }

    //utiliser lors des consomation de bonbon (évolution ou monter de niveau)
    public void removeBonbonPokemon(String nom){
        System.out.println(nom);
        this.bonbonPokemon.put(nom, this.bonbonPokemon.get(nom) -5);
    }

    public int getNbPokeball(){
        return this.nbPokeball;
    }

    public void addPokeball(){
        this.nbPokeball += 20;
    }

    public void throwPokeball(){
        this.nbPokeball --;
    }

    public ArrayList<Pokemon> getListePokemon(){
        return this.listePokemeon;
    }

    public void winCombat(){
        this.victoire ++;
    }

    public void looseCombat(){
        this.defaite ++;
    }

    public String getPseudo(){
        return this.pseudo;
    }

    public String getSexe() {
        return sexe;
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

    //permet de changer le pokemon qui sera un en premiere position
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

    //permet de renommer un pokemon qui vient d'etre capturé
    public void capturePokemon(Pokemon pokemon){
        Scanner myObj = new Scanner(System.in);
        System.out.println("quelle nom souhaiter vous donner a votre " + pokemon.getNom() + "?");
        String surnom = myObj.nextLine();
        pokemon.setSurnom(surnom);
        this.listePokemeon.add(pokemon);
        this.nbPokemon ++;
        addBonbon(pokemon.getNom());
       
    }

    public void addBonbon(String nomPokemon){
        if(this.bonbonPokemon.containsKey(nomPokemon)){
            bonbonPokemon.put(nomPokemon, bonbonPokemon.get(nomPokemon) +1);
        }else{
            bonbonPokemon.put(nomPokemon, 1);
        }
    }

    @Override
    public String toString(){
        int winrate = this.getWinrate();
        String a = "";
        String b = this.listePokemeon.get(this.mainPokemon).getNom();
        for(int i=0; i< listePokemeon.size(); i++){
            a+= listePokemeon.get(i) + ", ";
        }
        return (
            "Nom: "+this.pseudo+"\npossède: "+this.nbPokemon+" Pokemon\n"+a+
            "\na gagné: "+this.victoire+" combat dans l'arène\n"+
            "a perdu: "+this.defaite+"\nwinrate de "+winrate+"%\n"+
            "a pour pokemon principal " + b
        );
    }
}
