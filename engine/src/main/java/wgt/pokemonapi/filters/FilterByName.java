package wgt.pokemonapi.filters;

import lombok.AllArgsConstructor;
import wgt.pokemonapi.Pokemon;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FilterByName extends PokemonFilter {

    private String name;

    @Override
    public Map<String, Pokemon> apply(Map<String, Pokemon> pokemonsToFilter) {

        Map<String, Pokemon> filteredPokemons = pokemonsToFilter
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getName().toLowerCase().equals(name.toLowerCase()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        return filteredPokemons;
    }
}