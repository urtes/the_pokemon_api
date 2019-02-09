package wgt.pokemonapi.filters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import wgt.pokemonapi.Pokemon;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FilterLegendaryTests {

    Map<String, Pokemon> testPokemonsToFilter = new HashMap<>();
    FilterLegendary filterLegendary = new FilterLegendary();

    @Test
    public void applyTestWithAllLegendary(){

        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();
        pokemon1.setLegendary(true);
        pokemon2.setLegendary(true);
        testPokemonsToFilter.put("pokemon1", pokemon1);
        testPokemonsToFilter.put("pokemon2", pokemon2);

        assertEquals(2, filterLegendary.apply(testPokemonsToFilter).size());
    }

    @Test
    public void applyTestWithNoLegendary() {

        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();
        pokemon1.setLegendary(false);
        pokemon2.setLegendary(false);
        testPokemonsToFilter.put("pokemon1", pokemon1);
        testPokemonsToFilter.put("pokemon2", pokemon2);

        assertEquals(0, filterLegendary.apply(testPokemonsToFilter).size());
    }

    @Test
    public void applyTestWithMixedLegendaryValues() {

        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon();
        pokemon1.setLegendary(true);
        pokemon2.setLegendary(false);
        testPokemonsToFilter.put("pokemon1", pokemon1);
        testPokemonsToFilter.put("pokemon2", pokemon2);

        assertEquals(1, filterLegendary.apply(testPokemonsToFilter).size());
        Assert.assertEquals(true, filterLegendary.apply(testPokemonsToFilter).get("pokemon1").getLegendary());
    }

    @Test
    public void applyTestWithNoValues() {
        assertEquals(0, filterLegendary.apply(testPokemonsToFilter).size());
    }
}
