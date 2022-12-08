import java.util.Random;
import java.util.ArrayList;
public class Pokemon {
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
    
    

    //constructeur de pokemon moule
    public Pokemon(String nom,ArrayList<String> type,int EVO_MAX,ArrayList<String> next_evo){
        this.EVO_MAX=EVO_MAX;
        this.next_evo=next_evo;
        this.type=type;
        this.nom=nom;
        Competence griffe=new Competence("griffe", "normal");
        competence.add(griffe);
    }

    //constructeur de pokemon moule avec changement de type à l'évolution
    public Pokemon(String nom,ArrayList<String> type,int EVO_MAX,ArrayList<String> next_evo,ArrayList<String> changement){
        this(nom,type,EVO_MAX,next_evo);
        this.changement=changement;
    }

    //constructeur d'instance pokemon reel
    public Pokemon(Pokemon pokemon, Dresseur dresseur){
        Random r =new Random();
        this.nom = pokemon.getNom();
        this.type = pokemon.getType();
        this.EVO_MAX = pokemon.getEVO_MAX();
        this.next_evo = pokemon.getNext_evo();
        this.competence = pokemon.getCompetence();
        this.pc = 10 + r.nextInt(20);
        this.pv = 50 + r.nextInt(50);
        this.dresseur = dresseur;
        Competence griffe=new Competence("griffe", "normal");
        this.competence.add(griffe);  
    }

    //constructeur d'instance pokemon reel avec changement de type à l'évolution
    public Pokemon(Pokemon pokemon, Dresseur dresseur, ArrayList<String> changement){
        this(pokemon, dresseur);
        this.changement = changement;
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

    public void evoluer(){
        Random r =new Random();
        if(stade_evo<EVO_MAX){
            stade_evo+=1;
            nom=next_evo.get(stade_evo-2);
            pc+= 4 + r.nextInt(3);
            pv+= 12 + r.nextInt(12);
            if(!(changement.isEmpty())){
                if(stade_evo==Integer.parseInt(changement.get(0))){
                    type.clear();
                    type.add(changement.get(1));
                    type.add(changement.get(2));

                }
                
            }
        }
        else{
            pc+= 1 + r.nextInt(1);
            pv+= 2 + r.nextInt(3);
        }
    }

    public void assignComp(String type){

        if(type=="normal"){
            Competence charge = new Competence(Pokedex.getCompetence("charge"));
            competence.add(charge);
        }
        else if(type=="feu"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="plante"){
            Competence tranch_herbe= new Competence(Pokedex.getCompetence("tranch'herbe"));
            competence.add(tranch_herbe);
        }
        else if(type=="eau"){
            Competence bulles_do = new Competence(Pokedex.getCompetence("bulles'do"));
            competence.add(bulles_do);
        }
        else if(type=="électrick"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="glace"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="combat"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="poison"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="sol"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="vol"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="psy"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="insecte"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="roche"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="spectre"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="dragon"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else if(type=="ténèbres"){
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }
        else {
            Competence flameche = new Competence(Pokedex.getCompetence("flameche"));
            competence.add(flameche);
        }    
    }
    
}
