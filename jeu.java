import java.util.*;
import org.json.simple.*;

public class jeu {
    public static void main(String[] args) { 
        
        JSONObject pokedex = new JSONObject();      

        Pokemon pokemon1 = new Pokemon("bulbizarre", new ArrayList<String>(List.of("plante","poison")), 3, new ArrayList<String>(List.of("herbizarre","florizarre")));
        Pokemon pokemon2 = new Pokemon("salameche", new ArrayList<String>(List.of("feu")), 3, new ArrayList<String>(List.of("reptincel","dracaufeu")), new ArrayList<String>(List.of("3", "feu", "vol")));
        Pokemon pokemon3 = new Pokemon("carapuce", new ArrayList<String>(List.of("eau")) , 3, new ArrayList<String>(List.of("carabaffe","tortank")));
        Pokemon pokemon4 = new Pokemon("chenipan", new ArrayList<String>(List.of("insecte")) , 3, new ArrayList<String>(List.of("chrysacier", "papilusion")), new ArrayList<String>(List.of("3","insecte", "vol")));
        Pokemon pokemon5 = new Pokemon("aspicot", new ArrayList<String>(List.of("insecte", "poison")) , 3, new ArrayList<String>(List.of("coconfort","dardargnan")));
        Pokemon pokemon6 = new Pokemon ("roucoul", new ArrayList<String>(List.of("normal", "vol")) , 3, new ArrayList<String>(List.of("roucoups","roucournage")));
        Pokemon pokemon7 = new Pokemon("rattata", new ArrayList<String>(List.of("normale")) , 3, new ArrayList<String>(List.of("rattatac")));
        Pokemon pokemon8 = new Pokemon("piafebec", new ArrayList<String>(List.of("normal", "vol")) , 3, new ArrayList<String>(List.of("rapasdepic")));
        Pokemon pokemon9 = new Pokemon("abo", new ArrayList<String>(List.of("poison")) , 3, new ArrayList<String>(List.of("arbok")));
        Pokemon pokemon10 = new Pokemon("pikachu", new ArrayList<String>(List.of("electrik")) , 3, new ArrayList<String>(List.of("raichu")));
        



    }
}
