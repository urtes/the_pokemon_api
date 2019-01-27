package wgt.pokemonapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class SimplePokemonControllerTests {

    PokemonController pokemonController = Mockito.mock(PokemonController.class);

    @Test
    public void filterPokemonsTest() throws Exception {

        verify(pokemonController, times(4)).filterPokemons("test", true, true, "test");
    }
}
