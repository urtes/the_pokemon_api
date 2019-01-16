package wgt.pokemonapi.Filters;

import wgt.pokemonapi.Pokemon;

import java.util.Map;

public interface PokemonFilter {

    Map<String, Pokemon> filterPokemons();
}
