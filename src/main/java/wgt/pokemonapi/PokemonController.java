package wgt.pokemonapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class PokemonController {

    @Autowired
    private Map<String, Pokemon> pokemonMap;

    @GetMapping("/choose-pokemons")
    public String displayPokemonForm() {
        System.out.println(pokemonMap.get("Volcanion"));
        return "choose-pokemons";
    }
}
