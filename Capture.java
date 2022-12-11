import java.util.*;
public class Capture {
    private Pokemon pokemon;
    private Dresseur dresseur;
    private double pokemonSauvageHp;
    private double pokemonDresseurHp;

    public Capture(Dresseur dresseur){
        this.dresseur = dresseur;
        Random r =new Random();
        int a  = r.nextInt(3);
        // le dresseur a une chance sur trois de tomber un pokemon
        if (a > 2){
            int i = 1 + r.nextInt(Pokedex.getPokedex().size());
            createPokemon(dresseur, Pokedex.getPokedex().get(i));
            this.pokemonDresseurHp = dresseur.getMainPokemon().getpv();
            combat();
        }
    }

    public void createPokemon(Dresseur dresseur, Pokemon pokemon){
        this.pokemon = new Pokemon(pokemon, dresseur);
        this.pokemonSauvageHp = pokemon.getpv();
    }

    public void combat(){
        System.out.print("vous avez trouvé un " + this.pokemon.getNom() + "qui a " + this.pokemon.getpv() + " pv");
        while (true){
            System.out.println("que shouaiter vous faire ? Taper 1: pour attaquer, 2: pour lancer une pokeball, 3: pour fuire");
            Scanner myObj = new Scanner(System.in);
            int choix = myObj.nextInt();
            if(choix == 1){
                double resultat = SystemCombat.attack(dresseur.getMainPokemon(), pokemon);
                this.pokemonSauvageHp -= resultat;
                if(pokemonSauvageHp < 1){
                    System.out.print("le pokemon est mort dans d'attrauce souffrance");
                    return;
                } 
                System.out.print("pv restant du pokemon sauvage : " this.pokemonSauvageHp);
                resultat = SystemCombat.attackAuto(pokemon, dresseur.getMainPokemon());
                this.pokemonDresseurHp -= resultat;
                if (pokemonDresseurHp < 1){
                    System.out.print("les PV de votre pokemon on atteint 0 vous avez perdu ");
                    return;
                }
                System.out.print("pv restant de votre pokemon : " + this.pokemonDresseurHp);
            }
            if(choix == 2){

            }
        }
    }
    
}
