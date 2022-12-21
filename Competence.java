import java.io.Serializable;

//les competence sont les attaques des pokemon .
//on implemente serializable pour pouvoir les savegarder
public class Competence implements Serializable{
    private String nom;
    private String type;

    public Competence(String nom,String type){
        this.nom=nom;
        this.type=type;
    }

    public Competence(Competence competence){
        this(competence.getNom(), competence.getType());
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String toString(){
        return "nom: " +this.nom+" type: "+this.type;
    }

}
