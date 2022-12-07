import java.io.ObjectInputStream.GetField;

public class Pokemon {
    private String nom;
    private int PC;
    private int PV;
    private Type[] type;
    private int stade_evo=1;
    private final int EVO_MAX;
    private String[] next_evo;

    public Pokemon(String nom,int PC,int PV,Type[] type,int stade_evo,int EVO_MAX,String[] next_evo){
        this.EVO_MAX=EVO_MAX;
        this.next_evo=next_evo;
        this.stade_evo=stade_evo;
        this.PC=PC;
        this.PV=PV;
        this.type=type;
        this.nom=nom;
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

    public Type[] getType() {
        return type;
    }

    public String[] getNext_evo() {
        return next_evo;
    }

    public void evoluer(){
        if(getStade_evo()<getEVO_MAX()){
            stade_evo+=1;
            nom=getNom()[0];
        }
    }
    
}
