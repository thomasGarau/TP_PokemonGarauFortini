import java.util.*;

public class Pokedex {
    private ArrayList<Pokemon> pokedex;
    
    public Pokedex(){
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
        Pokemon pokemon11 = new Pokemon("sabelette", new ArrayList<String>(List.of("sol")) , 3, new ArrayList<String>(List.of("sablaireau")));
        Pokemon pokemon12 = new Pokemon("nidoran", new ArrayList<String>(List.of("poison")) , 3, new ArrayList<String>(List.of("nidorina", "nidoqueen")), new ArrayList<String>(List.of("3","poison", "sol")));
        Pokemon pokemon13 = new Pokemon("melofee", new ArrayList<String>(List.of("normal")) , 3, new ArrayList<String>(List.of("melodelfe")));
        Pokemon pokemon14 = new Pokemon("goupix", new ArrayList<String>(List.of("feu")) , 3, new ArrayList<String>(List.of("feunard")));
        Pokemon pokemon15 = new Pokemon("rondoudou", new ArrayList<String>(List.of("normal")) , 3, new ArrayList<String>(List.of("grodoudou")));
        Pokemon pokemon16 = new Pokemon("nosferapti", new ArrayList<String>(List.of("poison", "vol")) , 3, new ArrayList<String>(List.of("nosferalto")));
        Pokemon pokemon17 = new Pokemon("mystherbe", new ArrayList<String>(List.of("plante", "poison")) , 3, new ArrayList<String>(List.of("ortide, rafflesia")));
        Pokemon pokemon18 = new Pokemon("paras", new ArrayList<String>(List.of("insecte", "plante")) , 3, new ArrayList<String>(List.of("parasect")));
        Pokemon pokemon19 = new Pokemon("mimitoss", new ArrayList<String>(List.of("insecte", "poison")) , 3, new ArrayList<String>(List.of("aeromite")));
        Pokemon pokemon20 = new Pokemon("taupiqueur", new ArrayList<String>(List.of("sol")) , 3, new ArrayList<String>(List.of("triopikeur")));
        Pokemon pokemon21 = new Pokemon("miaouss", new ArrayList<String>(List.of("normal")) , 3, new ArrayList<String>(List.of("persian")));
        Pokemon pokemon22 = new Pokemon("psykokwak", new ArrayList<String>(List.of("eau")) , 3, new ArrayList<String>(List.of("akwakwak")));
        Pokemon pokemon23 = new Pokemon("ferosinge", new ArrayList<String>(List.of("combat")) , 3, new ArrayList<String>(List.of("colossinge")));
        Pokemon pokemon24 = new Pokemon("caninos", new ArrayList<String>(List.of("feu")) , 3, new ArrayList<String>(List.of("arcanin")));
        Pokemon pokemon25 = new Pokemon("pittard", new ArrayList<String>(List.of("eau")) , 3, new ArrayList<String>(List.of("tetarte", "tartard")));
        Pokemon pokemon26 = new Pokemon("abra", new ArrayList<String>(List.of("psy")) , 3, new ArrayList<String>(List.of("kadabra", "alakazam")));
        Pokemon pokemon27 = new Pokemon("machoc", new ArrayList<String>(List.of("combat")) , 3, new ArrayList<String>(List.of("machopeur", "mackogneur")));
        Pokemon pokemon28 = new Pokemon("chetiflor", new ArrayList<String>(List.of("plante", "poison")) , 3, new ArrayList<String>(List.of("boustiflor", "empiflor")));
        Pokemon pokemon29 = new Pokemon("tentacool", new ArrayList<String>(List.of("eau", "poison")) , 3, new ArrayList<String>(List.of("tentacruel")));
        Pokemon pokemon30 = new Pokemon("racaillou", new ArrayList<String>(List.of("roche", "sol")) , 3, new ArrayList<String>(List.of("gravalanch", "grolem")));
        Pokemon pokemon31 = new Pokemon("ponyta", new ArrayList<String>(List.of("feu")) , 3, new ArrayList<String>(List.of("galopa")));
        Pokemon pokemon32 = new Pokemon("ramoloss", new ArrayList<String>(List.of("eau", "psy")) , 3, new ArrayList<String>(List.of("flagadoss")));
        Pokemon pokemon33 = new Pokemon("magneti", new ArrayList<String>(List.of("electrik", "acier")) , 3, new ArrayList<String>(List.of("magneton")));
        Pokemon pokemon34 = new Pokemon("canarticho", new ArrayList<String>(List.of("normal", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon35 = new Pokemon("doduo", new ArrayList<String>(List.of("normal", "vol")) , 3, new ArrayList<String>(List.of("dodrio")));
        Pokemon pokemon36 = new Pokemon("otaria", new ArrayList<String>(List.of("eau")) , 3, new ArrayList<String>(List.of("lamantine")), new ArrayList<String>(List.of("2","glace", "eau")));
        Pokemon pokemon37 = new Pokemon("tadmorv", new ArrayList<String>(List.of("poison")) , 3, new ArrayList<String>(List.of("grotadmorv")));
        Pokemon pokemon38 = new Pokemon("kokiyas", new ArrayList<String>(List.of("eau")) , 3, new ArrayList<String>(List.of("crustabri")), new ArrayList<String>(List.of("2","glace", "eau")));
        Pokemon pokemon39 = new Pokemon("fantominus", new ArrayList<String>(List.of("spectre","poison")) , 3, new ArrayList<String>(List.of("spectrum", "ectoplasma")));
        Pokemon pokemon40 = new Pokemon("onix", new ArrayList<String>(List.of("roche", "sol")) , 3, new ArrayList<String>());
        Pokemon pokemon41 = new Pokemon("soporifik", new ArrayList<String>(List.of("psy")) , 3, new ArrayList<String>(List.of("hypnomade")));
        Pokemon pokemon42 = new Pokemon("krabby", new ArrayList<String>(List.of("eau")) , 3, new ArrayList<String>(List.of("krabboss")));
        Pokemon pokemon43 = new Pokemon("voltorbe", new ArrayList<String>(List.of("electrik")) , 3, new ArrayList<String>(List.of("electrode")));
        Pokemon pokemon44 = new Pokemon("noeunoeuf", new ArrayList<String>(List.of("plante", "psy")) , 3, new ArrayList<String>(List.of("noadkoko")));
        Pokemon pokemon45 = new Pokemon("osselait", new ArrayList<String>(List.of("sol")) , 3, new ArrayList<String>(List.of("ossatueur")));
        Pokemon pokemon46 = new Pokemon("kicklee", new ArrayList<String>(List.of("combat")) , 3, new ArrayList<String>(List.of("tygnon")));
        Pokemon pokemon47 = new Pokemon("excelangue", new ArrayList<String>(List.of("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon48 = new Pokemon("smogo", new ArrayList<String>(List.of("poison")) , 3, new ArrayList<String>(List.of("smogogo")));
        Pokemon pokemon49 = new Pokemon("rhinocorne", new ArrayList<String>(List.of("roche", "sol")) , 3, new ArrayList<String>(List.of("rhinoferos")));
        Pokemon pokemon50 = new Pokemon("leveinard", new ArrayList<String>(List.of("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon51 = new Pokemon("saquedeneu", new ArrayList<String>(List.of("plante")) , 3, new ArrayList<String>());
        Pokemon pokemon52 = new Pokemon("kangourex", new ArrayList<String>(List.of("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon53 = new Pokemon("hypotrempe", new ArrayList<String>(List.of("eau")) , 3, new ArrayList<String>(List.of("hypocean")));
        Pokemon pokemon54 = new Pokemon("poissirene", new ArrayList<String>(List.of("eau")) , 3, new ArrayList<String>(List.of("poissoroy")));
        Pokemon pokemon55 = new Pokemon("stari", new ArrayList<String>(List.of("eau")) , 3, new ArrayList<String>(List.of("staross")), new ArrayList<String>(List.of("2","eau", "psy")));
        Pokemon pokemon56 = new Pokemon("M.mime", new ArrayList<String>(List.of("normal", "psy")) , 3, new ArrayList<String>());
        Pokemon pokemon57 = new Pokemon("insecateur", new ArrayList<String>(List.of("insecte", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon58 = new Pokemon("Elektek", new ArrayList<String>(List.of("elecktrik")) , 3, new ArrayList<String>());
        Pokemon pokemon59 = new Pokemon("magmar", new ArrayList<String>(List.of("feu")) , 3, new ArrayList<String>());
        Pokemon pokemon60 = new Pokemon("scarabrute", new ArrayList<String>(List.of("insecte")) , 3, new ArrayList<String>());
        Pokemon pokemon61 = new Pokemon("tauros", new ArrayList<String>(List.of("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon62 = new Pokemon("magicarpe", new ArrayList<String>(List.of("eau")) , 3, new ArrayList<String>(List.of("leviator")), new ArrayList<String>(List.of("2","eau", "vol")));
        Pokemon pokemon63 = new Pokemon("lokhlass", new ArrayList<String>(List.of("eau", "glace")) , 3, new ArrayList<String>());
        Pokemon pokemon64 = new Pokemon("metamorph", new ArrayList<String>(List.of("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon65 = new Pokemon("evoli", new ArrayList<String>(List.of("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon66 = new Pokemon("porygon", new ArrayList<String>(List.of("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon67 = new Pokemon("amonita", new ArrayList<String>(List.of("eau", "roche")) , 3, new ArrayList<String>(List.of("amonistar")));
        Pokemon pokemon68 = new Pokemon("kabuto", new ArrayList<String>(List.of("eau", "roche")) , 3, new ArrayList<String>(List.of("kabutops")));
        Pokemon pokemon69 = new Pokemon("petra", new ArrayList<String>(List.of("roche", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon70 = new Pokemon("ronflex", new ArrayList<String>(List.of("normal")) , 3, new ArrayList<String>());
        Pokemon pokemon71 = new Pokemon("artikodin", new ArrayList<String>(List.of("glace", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon72 = new Pokemon("electhor", new ArrayList<String>(List.of("electrik", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon73 = new Pokemon("sulfura", new ArrayList<String>(List.of("feu", "vol")) , 3, new ArrayList<String>());
        Pokemon pokemon74 = new Pokemon("minidraco", new ArrayList<String>(List.of("dragon")) , 3, new ArrayList<String>(List.of("draco", "dracolosse")));
        Pokemon pokemon75 = new Pokemon("mewtwo", new ArrayList<String>(List.of("psy")) , 3, new ArrayList<String>());
        Pokemon pokemon76 = new Pokemon("mew", new ArrayList<String>(List.of("psy")) , 3, new ArrayList<String>());



        this.pokedex = new ArrayList<>(List.of(
            pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, pokemon7, pokemon8, pokemon9, 
            pokemon10, pokemon11, pokemon12, pokemon13, pokemon14, pokemon15, pokemon16, pokemon17, pokemon18, pokemon19,
            pokemon20, pokemon21, pokemon22, pokemon23, pokemon24, pokemon25, pokemon26, pokemon27, pokemon28, pokemon29,
            pokemon30, pokemon31, pokemon32, pokemon33, pokemon34, pokemon35, pokemon36, pokemon37, pokemon38, pokemon39,
            pokemon40, pokemon41, pokemon42, pokemon43, pokemon44, pokemon45, pokemon46, pokemon47, pokemon48, pokemon49,
            pokemon50, pokemon51, pokemon52, pokemon53, pokemon54, pokemon55, pokemon56, pokemon57, pokemon58, pokemon59,
            pokemon60, pokemon61, pokemon62, pokemon63, pokemon64, pokemon65, pokemon66, pokemon67, pokemon68, pokemon69,
            pokemon70, pokemon71, pokemon72, pokemon73, pokemon74, pokemon75, pokemon76
        ));
    }


}
