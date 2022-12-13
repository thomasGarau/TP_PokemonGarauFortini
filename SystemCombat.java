import java.util.*;
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
        if(type=="normal"){
            return 0;
        }
        else if(type=="feu"){
            return 1;
        }
        else if(type=="eau"){
            return 2;
        }
        else if(type=="plante"){
            return 3;
        }
        else if(type=="électrick"){
            return 4;
        }
        else if(type=="glace"){
            return 5;
        }
        else if(type=="combat"){
            return 6;
        }
        else if(type=="poison"){
            return 7;
        }
        else if(type=="sol"){
            return 8;
        }
        else if(type=="vol"){
            return 9;
        }
        else if(type=="psy"){
            return 10;
        }
        else if(type=="insecte"){
            return 11;
        }
        else if(type=="roche"){
            return 12;
        }
        else if(type=="spectre"){
            return 13;
        }
        else if(type=="dragon"){
            return 14;
        }
        else if(type=="ténèbres"){
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


    public static void combat(Pokemon un ,Pokemon deux){
        float pv1=un.getpv();
        float pv2=deux.getpv();
        while(pv1>0.0 || pv2>0.0){
            pv2-=attack(un, deux);
            pv1-=attack(deux, un);
        }
        if(pv1<0){
            System.out.println("victoire "+deux.getNom());
        }
        else{
            System.out.println("victoire "+un.getNom());
        }
    }

    public static void combatLigne(Pokemon un ,Pokemon deux){
        float pv1=un.getpv();
        float pv2=deux.getpv();
        while(pv1>0.0 || pv2>0.0){
            pv2-=attack(un, deux);
            pv1-=attack(deux, un);
        }
        if(pv1<0){
            System.out.println("victoire "+deux.getNom());
        }
        else{
            System.out.println("victoire "+un.getNom());
        }
    }
}
