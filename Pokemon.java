import java.util.Random;
import java.util.ArrayList;
public class Pokemon {
    private String nom;
    private int PC;
    private int PV;
    private ArrayList <String> type=new ArrayList<>(2);
    private int stade_evo=1;
    private final int EVO_MAX;
    private ArrayList <String> next_evo=new ArrayList<>(2);
    private ArrayList <String> changement=new ArrayList<>(2);
    private ArrayList <Competence> Competences;
    

    public Pokemon(String nom,ArrayList<String> type,int EVO_MAX,ArrayList<String> next_evo){
        Random r =new Random();
        this.EVO_MAX=EVO_MAX;
        this.next_evo=next_evo;
        this.PC=r.nextInt(5);
        this.PV=r.nextInt(5);
        this.type=type;
        this.nom=nom;
        ArrayList <Competence> competence=new ArrayList<>(4);
        Competence griffe=new Competence("griffe", "normal");
        competence.add(griffe);
    }

    public Pokemon(String nom,ArrayList<String> type,int EVO_MAX,ArrayList<String> next_evo,ArrayList<String> changement){
        this(nom,type,EVO_MAX,next_evo);
        this.changement=changement;
    }

    public int getEVO_MAX() {
        return EVO_MAX;
    }

    public String getNom() {
        return nom;
    }

    public int getPC() {
        return PC;
    }

    public int getPV() {
        return PV;
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
        return Competences;
    }

    public void evoluer(){
        Random r =new Random();
        if(stade_evo<EVO_MAX){
            stade_evo+=1;
            nom=next_evo.get(stade_evo-2);
            PC+=r.nextInt(5);
            PV+=r.nextInt(5);
            if(!(changement.isEmpty())){
                if(stade_evo==Integer.parseInt(changement.get(0))){
                    type.clear();
                    type.add(changement.get(1));
                    type.add(changement.get(2));

                }
                
            }
        }
        else{
            PC+=r.nextInt(5);
            PV+=r.nextInt(5);
        }
    }
    
}
