import java.util.*;
import java.math.*;
public class SystemCombat {
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
   
    private static ArrayList <Integer> type_def=new ArrayList(2);

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
        else {
            return 16;
        }    
    }

    public static double[][] getTableType() {
        return tableType;
    }

    //attack et utilisé par les dresseur ils choisissent leur attack est le calcule de dégat et effectué 
    public static double attack(Pokemon att,Pokemon def){
        Scanner input3 = new Scanner(System.in);
        System.out.println("choisir un competence:");
        System.out.print(att.getCompetences());
        int input = input3.nextInt();
        ArrayList <Integer> type_def=new ArrayList(2);
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

    // attackAuto est utilisé par les pokemon sauvage il effectue des attack au hasard dans leur liste de compétence
    public static double attackAuto(Pokemon att,Pokemon def){
        Random r =new Random();
        int input = r.nextInt(att.getCompetence().size());
        ArrayList <Integer> type_def=new ArrayList(2);
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

    public static int attackOnline(Pokemon pokemon, String type1, String type2){
        Scanner input3 = new Scanner(System.in);
        System.out.println("choisir un competence:");
        System.out.print(pokemon.getCompetences());
        int input = input3.nextInt();
        ArrayList <Integer> type_def=new ArrayList(2);
        int choix=getNum(pokemon.getCompetences().get(input -1).getType());
        type_def.add(getNum(type1));
        if(type2 != "none"){
            type_def.add(getNum(type2));
        }
        System.out.println("type1 "+ type1 + " type2 " + type2);
        System.out.println(type_def);
        if(type_def.size()==1){
            System.out.println("Systeme combat calcule degat 1");
            return (int) Math.round(pokemon.getpc()*(tableType[choix][type_def.get(0)])); 
         }
         else{
            System.out.println("Systeme combat calcule dégat 2");
             return (int) Math.round(pokemon.getpc()*(tableType[choix][type_def.get(0)]*tableType[choix][type_def.get(1)]));
         }
    }

}
