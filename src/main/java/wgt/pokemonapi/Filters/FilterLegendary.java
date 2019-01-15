package wgt.pokemonapi.Filters;

import wgt.pokemonapi.Pokemon;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterLegendary implements PokemonFilter {

    Map<String, Pokemon> pokemonsToFilter;
    Map<String, Pokemon> filteredPokemons = new HashMap<>();

    public FilterLegendary(Map<String, Pokemon> pokemonMap) {
        this.pokemonsToFilter = pokemonMap;
    }

    @Override
    public Map<String, Pokemon> filterPokemons() {

        filteredPokemons = pokemonsToFilter
                .entrySet()
                .stream()
                .filter(e -> (e.getValue().getLegendary()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        return filteredPokemons;
    }
}
