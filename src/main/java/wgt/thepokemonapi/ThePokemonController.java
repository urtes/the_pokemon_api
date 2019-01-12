package wgt.thepokemonapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ThePokemonController {

    @Autowired
    private Map<String, Pokemon> pokemonMap;

    @GetMapping("/choose-pokemons")
    public String displayPokemonForm() {
        return "choose-pokemons";
    }
}
