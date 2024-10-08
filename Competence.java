import java.io.Serializable;

//les competences sont les attaques des pokemon.
//on implémente serializable pour pouvoir les sauvegarder
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
