package wgt.pokemonapi.Filters;

import wgt.pokemonapi.Pokemon;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterByMultipleTypes implements PokemonFilter {

    private Map<String, Pokemon> pokemonsToFilter;
    private Map<String, Pokemon> filteredPokemons = new HashMap<>();

    public FilterByMultipleTypes(Map<String, Pokemon> pokemonMap) {
        this.pokemonsToFilter = pokemonMap;
    }

    @Override
    public Map<String, Pokemon> filterPokemons() {

        filteredPokemons = pokemonsToFilter
                .entrySet()
                .stream()
                .filter(e -> (e.getValue().getType1().length() != 0)
                && (e.getValue().getType2().length() != 0))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        return filteredPokemons;
    }
}
