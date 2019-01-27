package wgt.pokemonapi.filters;

import lombok.AllArgsConstructor;
import wgt.pokemonapi.Pokemon;

import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FilterBySpecificType extends PokemonFilter {

    private Map<String, Pokemon> pokemonsToFilter;
    private String specificType;


    @Override
    public Map<String, Pokemon> apply() {

        Map<String, Pokemon> filteredPokemons = pokemonsToFilter
                .entrySet()
                .stream()
                .filter(e -> (specificType.toLowerCase().equals(e.getValue().getType1().toLowerCase()))
                        || (specificType.toLowerCase().equals(e.getValue().getType2().toLowerCase())))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        return filteredPokemons;
    }
}