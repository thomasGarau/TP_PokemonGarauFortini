import java.util.*;
public class Capture {
    private Pokemon pokemon;
    private Dresseur dresseur;
    private double pokemonSauvageHp;
    private double pokemonSauvageHpMax;
    private double pokemonDresseurHp;

    //demarre une rencontre avec un pokemon de stade1 aléatoire
    public Capture(Dresseur dresseur){
        this.dresseur = dresseur;
        Random r =new Random();
        int a  = r.nextInt(3);
        // le dresseur a une chance sur trois de tomber sur un pokemon
        if (a > 1){
            int i = 1 + r.nextInt(Pokedex.getPokedex().size());
            createPokemon(dresseur, Pokedex.getPokedex().get(i));
            this.pokemonDresseurHp = dresseur.getMainPokemon().getpv();
            combat();
        }else{
            System.out.print("Vous n'avez rien trouvé \n");
        }
    }

    //la fonction cree un pokemon avec un attribut dresseur pour qu'il soit capturable
    public void createPokemon(Dresseur dresseur, Pokemon pokemon){
        this.pokemon = new Pokemon(pokemon);
        this.pokemonSauvageHp = this.pokemon.getpv();
        this.pokemonSauvageHpMax = this.pokemon.getpv();
    }

    //engage le combat contre un pokemon sauvage
    public void combat(){
        System.out.print("vous avez trouvé un " + this.pokemon.getNom() + " PV: " + this.pokemon.getpv()+" ");
        Random r =new Random();
        //on capte l'input grace à un scanner
        Scanner input2 = new Scanner(System.in);
        int choix = 0;
        boolean cont=true;

        //le dresseur peut à chaque tour soit attaquer le pokemon, soit essayer le capturer ou bien il peut décider de fuire.
        //le pokemon sauvage quant à lui répond à chaque tour par une attaque aleatoire parmis ses compétences.
        while (cont){            
            System.out.println("\nfaite votre choix! 1:attaque  2:pokeball 3:fuite ");
            
            choix=input2.nextInt();
            
            double resultat;

            switch(choix){
                //choix d'attaquer
                case 1:
                    resultat = SystemCombat.attack(dresseur.getMainPokemon(), pokemon);
                    this.pokemonSauvageHp -= resultat;
                    if(pokemonSauvageHp < 1){
                        System.out.print("le pokemon sauvage est KO!! ");
                        //on detruit l'instance
                        this.pokemon = null;
                        return;
                    } 

                    System.out.print("Pv restant du pokemon sauvage : " + this.pokemonSauvageHp+" ");
                    resultat = SystemCombat.attackAuto(pokemon, dresseur.getMainPokemon());
                    this.pokemonDresseurHp -= resultat;

                    if (pokemonDresseurHp < 1){
                        System.out.print("Votre pokémon est KO!vous prenez la fuite..");
                        return;
                    }
                    System.out.print("Pv restant de votre pokemon : " + this.pokemonDresseurHp+"\n");
                    break;
                //choix capture
                case 2:
                    //vérfie que le dresseur posséde assez de pokeball est lui en retire une
                    if(dresseur.getNbPokeball() >= 1){
                        dresseur.throwPokeball();
                        // pourcentage compris 15 et 80 % en fonction des hp restant du pokemon sauvage
                        // plus les pv sont bas plus le taux de capture augmente.
                        double tauxCapture = (0.8 * ((100 - ((this.pokemonSauvageHp / this.pokemonSauvageHpMax) * 100))/100)) * 100;
                        int aleatoire = r.nextInt(100);
                        // si le taux de capture et supérieur ou égale au nombre aléatoire alors le pokemon est capturé.
                        if (aleatoire <= tauxCapture){
                            System.out.println("félicitation! vous avez capturer le pokemon\n");
                            dresseur.capturePokemon(this.pokemon);
                            pokemon.setDresseur(dresseur);
                            return; 
                        }
                        //si non le combat continu
                        else{
                            System.out.println("le pokemon est sortie de la pokeball!");
                            resultat = SystemCombat.attackAuto(pokemon, dresseur.getMainPokemon());
                            this.pokemonDresseurHp -= resultat;
                            if (pokemonDresseurHp < 1){
                                System.out.print("Votre pokémon est KO!vous prenez la fuite..\n");
                                return;
                            }
                            System.out.print("pv restant de votre pokemon : " + this.pokemonDresseurHp);
                        }
                    }
                    else{
                        System.out.println("nombre de pokeballs insufisant\n");
                    }
                    break;
                //choix de fuire
                //le combat est annulé le pokemon est détruit 
                case 3:
                    System.out.print("Vous prennez la fuite \n");
                    this.pokemon = null;
                    cont=false;
                    break;
            }
        }
    }
}
