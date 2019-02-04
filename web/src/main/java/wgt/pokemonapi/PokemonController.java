package wgt.pokemonapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wgt.pokemonapi.filters.*;
import wgt.pokemonapi.requests.BattleRequest;
import wgt.pokemonapi.requests.SelectionRequest;

import java.util.*;

@RestController
public class PokemonController {

    @Autowired
    Sender sender;

    @Autowired
    SelectionRequest selectionRequest;

    @Autowired
    BattleRequest battleRequest;

    @GetMapping("/pokemons")
    public Map<String, Pokemon> filterPokemons (@RequestParam(value = "specificType", defaultValue = "")String specificType,
                                                @RequestParam(value = "multipleTypes", defaultValue = "false") boolean multipleTypes,
                                                @RequestParam(value = "legendary", defaultValue = "false") boolean legendary,
                                                @RequestParam(value = "name", defaultValue = "") String name) {

        selectionRequest.setSpecificType(specificType);
        selectionRequest.setMultipleTypes(multipleTypes);
        selectionRequest.setLegendary(legendary);
        selectionRequest.setName(name);

        return sender.sendSelectionRequest(selectionRequest);
    }

    @GetMapping("/pokemons-battle")
    public Pokemon comparePokemons(@RequestParam(value = "pokemonA", defaultValue = "") String nameOfPokemonA,
                                    @RequestParam(value = "pokemonB", defaultValue = "") String nameOfPokemonB) {

        battleRequest.setNameOfPokemonA(nameOfPokemonA);
        battleRequest.setNameOfPokemonB(nameOfPokemonB);

        System.out.println("received :" + sender.sendBattleRequest(battleRequest).toString());

        return sender.sendBattleRequest(battleRequest); }
}
