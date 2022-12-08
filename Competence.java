public class Competence {
    private String nom;
    private String type;

    public Competence(String nom,String type){
        this.nom=nom;
        this.type=type;
    }

    public Competence(Competence competence){
        this.nom = competence.getNom();
        this.type = competence.getType();
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

}
