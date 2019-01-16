package wgt.pokemonapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wgt.pokemonapi.Filters.*;

import java.util.*;

@RestController
public class PokemonController {

    @Autowired
    private Map<String, Pokemon> pokemonMap;

    @GetMapping("/pokemons")
    private Map<String, Pokemon> filterPokemons(@RequestParam(value = "specificType", defaultValue = "") String specificType,
                                                @RequestParam(value = "multipleTypes", defaultValue = "false") boolean multipleTypes,
                                                @RequestParam(value = "legendary", defaultValue = "false") boolean legendary,
                                                @RequestParam(value = "name", defaultValue = "") String name) {

        Map<String, Pokemon> filteredPokemons = pokemonMap;

        if (specificType != null && specificType.length() != 0) {
            PokemonFilter filter = new FilterBySpecificType(filteredPokemons, specificType);
            filteredPokemons = filter.filterPokemons();
        }

        if (multipleTypes) {

            PokemonFilter filter = new FilterByMultipleTypes(filteredPokemons);
            filteredPokemons = filter.filterPokemons();
        }

        if (legendary) {

            PokemonFilter filter = new FilterLegendary(filteredPokemons);
            filteredPokemons = filter.filterPokemons();
        }

        if (name != null && name.length() != 0) {

            PokemonFilter filter = new FilterByName(filteredPokemons, name);
            filteredPokemons = filter.filterPokemons();
        }

        return filteredPokemons;

    }
}
