import java.net.SocketTimeoutException;
import java.rmi.StubNotFoundException;
import java.util.*;
public class Capture {
    private Pokemon pokemon;
    private Dresseur dresseur;
    private double pokemonSauvageHp;
    private double pokemonSauvageHpMax;
    private double pokemonDresseurHp;

    public Capture(Dresseur dresseur){
        this.dresseur = dresseur;
        Random r =new Random();
        int a  = r.nextInt(3);
        System.out.print(a);
        // le dresseur a une chance sur trois de tomber un pokemon
        if (a > 1){
            int i = 1 + r.nextInt(Pokedex.getPokedex().size());
            createPokemon(dresseur, Pokedex.getPokedex().get(i));
            this.pokemonDresseurHp = dresseur.getMainPokemon().getpv();
            combat();
        }else{
            System.out.print("Vous n'avez rien trouvé");
        }
    }

    public void createPokemon(Dresseur dresseur, Pokemon pokemon){
        this.pokemon = new Pokemon(pokemon);
        this.pokemonSauvageHp = this.pokemon.getpv();
        this.pokemonSauvageHpMax = this.pokemon.getpv();
    }

    public void combat(){
        System.out.print("vous avez trouvé un " + this.pokemon.getNom() + "qui a " + this.pokemon.getpv() + " pv");
        Random r =new Random();
        Scanner input2 = new Scanner(System.in);
        String choix = "0";

        while (true){            
            System.out.println("que shouaiter vous faire ? Taper 1: pour attaquer, 2: pour lancer une pokeball, 3: pour fuire ");
            choix = input2.nextLine();
            System.out.println("choix" + choix);
            
            if(choix.equals("1")){
                System.out.println("bonjour");
                double resultat = SystemCombat.attack(dresseur.getMainPokemon(), pokemon);
                System.out.println(resultat);
                System.out.println(pokemonSauvageHp);
                this.pokemonSauvageHp -= resultat;
                if(pokemonSauvageHp < 1){
                    System.out.print("le pokemon est mort dans d'atroce souffrance ");
                    this.pokemon = null;
                    return;
                } 
                System.out.print("pv restant du pokemon sauvage : " + this.pokemonSauvageHp);
                resultat = SystemCombat.attackAuto(pokemon, dresseur.getMainPokemon());
                this.pokemonDresseurHp -= resultat;
                if (pokemonDresseurHp < 1){
                    System.out.print("les PV de votre pokemon on atteint 0 vous avez perdu ");
                    return;
                }
                System.out.print("pv restant de votre pokemon : " + this.pokemonDresseurHp);
            }
            else if(choix.equals("2")){
                //revient a faire 100 - le pourcentage soit le pourcentage inverse
                //et 0.8 le taux de capture max * le pourcentage inversse c'est a dire plus le pourcentage est bas plus le taux de capture est elevé
                //et cela car moins le pokemon a de pv + on a de chance de le capturer 
                double tauxCapture = 0.8 * ((100 - ((this.pokemonSauvageHp / this.pokemonSauvageHpMax) * 100))/100);
                int aleatoire = r.nextInt(100);
                System.out.println("hp" + this.pokemonSauvageHp +"hpMax" + this.pokemonSauvageHpMax);
                System.out.println("random" + aleatoire +"taux" + tauxCapture);
                if (aleatoire <= tauxCapture){
                    dresseur.capturePokemon(this.pokemon);
                    return; 
                }
            }else if(choix.equals("3")){
                System.out.print("Vous avez fuit");
                this.pokemon = null;
                return;
            }
        }
    }
    
}
