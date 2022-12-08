import java.util.ArrayList;
public class SystemCombat {
    private final double[][] tableType=
    {
        {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,-0.5,0.0,1.0,1.0,-0.5},
        {1.0,-0.5,-0.5,2.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0,2.0,-0.5,1.0,-0.5,1.0,2.0},
        {1.0,2.0,-0.5,-0.5,1.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,2.0,1.0,-0.5,1.0,1.0},
        {1.0,-0.5,2.0,-0.5,1.0,1.0,1.0,-0.5,2.0,-0.5,1.0,-0.5,2.0,1.0,-0.5,1.0,-0.5},
        {1.0,1.0,2.0,-0.5,-0.5,1.0,1.0,1.0,0.0,2.0,1.0,1.0,1.0,1.0,-0.5,1.0,1.0},
        {1.0,-0.5,-0.5,2.0,1.0,-0.5,1.0,1.0,2.0,2.0,1.0,1.0,1.0,1.0,2.0,1.0,-0.5},
        {2.0,1.0,1.0,1.0,1.0,2.0,1.0,-0.5,1.0,-0.5,-0.5,-0.5,2.0,0.0,1.0,2.0,2.0},
        {1.0,1.0,1.0,2.0,1.0,1.0,1.0,-0.5,-0.5,1.0,1.0,1.0,-0.5,-0.5,1.0,1.0,0.0},
        {1.0,2.0,1.0,-0.5,2.0,1.0,1.0,2.0,1.0,0.0,1.0,-0.5,2.0,1.0,1.0,1.0,2.0},
        {1.0,1.0,1.0,2.0,-0.5,1.0,2.0,1.0,1.0,1.0,1.0,2.0,-0.5,1.0,1.0,1.0,-0.5},
        {1.0,1.0,1.0,1.0,1.0,1.0,2.0,2.0,1.0,1.0,-0.5,1.0,1.0,1.0,1.0,0.0,-0.5},
        {1.0,-0.5,1.0,2.0,1.0,1.0,-0.5,-0.5,1.0,-0.5,2.0,1.0,1.0,-0.5,1.0,2.0,-0.5},
        {1.0,2.0,1.0,1.0,1.0,2.0,-0.5,1.0,-0.5,2.0,1.0,2.0,1.0,1.0,1.0,1.0,-0.5},
        {0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0,2.0,1.0,-0.5,-0.5},
        {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,-0.5},
        {1.0,1.0,1.0,1.0,1.0,1.0,-0.5,1.0,1.0,1.0,2.0,1.0,1.0,2.0,1.0,-0.5,-0.5},
        {1.0,-0.5,-0.5,1.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0,1.0,-0.5}
    };
    private ArrayList <int> type_att=new ArrayList(2);
    private ArrayList <int> type_def=new ArrayList(2);


    public int getNum(String type){
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

    public double[][] getTableType() {
        return tableType;
    }

    public void attack(Pokemon att,Pokemon def){
        for(int i=0;i<att.getType().size();i++){

        }
    }

}
