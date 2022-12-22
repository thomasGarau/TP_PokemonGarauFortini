import java.util.Random;
import java.io.Serializable;
import java.util.ArrayList;

public class Pokemon implements Serializable{
    private String nom;
    private int pc;
    private int pv;
    private ArrayList <String> type=new ArrayList<>(2);
    private int stade_evo=1;
    private final int EVO_MAX;
    private ArrayList <String> next_evo=new ArrayList<>(2);
    private ArrayList <String> changement=new ArrayList<>(2);
    private Dresseur dresseur; 
    private ArrayList <Competence> competence = new ArrayList<>(4);
    //le surnom permet de différencier deux exemplaires d'un même pokemon possédé par le dresseur
    private String surnom;    
    

    //constructeur de moule de pokemon
    public Pokemon(String nom,ArrayList<String> type,int EVO_MAX,ArrayList<String> next_evo){
        this.EVO_MAX=EVO_MAX;
        this.next_evo=next_evo;
        this.type=type;
        this.nom=nom;
        Competence griffe=new Competence("griffe", "normal");
        competence.add(griffe);
        if(type.size()==1){
            assignComp(type.get(0));
        }
        else{
            assignComp(type.get(0));
            assignComp(type.get(1));
        }
    }

    //constructeur de moule de pokemon avec changement de type à l'évolution
    public Pokemon(String nom,ArrayList<String> type,int EVO_MAX,ArrayList<String> next_evo,ArrayList<String> changement){
        this(nom,type,EVO_MAX,next_evo);
        this.changement=changement;
    }

    //constructeur d'instance pokemon reel
    //instance réelle posséde des pc et pv. De plus un dresseur leurs sera ajouté.
    public Pokemon(Pokemon pokemon){
        this(pokemon.getNom(), pokemon.getType(), pokemon.getEVO_MAX(), pokemon.getNext_evo(), pokemon.getChangement());
        Random r =new Random();
        //pc compris entre 10 et 30
        this.pc = 10 + r.nextInt(20);
        //pv compris entre 50 et 100
        this.pv = 50 + r.nextInt(50);
    }

    public void setDresseur(Dresseur dresseur){
        this.dresseur = dresseur;
    }

    public String getSurnom(){
        return this.surnom;
    }

    public void setSurnom(String surnom){
        this.surnom = surnom;
    }

    public ArrayList<Competence> getCompetence() {
        return competence;
    }

    public int getEVO_MAX() {
        return EVO_MAX;
    }

    public String getNom() {
        return nom;
    }

    public int getpc() {
        return pc;
    }

    public int getpv() {
        return pv;
    }

    public int getStade_evo() {
        return stade_evo;
    }

    public ArrayList<String> getChangement() {
        return changement;
    }

    public ArrayList<String> getNext_evo() {
        return next_evo;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public ArrayList<Competence> getCompetences() {
        return competence;
    }

    //provoque l'evolution si 5 bonbons ou plus;
    //si l'evo max est atteinte augmente juste les stats; 
    public void evoluer(){
        Random r =new Random();
        if(this.dresseur.getBonbonPokemon().get(this.nom) >= 5){
            // si le pokemon evolue le nom va changer, donc on stock l'ancien nom
            String name = this.nom;
            if(stade_evo<EVO_MAX){
                nom=next_evo.get(stade_evo-1);
                stade_evo+=1;
                //ajoute entre 4 et 7 pv
                pc+= 4 + r.nextInt(3);
                //ajoute entre 12 et 24 hp
                pv+= 12 + r.nextInt(12);
                if(!(changement.isEmpty())){
                    if(stade_evo==Integer.parseInt(changement.get(0))){
                        type.clear();
                        type.add(changement.get(1));
                        type.add(changement.get(2));
                    }
                }
                System.out.println("votre pokemon a évolué ,nouvelle stats:\n");
                System.out.println(this);
            }
            else{
                //ajoute entre 1 et 2 pc
                pc+= 1 + r.nextInt(1);
                //ajoute entre 2 et 5 pv
                pv+= 2 + r.nextInt(3);
                System.out.println("votre pokemon a monté de niveau, nouvelle stats:\n");
                System.out.println(this);
            }
            //retire au dresseur les 5bonbons
            this.dresseur.removeBonbonPokemon(name);
        }else{
            System.out.println("pas assez de bonbon pour faire évoluer ce pokemon ");
        }
    }
    
    //assigne une attaque de base en accord avec le(s) type(s) du pokemon
    //tous les pokemon posséderont une compétence de type normale + une par type possédé
    public void assignComp(String type){

        if(type.equals("normal")){
            Competence charge = new Competence(Pokedex.getCompetence("charge"));
            competence.add(charge);
        }
        else if(type.equals("feu")){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type.equals("plante")){
            Competence tranch_herbe= new Competence(Pokedex.getCompetence("tranch'herbe"));
            competence.add(tranch_herbe);
        }
        else if(type.equals("eau")){
            Competence bulles_do = new Competence(Pokedex.getCompetence("bulles'do"));
            competence.add(bulles_do);
        }
        else if(type.equals("électrik")){
            Competence eclair = new Competence(Pokedex.getCompetence("éclair"));
            competence.add(eclair);
        }
        else if(type.equals("glace")){
            Competence poing_glace = new Competence(Pokedex.getCompetence("poing glace"));
            competence.add(poing_glace);
        }
        else if(type.equals("combat")){
            Competence balayette = new Competence(Pokedex.getCompetence("balayette"));
            competence.add(balayette);
        }
        else if(type.equals("poison")){
            Competence dard_venin = new Competence(Pokedex.getCompetence("dard venin"));
            competence.add(dard_venin);
        }
        else if(type.equals("sol")){
            Competence tunnel = new Competence(Pokedex.getCompetence("tunnel"));
            competence.add(tunnel);
        }
        else if(type.equals("vol")){
            Competence picpic = new Competence(Pokedex.getCompetence("picpic"));
            competence.add(picpic);
        }
        else if(type.equals("psy")){
            Competence psyko = new Competence(Pokedex.getCompetence("psyko"));
            competence.add(psyko);
        }
        else if(type.equals("insecte")){
            Competence dard_nue = new Competence(Pokedex.getCompetence("dard nuée"));
            competence.add(dard_nue);
        }
        else if(type.equals("roche")){
            Competence eboulement = new Competence(Pokedex.getCompetence("éboulement"));
            competence.add(eboulement);
        }
        else if(type.equals("spectre")){
            Competence griffe_ombre = new Competence(Pokedex.getCompetence("griffe ombre"));
            competence.add(griffe_ombre);
        }
        else if(type.equals("dragon")){
            Competence draco_griffe = new Competence(Pokedex.getCompetence("draco-griffe"));
            competence.add(draco_griffe);
        }
        else if(type.equals("ténèbres")){
            Competence machouille = new Competence(Pokedex.getCompetence("machouille"));
            competence.add(machouille);
        }
        else {
            Competence gyroballe = new Competence(Pokedex.getCompetence("gyroballe"));
            competence.add(gyroballe);
        }    
    }

    public String toString(){
        String a = "";
        String b = "";
        String c = "";
        String d = this.dresseur.getPseudo();
        for(int i=0; i< this.type.size(); i++){
            a += type.get(i) + " ";
        }
        for(int i=0; i< this.competence.size(); i++){
            b+="competence "+this.competence.get(i).getNom()+" de type : "+this.competence.get(i).getType() + "; ";

        }
        for(int i=0; i< this.next_evo.size(); i++){
            c += this.next_evo.get(i) + "; ";

        }
    
        return 
            "Nom: "+ this.nom +"\nPc: "+this.pc+"\nPv: "+this.pv+"\nType(s): " + a +"\nStade d'évolution: " 
            +this.stade_evo+"\nProchaine evolution: "+c+"\nDresseur: "+d+"\nCompétence possédé : "+b;
    }
    
}
