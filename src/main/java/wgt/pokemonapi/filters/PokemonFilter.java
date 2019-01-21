package wgt.pokemonapi.filters;

import wgt.pokemonapi.Pokemon;

import java.util.Map;

public abstract class PokemonFilter {

    public abstract Map<String, Pokemon> apply();
}
