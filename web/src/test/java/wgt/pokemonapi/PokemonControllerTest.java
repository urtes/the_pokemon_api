package wgt.pokemonapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import wgt.pokemonapi.requests.SelectionRequest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PokemonController.class)
public class PokemonControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    Sender sender;

    @Mock
    SelectionRequest selectionRequest;

    @MockBean
    @InjectMocks
    private PokemonController pokemonController;

    @Test
    public void filterPokemonsTest() throws Exception {
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
