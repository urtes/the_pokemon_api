package wgt.pokemonapi.filters;

import lombok.AllArgsConstructor;
import wgt.pokemonapi.Pokemon;

import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FilterByMultipleTypes extends PokemonFilter {

    @Override
    public Map<String, Pokemon> apply(Map<String, Pokemon> pokemonsToFilter) {

        Map<String, Pokemon> filteredPokemons = pokemonsToFilter
                .entrySet()
                .stream()
                .filter(e -> (e.getValue().getType1().length() != 0)
                        && (e.getValue().getType2().length() != 0))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        return filteredPokemons;
    }
}