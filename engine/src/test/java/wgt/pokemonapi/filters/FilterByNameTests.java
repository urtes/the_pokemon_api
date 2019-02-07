package wgt.pokemonapi.filters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import wgt.pokemonapi.Pokemon;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class FilterByNameTests {

    Map<String, Pokemon> testPokemonsToFilter = new HashMap<>();
    FilterByName filterByName = new FilterByName("Bulbasaur");

    @Test
    public void applyTestWithTwoValues() {

        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();
        pokemon1.setName("Bulbasaur");
        pokemon2.setName("Ivysaur");
        testPokemonsToFilter.put(pokemon1.getName(), pokemon1);
        testPokemonsToFilter.put(pokemon2.getName(), pokemon2);

        assertEquals(1, filterByName.apply(testPokemonsToFilter).size());
        assertTrue("Bulbasaur".equals(filterByName.apply(testPokemonsToFilter).get("Bulbasaur").getName()));
    }

    @Test
    public void applyTestWithNoValues() {
        assertEquals(0, filterByName.apply(testPokemonsToFilter).size());
    }
}
