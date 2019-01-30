package wgt.pokemonapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wgt.pokemonapi.filters.*;

import java.util.*;

@RestController
public class PokemonController {

    @Autowired
    private Map<String, Pokemon> pokemonMap;

    @Autowired
    BattleSystem battleSystem;

    @Autowired
    Sender sender;

    @GetMapping("/pokemons")
    public Map<String, Pokemon> filterPokemons(@RequestParam(value = "specificType", defaultValue = "")String specificType,
                                                @RequestParam(value = "multipleTypes", defaultValue = "false") boolean multipleTypes,
                                                @RequestParam(value = "legendary", defaultValue = "false") boolean legendary,
                                                @RequestParam(value = "name", defaultValue = "") String name) {

        Map<String, Pokemon> filteredPokemons = pokemonMap;
        List<PokemonFilter> filters = new ArrayList<>();

        if (specificType != null && specificType.length() != 0) {
            PokemonFilter filterBySpecificType = new FilterBySpecificType(filteredPokemons, specificType);
            filters.add(filterBySpecificType);
        }

        if (multipleTypes) {
            PokemonFilter filterByMultipleTypes = new FilterByMultipleTypes(filteredPokemons);
            filters.add(filterByMultipleTypes);
        }

        if (legendary) {
            PokemonFilter filterLegendary = new FilterLegendary(filteredPokemons);
            filters.add(filterLegendary);
        }

        if (name != null && name.length() != 0) {
            PokemonFilter filterByName = new FilterByName(filteredPokemons, name);
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

    @GetMapping("/pokemons-battle")
    public Pokemon comparePokemons(@RequestParam(value = "pokemonA", defaultValue = "") String nameOfPokemonA,
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

//    @GetMapping("/message")
//    public void sendMessage() {
//
//        sender.send();
//    }
}
