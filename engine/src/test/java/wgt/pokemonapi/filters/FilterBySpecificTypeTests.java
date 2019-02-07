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
public class FilterBySpecificTypeTests {

    Map<String, Pokemon> testPokemonsToFilter = new HashMap<>();
    FilterBySpecificType filterBySpecificType = new FilterBySpecificType("Grass");

    @Test
    public void applyTestWithTwoValues() {

        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();

        pokemon1.setType1("Grass");
        pokemon2.setType1("OtherType");

        pokemon1.setType2("");
        pokemon2.setType2("OtherType");

        testPokemonsToFilter.put("pokemon1", pokemon1);
        testPokemonsToFilter.put("pokemon2", pokemon2);

        assertEquals(1, filterBySpecificType.apply(testPokemonsToFilter).size());
        assertTrue("Grass".equals(filterBySpecificType.apply(testPokemonsToFilter).get("pokemon1").getType1()));
    }

    @Test
    public void applyTestWithNoValues() {
        assertEquals(0, filterBySpecificType.apply(testPokemonsToFilter).size());
    }
}
