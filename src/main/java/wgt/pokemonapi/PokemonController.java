package wgt.pokemonapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class PokemonController {

    @Autowired
    private Map<String, Pokemon> pokemonMap;

    @GetMapping("/choose-pokemons")
    public String displayPokemonForm() {

        return "choose-pokemons";
    }

    @GetMapping("/pokemons")
    private Map<String, Pokemon> filterPokemons (@RequestParam(value = "specificType") String specificType) {

        Map<String, Pokemon> pokemons = new HashMap<>();

        if (specificType != null){

           pokemons = pokemonMap
                   .entrySet()
                   .stream()
                   .filter(e -> specificType.toLowerCase().equals(e.getValue().getType1().toLowerCase()))
                   .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        }

        System.out.println("Pokemons with type Flying: " + pokemons);

        return pokemons;
    }
}
