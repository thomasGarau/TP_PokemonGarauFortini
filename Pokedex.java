import java.util.*;

public class Pokedex {
    private static ArrayList<Pokemon> pokedex;
    
    private static ArrayList<Competence> listeCompetence;
    
    public Pokedex(){
        //initialise tout les "moules" d'instance de pokemon
        //comprend la liste des 151 premier pokemon à l'exception d'aquali pyroli voltali
        Pokemon pokemon1 = new Pokemon("bulbizarre", new ArrayList<String>(Arrays.asList("plante","poison")), 3, new ArrayList<String>(Arrays.asList("herbizarre","florizarre")));
        Pokemon pokemon2 = new Pokemon("salameche", new ArrayList<String>(Arrays.asList("feu")), 3, new ArrayList<String>(Arrays.asList("reptincel","dracaufeu")), new ArrayList<String>(Arrays.asList("3", "feu", "vol")));
        Pokemon pokemon3 = new Pokemon("carapuce", new ArrayList<String>(Arrays.asList("eau")) , 3, new ArrayList<String>(Arrays.asList("carabaffe","tortank")));
        Pokemon pokemon4 = new Pokemon("chenipan", new ArrayList<String>(Arrays.asList("insecte")) , 3, new ArrayList<String>(Arrays.asList("chrysacier", "papilusion")), new ArrayList<String>(Arrays.asList("3","insecte", "vol")));
        Pokemon pokemon5 = new Pokemon("aspicot", new ArrayList<String>(Arrays.asList("insecte", "poison")) , 3, new ArrayList<String>(Arrays.asList("coconfort","dardargnan")));
        Pokemon pokemon6 = new Pokemon ("roucoul", new ArrayList<String>(Arrays.asList("normal", "vol")) , 3, new ArrayList<String>(Arrays.asList("roucoups","roucournage")));
        Pokemon pokemon7 = new Pokemon("rattata", new ArrayList<String>(Arrays.asList("normale")) , 3, new ArrayList<String>(Arrays.asList("rattatac")));
        Pokemon pokemon8 = new Pokemon("piafebec", new ArrayList<String>(Arrays.asList("normal", "vol")) , 3, new ArrayList<String>(Arrays.asList("rapasdepic")));
        Pokemon pokemon9 = new Pokemon("abo", new ArrayList<String>(Arrays.asList("poison")) , 3, new ArrayList<String>(Arrays.asList("arbok")));
        Pokemon pokemon10 = new Pokemon("pikachu", new ArrayList<String>(Arrays.asList("electrik")) , 3, new ArrayList<String>(Arrays.asList("raichu")));
        Pokemon pokemon11 = new Pokemon("sabelette", new ArrayList<String>(Arrays.asList("sol")) , 3, new ArrayList<String>(Arrays.asList("sablaireau")));
        Pokemon pokemon12 = new Pokemon("nidoran", new ArrayList<String>(Arrays.asList("poison")) , 3, new ArrayList<String>(Arrays.asList("nidorina", "nidoqueen")), new ArrayList<String>(Arrays.asList("3","poison", "sol")));
        Pokemon pokemon13 = new Pokemon("melofee", new ArrayList<String>(Arrays.asList("normal")) , 3, new ArrayList<String>(Arrays.asList("melodelfe")));
        Pokemon pokemon14 = new Pokemon("goupix", new ArrayList<String>(Arrays.asList("feu")) , 3, new ArrayList<String>(Arrays.asList("feunard")));
        Pokemon pokemon15 = new Pokemon("rondoudou", new ArrayList<String>(Arrays.asList("normal")) , 3, new ArrayList<String>(Arrays.asList("grodoudou")));
        Pokemon pokemon16 = new Pokemon("nosferapti", new ArrayList<String>(Arrays.asList("poison", "vol")) , 3, new ArrayList<String>(Arrays.asList("nosferalto")));
        Pokemon pokemon17 = new Pokemon("mystherbe", new ArrayList<String>(Arrays.asList("plante", "poison")) , 3, new ArrayList<String>(Arrays.asList("ortide, rafflesia")));
        Pokemon pokemon18 = new Pokemon("paras", new ArrayList<String>(Arrays.asList("insecte", "plante")) , 3, new ArrayList<String>(Arrays.asList("parasect")));
        Pokemon pokemon19 = new Pokemon("mimitoss", new ArrayList<String>(Arrays.asList("insecte", "poison")) , 3, new ArrayList<String>(Arrays.asList("aeromite")));
        Pokemon pokemon20 = new Pokemon("taupiqueur", new ArrayList<String>(Arrays.asList("sol")) , 3, new ArrayList<String>(Arrays.asList("triopikeur")));
        Pokemon pokemon21 = new Pokemon("miaouss", new ArrayList<String>(Arrays.asList("normal")) , 3, new ArrayList<String>(Arrays.asList("persian")));
        Pokemon pokemon22 = new Pokemon("psykokwak", new ArrayList<String>(Arrays.asList("eau")) , 3, new ArrayList<String>(Arrays.asList("akwakwak")));
        Pokemon pokemon23 = new Pokemon("ferosinge", new ArrayList<String>(Arrays.asList("combat")) , 3, new ArrayList<String>(Arrays.asList("colossinge")));
        Pokemon pokemon24 = new Pokemon("caninos", new ArrayList<String>(Arrays.asList("feu")) , 3, new ArrayList<String>(Arrays.asList("arcanin")));
        Pokemon pokemon25 = new Pokemon("pittard", new ArrayList<String>(Arrays.asList("eau")) , 3, new ArrayList<String>(Arrays.asList("tetarte", "tartard")));
        Pokemon pokemon26 = new Pokemon("abra", new ArrayList<String>(Arrays.asList("psy")) , 3, new ArrayList<String>(Arrays.asList("kadabra", "alakazam")));
        Pokemon pokemon27 = new Pokemon("machoc", new ArrayList<String>(Arrays.asList("combat")) , 3, new ArrayList<String>(Arrays.asList("machopeur", "mackogneur")));
        Pokemon pokemon28 = new Pokemon("chetiflor", new ArrayList<String>(Arrays.asList("plante", "poison")) , 3, new ArrayList<String>(Arrays.asList("boustiflor", "empiflor")));
        Pokemon pokemon29 = new Pokemon("tentacool", new ArrayList<String>(Arrays.asList("eau", "poison")) , 3, new ArrayList<String>(Arrays.asList("tentacruel")));
        Pokemon pokemon30 = new Pokemon("racaillou", new ArrayList<String>(Arrays.asList("roche", "sol")) , 3, new ArrayList<String>(Arrays.asList("gravalanch", "grolem")));
        Pokemon pokemon31 = new Pokemon("ponyta", new ArrayList<String>(Arrays.asList("feu")) , 3, new ArrayList<String>(Arrays.asList("galopa")));
        Pokemon pokemon32 = new Pokemon("ramoloss", new ArrayList<String>(Arrays.asList("eau", "psy")) , 3, new ArrayList<String>(Arrays.asList("flagadoss")));
        Pokemon pokemon33 = new Pokemon("magneti", new ArrayList<String>(Arrays.asList("electrik", "acier")) , 3, new ArrayList<String>(Arrays.asList("magneton")));
        Pokemon pokemon34 = new Pokemon("canarticho", new ArrayList<String>(Arrays.asList("normal", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon35 = new Pokemon("doduo", new ArrayList<String>(Arrays.asList("normal", "vol")) , 3, new ArrayList<String>(Arrays.asList("dodrio")));
        Pokemon pokemon36 = new Pokemon("otaria", new ArrayList<String>(Arrays.asList("eau")) , 3, new ArrayList<String>(Arrays.asList("lamantine")), new ArrayList<String>(Arrays.asList("2","glace", "eau")));
        Pokemon pokemon37 = new Pokemon("tadmorv", new ArrayList<String>(Arrays.asList("poison")) , 3, new ArrayList<String>(Arrays.asList("grotadmorv")));
        Pokemon pokemon38 = new Pokemon("kokiyas", new ArrayList<String>(Arrays.asList("eau")) , 3, new ArrayList<String>(Arrays.asList("crustabri")), new ArrayList<String>(Arrays.asList("2","glace", "eau")));
        Pokemon pokemon39 = new Pokemon("fantominus", new ArrayList<String>(Arrays.asList("spectre","poison")) , 3, new ArrayList<String>(Arrays.asList("spectrum", "ectoplasma")));
        Pokemon pokemon40 = new Pokemon("onix", new ArrayList<String>(Arrays.asList("roche", "sol")) , 3, new ArrayList<String>());
        Pokemon pokemon41 = new Pokemon("soporifik", new ArrayList<String>(Arrays.asList("psy")) , 3, new ArrayList<String>(Arrays.asList("hypnomade")));
        Pokemon pokemon42 = new Pokemon("krabby", new ArrayList<String>(Arrays.asList("eau")) , 3, new ArrayList<String>(Arrays.asList("krabboss")));
        Pokemon pokemon43 = new Pokemon("voltorbe", new ArrayList<String>(Arrays.asList("electrik")) , 3, new ArrayList<String>(Arrays.asList("electrode")));
        Pokemon pokemon44 = new Pokemon("noeunoeuf", new ArrayList<String>(Arrays.asList("plante", "psy")) , 3, new ArrayList<String>(Arrays.asList("noadkoko")));
        Pokemon pokemon45 = new Pokemon("osselait", new ArrayList<String>(Arrays.asList("sol")) , 3, new ArrayList<String>(Arrays.asList("ossatueur")));
        Pokemon pokemon46 = new Pokemon("kicklee", new ArrayList<String>(Arrays.asList("combat")) , 3, new ArrayList<String>(Arrays.asList("tygnon")));
        Pokemon pokemon47 = new Pokemon("excelangue", new ArrayList<String>(Arrays.asList("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon48 = new Pokemon("smogo", new ArrayList<String>(Arrays.asList("poison")) , 3, new ArrayList<String>(Arrays.asList("smogogo")));
        Pokemon pokemon49 = new Pokemon("rhinocorne", new ArrayList<String>(Arrays.asList("roche", "sol")) , 3, new ArrayList<String>(Arrays.asList("rhinoferos")));
        Pokemon pokemon50 = new Pokemon("leveinard", new ArrayList<String>(Arrays.asList("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon51 = new Pokemon("saquedeneu", new ArrayList<String>(Arrays.asList("plante")) , 3, new ArrayList<String>());
        Pokemon pokemon52 = new Pokemon("kangourex", new ArrayList<String>(Arrays.asList("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon53 = new Pokemon("hypotrempe", new ArrayList<String>(Arrays.asList("eau")) , 3, new ArrayList<String>(Arrays.asList("hypocean")));
        Pokemon pokemon54 = new Pokemon("poissirene", new ArrayList<String>(Arrays.asList("eau")) , 3, new ArrayList<String>(Arrays.asList("poissoroy")));
        Pokemon pokemon55 = new Pokemon("stari", new ArrayList<String>(Arrays.asList("eau")) , 3, new ArrayList<String>(Arrays.asList("staross")), new ArrayList<String>(Arrays.asList("2","eau", "psy")));
        Pokemon pokemon56 = new Pokemon("M.mime", new ArrayList<String>(Arrays.asList("normal", "psy")) , 3, new ArrayList<String>());
        Pokemon pokemon57 = new Pokemon("insecateur", new ArrayList<String>(Arrays.asList("insecte", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon58 = new Pokemon("Elektek", new ArrayList<String>(Arrays.asList("elecktrik")) , 3, new ArrayList<String>());
        Pokemon pokemon59 = new Pokemon("magmar", new ArrayList<String>(Arrays.asList("feu")) , 3, new ArrayList<String>());
        Pokemon pokemon60 = new Pokemon("scarabrute", new ArrayList<String>(Arrays.asList("insecte")) , 3, new ArrayList<String>());
        Pokemon pokemon61 = new Pokemon("tauros", new ArrayList<String>(Arrays.asList("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon62 = new Pokemon("magicarpe", new ArrayList<String>(Arrays.asList("eau")) , 3, new ArrayList<String>(Arrays.asList("leviator")), new ArrayList<String>(Arrays.asList("2","eau", "vol")));
        Pokemon pokemon63 = new Pokemon("lokhlass", new ArrayList<String>(Arrays.asList("eau", "glace")) , 3, new ArrayList<String>());
        Pokemon pokemon64 = new Pokemon("metamorph", new ArrayList<String>(Arrays.asList("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon65 = new Pokemon("evoli", new ArrayList<String>(Arrays.asList("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon66 = new Pokemon("porygon", new ArrayList<String>(Arrays.asList("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon67 = new Pokemon("amonita", new ArrayList<String>(Arrays.asList("eau", "roche")) , 3, new ArrayList<String>(Arrays.asList("amonistar")));
        Pokemon pokemon68 = new Pokemon("kabuto", new ArrayList<String>(Arrays.asList("eau", "roche")) , 3, new ArrayList<String>(Arrays.asList("kabutops")));
        Pokemon pokemon69 = new Pokemon("petra", new ArrayList<String>(Arrays.asList("roche", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon70 = new Pokemon("ronflex", new ArrayList<String>(Arrays.asList("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon71 = new Pokemon("artikodin", new ArrayList<String>(Arrays.asList("glace", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon72 = new Pokemon("electhor", new ArrayList<String>(Arrays.asList("electrik", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon73 = new Pokemon("sulfura", new ArrayList<String>(Arrays.asList("feu", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon74 = new Pokemon("minidraco", new ArrayList<String>(Arrays.asList("dragon")) , 3, new ArrayList<String>(Arrays.asList("draco", "dracolosse")));
        Pokemon pokemon75 = new Pokemon("mewtwo", new ArrayList<String>(Arrays.asList("psy")) , 3, new ArrayList<String>());
        Pokemon pokemon76 = new Pokemon("mew", new ArrayList<String>(Arrays.asList("psy")) , 3, new ArrayList<String>());


        //ajoute l'intégralité des pokemon à la liste pokedex
        this.pokedex = new ArrayList<>(Arrays.asList(
            pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, pokemon7, pokemon8, pokemon9, 
            pokemon10, pokemon11, pokemon12, pokemon13, pokemon14, pokemon15, pokemon16, pokemon17, pokemon18, pokemon19,
            pokemon20, pokemon21, pokemon22, pokemon23, pokemon24, pokemon25, pokemon26, pokemon27, pokemon28, pokemon29,
            pokemon30, pokemon31, pokemon32, pokemon33, pokemon34, pokemon35, pokemon36, pokemon37, pokemon38, pokemon39,
            pokemon40, pokemon41, pokemon42, pokemon43, pokemon44, pokemon45, pokemon46, pokemon47, pokemon48, pokemon49,
            pokemon50, pokemon51, pokemon52, pokemon53, pokemon54, pokemon55, pokemon56, pokemon57, pokemon58, pokemon59,
            pokemon60, pokemon61, pokemon62, pokemon63, pokemon64, pokemon65, pokemon66, pokemon67, pokemon68, pokemon69,
            pokemon70, pokemon71, pokemon72, pokemon73, pokemon74, pokemon75, pokemon76
        ));


        //initialise les moule d'instance de compétences (une par type)
        Competence charge=new Competence("charge", "normal");
        Competence flameche=new Competence("flameche", "feu");
        Competence bulles_do=new Competence("bulles'do", "eau");
        Competence tranch_herbe=new Competence("tranch'herbe", "plante");
        Competence eclair=new Competence("éclair", "electrik");
        Competence poing_glace=new Competence("poing glace", "glace");
        Competence balayette=new Competence("balayette", "combat");
        Competence dard_venin=new Competence("dard venin", "poison");
        Competence tunnel=new Competence("tunnel", "sol");
        Competence picpic=new Competence("picpic", "vol");
        Competence psyko=new Competence("psyko", "psy");
        Competence dard_nue=new Competence("dard nuée", "insecte");
        Competence eboulement=new Competence("éboulement", "roche");
        Competence griffe_ombre=new Competence("griffe ombre", "spectre");
        Competence draco_griffe=new Competence("draco-griffe", "dragon");
        Competence machouille=new Competence("machouille", "ténèbres");
        Competence gyroballe=new Competence("gyroballe", "acier");

        //ajoute toute les compétences à la liste de compétence
        this.listeCompetence = new ArrayList<>(Arrays.asList(
            charge, flameche, bulles_do,tranch_herbe, eclair, poing_glace, balayette, dard_venin,tunnel,
            picpic, psyko, dard_nue, eboulement, griffe_ombre, draco_griffe, machouille, gyroballe
        ));
    }

    public static Competence getCompetence(String nom){
        for(int i=0; i < listeCompetence.size(); i++){
            if(listeCompetence.get(i).getNom().equals(nom)){
                return listeCompetence.get(i);
            }
        }
        return null;
    }


}
