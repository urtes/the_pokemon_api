package wgt.pokemonapi.Filters;

import wgt.pokemonapi.Filters.PokemonFilter;
import wgt.pokemonapi.Pokemon;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterByName implements PokemonFilter {

    private String name;
    private Map<String, Pokemon> pokemonsToFilter;
    private Map<String, Pokemon> filteredPokemons = new HashMap<>();

    public FilterByName(Map<String, Pokemon> pokemonMap, String name) {
        this.name = name;
        this.pokemonsToFilter = pokemonMap;
    }

    @Override
    public Map<String, Pokemon> filterPokemons() {

        filteredPokemons = pokemonsToFilter
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        return filteredPokemons;
    }
}
