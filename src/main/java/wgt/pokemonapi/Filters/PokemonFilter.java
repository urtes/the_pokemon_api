package wgt.pokemonapi.Filters;

import wgt.pokemonapi.Pokemon;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Filter;

public interface PokemonFilter {

    public Map<String, Pokemon> filterPokemons();
}
