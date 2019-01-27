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
public class FilterByMultipleTypesTests {

    Map<String, Pokemon> testPokemonsToFilter = new HashMap<>();
    FilterByMultipleTypes filterByMultipleTypes = new FilterByMultipleTypes(testPokemonsToFilter);

    @Test
    public void applyTestWithAllMultipleTypes() {

        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();
        Pokemon pokemon3 = new Pokemon();

        pokemon1.setType1("Grass");
        pokemon2.setType1("Bug");
        pokemon3.setType1("Normal");

        pokemon1.setType2("Poison");
        pokemon2.setType2("Flying");
        pokemon3.setType2("Flying");

        testPokemonsToFilter.put("pokemon1", pokemon1);
        testPokemonsToFilter.put("pokemon2", pokemon2);
        testPokemonsToFilter.put("pokemon3", pokemon3);

        assertEquals(3, filterByMultipleTypes.apply().size());
    }

    @Test
    public void applyTestWithNoMultipleTypes() {

        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();
        Pokemon pokemon3 = new Pokemon();

        pokemon1.setType1("Grass");
        pokemon2.setType1("Bug");
        pokemon3.setType1("Normal");

        pokemon1.setType2("");
        pokemon2.setType2("");
        pokemon3.setType2("");

        testPokemonsToFilter.put("pokemon1", pokemon1);
        testPokemonsToFilter.put("pokemon2", pokemon2);
        testPokemonsToFilter.put("pokemon3", pokemon3);

        assertEquals(0, filterByMultipleTypes.apply().size());
    }

    @Test
    public void applyTestWithMixedTypes() {

        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();

        pokemon1.setType1("Grass");
        pokemon2.setType1("Bug");

        pokemon1.setType2("Poison");
        pokemon2.setType2("");

        testPokemonsToFilter.put("pokemon1", pokemon1);
        testPokemonsToFilter.put("pokemon2", pokemon2);

        assertEquals(1, filterByMultipleTypes.apply().size());
        assertTrue("Grass".equals(filterByMultipleTypes.apply().get("pokemon1").getType1()));
    }

    @Test
    public void applyTestWithNoValues() {
        assertEquals(0, filterByMultipleTypes.apply().size());
    }
}
