public record Capture() {
    public Capture(){

    }

    public void createPokemon(Dresseur dresseur, Pokemon pokemon){
        Pokemon p1 = new Pokemon(pokemon, dresseur);
    }
    
}
