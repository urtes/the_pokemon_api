package wgt.pokemonapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wgt.pokemonapi.filters.*;

import java.util.*;
import java.util.function.Predicate;

@RestController
public class PokemonController {

    @Autowired
    private Map<String, Pokemon> pokemonMap;

    @Autowired
    BattleSystem battleSystem;

    @GetMapping("/pokemons")
    private Map<String, Pokemon> filterPokemons(@RequestParam(value = "specificType", defaultValue = "") String specificType,
                                                @RequestParam(value = "multipleTypes", defaultValue = "false") boolean multipleTypes,
                                                @RequestParam(value = "legendary", defaultValue = "false") boolean legendary,
                                                @RequestParam(value = "name", defaultValue = "") String name) {

        Map<String, Pokemon> filteredPokemons = pokemonMap;
        List<Predicate<Map.Entry<String, Pokemon>>> filters;

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

    @GetMapping("/pokemons-battle")
    private Pokemon comparePokemons(@RequestParam(value = "pokemonA", defaultValue = "") String nameOfPokemonA,
                                    @RequestParam(value = "pokemonB", defaultValue = "") String nameOfPokemonB) {

        Pokemon winner = new Pokemon();
        Pokemon firstToAttack;
        Pokemon secondToAttack;

        Pokemon pokemonA = pokemonMap.get(nameOfPokemonA);
        Pokemon pokemonB = pokemonMap.get(nameOfPokemonB);

        if (pokemonA != null && pokemonB != null) {
            if (pokemonA.getAttackSpeed() >= pokemonB.getAttackSpeed()) {
                firstToAttack = pokemonA;
                secondToAttack = pokemonB;
            } else {
                firstToAttack = pokemonB;
                secondToAttack = pokemonA;
            }

            winner = battleSystem.fight(firstToAttack, secondToAttack);
        }

        return winner;
    }

}
