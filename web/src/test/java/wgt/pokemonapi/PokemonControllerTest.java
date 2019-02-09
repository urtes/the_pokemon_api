package wgt.pokemonapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import wgt.pokemonapi.requests.SelectionRequest;
import wgt.pokemonapi.requests.BattleRequest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PokemonControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    Sender sender;

    @MockBean
    SelectionRequest selectionRequest;

    @MockBean
    BattleRequest battleRequest;

    @InjectMocks
    PokemonController pokemonController;

    @Test
    public void controllerTest() throws Exception {
        Map<String, Pokemon> pokemonMap = new HashMap<>();
        Pokemon pokemon = new Pokemon();
        pokemon.setName("TestPokemon");
        pokemonMap.put(pokemon.getName(), pokemon);

        given(sender.sendSelectionRequest(selectionRequest)).willReturn(pokemonMap);

        mvc.perform(get("/pokemons")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.length()").value(1));
    }

}
