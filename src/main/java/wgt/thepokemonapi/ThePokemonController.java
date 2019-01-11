package wgt.thepokemonapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThePokemonController {

    @GetMapping("/choose-pokemons")
    public String displayPokemonForm() {
        return "choose-pokemons";
    }
}
