package wgt.pokemonapi.Filters;

import wgt.pokemonapi.Pokemon;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterBySpecificType implements PokemonFilter {

    private String specificType;
    private Map<String, Pokemon> pokemonsToFilter;
    private Map<String, Pokemon> filteredPokemons = new HashMap<>();

    public FilterBySpecificType(Map<String, Pokemon> pokemonMap, String specificType) {
        this.specificType = specificType;
        this.pokemonsToFilter = pokemonMap;
    }

    @Override
    public Map<String, Pokemon> filterPokemons() {

        filteredPokemons = pokemonsToFilter
                .entrySet()
                .stream()
                .filter(e -> (specificType.toLowerCase().equals(e.getValue().getType1().toLowerCase()))
                        || (specificType.toLowerCase().equals(e.getValue().getType2().toLowerCase())))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        return filteredPokemons;
    }
}
