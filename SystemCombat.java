import java.util.*;

public class SystemCombat {
    //chaque ligne et colonne represente un type
    //1 pour pas d'effet ,0.5 resistance,2 super efficace
    private final static double[][] tableType=
    {
        {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.5,0.0,1.0,1.0,0.5},
        {1.0,0.5,0.5,2.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0,2.0,0.5,1.0,0.5,1.0,2.0},
        {1.0,2.0,0.5,0.5,1.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,2.0,1.0,0.5,1.0,1.0},
        {1.0,0.5,2.0,0.5,1.0,1.0,1.0,0.5,2.0,0.5,1.0,0.5,2.0,1.0,0.5,1.0,0.5},
        {1.0,1.0,2.0,0.5,0.5,1.0,1.0,1.0,0.0,2.0,1.0,1.0,1.0,1.0,0.5,1.0,1.0},
        {1.0,0.5,0.5,2.0,1.0,0.5,1.0,1.0,2.0,2.0,1.0,1.0,1.0,1.0,2.0,1.0,0.5},
        {2.0,1.0,1.0,1.0,1.0,2.0,1.0,0.5,1.0,0.5,0.5,0.5,2.0,0.0,1.0,2.0,2.0},
        {1.0,1.0,1.0,2.0,1.0,1.0,1.0,0.5,0.5,1.0,1.0,1.0,0.5,0.5,1.0,1.0,0.0},
        {1.0,2.0,1.0,0.5,2.0,1.0,1.0,2.0,1.0,0.0,1.0,0.5,2.0,1.0,1.0,1.0,2.0},
        {1.0,1.0,1.0,2.0,0.5,1.0,2.0,1.0,1.0,1.0,1.0,2.0,0.5,1.0,1.0,1.0,0.5},
        {1.0,1.0,1.0,1.0,1.0,1.0,2.0,2.0,1.0,1.0,0.5,1.0,1.0,1.0,1.0,0.0,0.5},
        {1.0,0.5,1.0,2.0,1.0,1.0,0.5,0.5,1.0,0.5,2.0,1.0,1.0,0.5,1.0,2.0,0.5},
        {1.0,2.0,1.0,1.0,1.0,2.0,0.5,1.0,0.5,2.0,1.0,2.0,1.0,1.0,1.0,1.0,0.5},
        {0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0,2.0,1.0,0.5,0.5},
        {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,0.5},
        {1.0,1.0,1.0,1.0,1.0,1.0,0.5,1.0,1.0,1.0,2.0,1.0,1.0,2.0,1.0,0.5,0.5},
        {1.0,0.5,0.5,1.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,0.5}
    };
   
    private static ArrayList <Integer> type_def=new ArrayList<Integer>(2);

    //on asssocie chaque type à un numero pour acceder à 
    //la matrice des resistances
    public static int getNum(String type){
        if(type.equals("normal")){
            return 0;
        }
        else if(type.equals("feu")){
            return 1;
        }
        else if(type.equals("eau")){
            return 2;
        }
        else if(type.equals("plante")){
            return 3;
        }
        else if(type.equals("électrick")){
            return 4;
        }
        else if(type.endsWith("glace")){
            return 5;
        }
        else if(type.equals("combat")){
            return 6;
        }
        else if(type.equals("poison")){
            return 7;
        }
        else if(type.equals("sol")){
            return 8;
        }
        else if(type.equals("vol")){
            return 9;
        }
        else if(type.equals("psy")){
            return 10;
        }
        else if(type.equals("insecte")){
            return 11;
        }
        else if(type.equals("roche")){
            return 12;
        }
        else if(type.equals("spectre")){
            return 13;
        }
        else if(type.equals("dragon")){
            return 14;
        }
        else if(type.equals("ténèbres")){
            return 15;
        }
        //type acier
        else {
            return 16;
        }    
    }

    public static double[][] getTableType() {
        return tableType;
    }

    public static ArrayList<Integer> getType_def() {
        return type_def;
    }

    //attack est utilisée par les dresseurs, ils choisissent leur attack et le calcul de dégat est effectué 
    public static double attack(Pokemon att,Pokemon def){
        Scanner input3 = new Scanner(System.in);
        System.out.println("choisir un competence: ");
        System.out.print(att.getCompetences());
        int input = input3.nextInt();
        //input3.close();
        ArrayList <Integer> type_def=new ArrayList<Integer>(2);
        int choix=getNum(att.getCompetences().get(input -1).getType());
        for(int i=0;i<def.getType().size();i++){
            type_def.add(getNum(def.getType().get(i)));
        }
        if(type_def.size()==1){
           return att.getpc()*(tableType[choix][type_def.get(0)]); 
        }
        else{
            return att.getpc()*(tableType[choix][type_def.get(0)]*tableType[choix][type_def.get(1)]);
        }
        
    }

    // attackAuto est utilisé par les pokemon sauvage ils effectuent des attack au hasard dans leur liste de compétence
    public static double attackAuto(Pokemon att,Pokemon def){
        Random r =new Random();
        int input = r.nextInt(att.getCompetence().size());
        ArrayList <Integer> type_def=new ArrayList<Integer>(2);
        int choix=getNum(att.getCompetences().get(input).getType());
        for(int i=0;i<def.getType().size();i++){
            type_def.add(getNum(def.getType().get(i)));
        }
        if(type_def.size()==1){
           return att.getpc()*(tableType[choix][type_def.get(0)]); 
        }
        else{
            return att.getpc()*(tableType[choix][type_def.get(0)]*tableType[choix][type_def.get(1)]);
        }
    }

    //attackOnline fonctionne en acceptant en paramètre uniquement des string afin de simplifier les échanges réseaux
    //uniquement utilisé lors des combats dans l'arène
    public static int attackOnline(Pokemon pokemon, String type1, String type2){
        Scanner input3 = new Scanner(System.in);
        System.out.println("choisir un competence: ");
        System.out.print(pokemon.getCompetences());
        int input = input3.nextInt();
        ArrayList <Integer> type_def=new ArrayList<Integer>(2);
        int choix=getNum(pokemon.getCompetences().get(input -1).getType());
        type_def.add(getNum(type1));
        if(type2 != "none"){
            type_def.add(getNum(type2));
        }
        if(type_def.size()==1){
            return (int) Math.round(pokemon.getpc()*(tableType[choix][type_def.get(0)])); 
         }
         else{
            return (int) Math.round(pokemon.getpc()*(tableType[choix][type_def.get(0)]*tableType[choix][type_def.get(1)]));
         }
    }

}
