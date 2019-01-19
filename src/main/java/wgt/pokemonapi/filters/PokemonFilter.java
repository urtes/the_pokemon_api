package wgt.pokemonapi.filters;

import wgt.pokemonapi.Pokemon;

import java.util.Map;

public interface PokemonFilter {

    Map<String, Pokemon> filterPokemons();
}
