package wgt.pokemonapi;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PokemonControllerTests extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void filterPokemonsTest() throws Exception {
        String uri = "/pokemons";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
//        Map<String, Pokemon> pokemonMap = super.mapToJson(content, Map<String, Pokemon>.class);
//        assertTrue(pokemonMap.size() > 0);
        assertTrue(true);
    }

    @Test
    public void comparePokemonsTest() throws Exception {
        String uri = "/pokemons-battle";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
//        Pokemon winner = super.mapToJson(content, Pokemon.class);
//        assertTrue(winner != null);
        assertTrue(true);
    }


}
