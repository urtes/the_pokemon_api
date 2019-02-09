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
        List<PokemonFilter> filters = collectFilters(selectionRequest);

        if (filters.isEmpty()) {
            return filteredPokemons;
        }

        for (PokemonFilter filter : filters) {
            filteredPokemons = filter.apply(filteredPokemons);
        }

        return filteredPokemons;
    }

    protected List<PokemonFilter> collectFilters(SelectionRequest selectionRequest) {
        List<PokemonFilter> filters = new ArrayList<>();

        String specificType = selectionRequest.getSpecificType();
        Boolean multipleTypes = selectionRequest.isMultipleTypes();
        Boolean legendary = selectionRequest.isLegendary();
        String name = selectionRequest.getName();

        if (specificType != null && specificType.length() != 0) {
            PokemonFilter filterBySpecificType = new FilterBySpecificType(specificType);
            filters.add(filterBySpecificType);
        }

        if (multipleTypes) {
            PokemonFilter filterByMultipleTypes = new FilterByMultipleTypes();
            filters.add(filterByMultipleTypes);
        }

        if (legendary) {
            PokemonFilter filterLegendary = new FilterLegendary();
            filters.add(filterLegendary);
        }

        if (name != null && name.length() != 0) {
            PokemonFilter filterByName = new FilterByName(name);
            filters.add(filterByName);
        }

        return filters;
    }
}
