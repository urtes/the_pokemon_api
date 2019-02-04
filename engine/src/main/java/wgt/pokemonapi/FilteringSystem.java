package wgt.pokemonapi;

import org.springframework.beans.factory.annotation.Autowired;
import wgt.pokemonapi.filters.*;
import wgt.pokemonapi.requests.SelectionRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilteringSystem {

    @Autowired
    private Map<String, Pokemon> pokemonMap;

    public Map<String, Pokemon> filter(SelectionRequest selectionRequest) {

        Map<String, Pokemon> filteredPokemons = pokemonMap;
        List<PokemonFilter> filters = new ArrayList<>();

        if (selectionRequest.getSpecificType() != null && selectionRequest.getSpecificType().length() != 0) {
            PokemonFilter filterBySpecificType = new FilterBySpecificType(filteredPokemons, selectionRequest.getSpecificType());
            filters.add(filterBySpecificType);
        }

        if (selectionRequest.isMultipleTypes()) {
            PokemonFilter filterByMultipleTypes = new FilterByMultipleTypes(filteredPokemons);
            filters.add(filterByMultipleTypes);
        }

        if (selectionRequest.isLegendary()) {
            PokemonFilter filterLegendary = new FilterLegendary(filteredPokemons);
            filters.add(filterLegendary);
        }

        if (selectionRequest.getName() != null && selectionRequest.getName().length() != 0) {
            PokemonFilter filterByName = new FilterByName(filteredPokemons, selectionRequest.getName());
            filters.add(filterByName);
        }

        if (filters.isEmpty()) {
            return filteredPokemons;
        }

        for (PokemonFilter filter : filters) {
            filteredPokemons = filter.apply();
        }

        return filteredPokemons;
    }
}
