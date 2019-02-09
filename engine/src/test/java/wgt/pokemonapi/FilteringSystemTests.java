package wgt.pokemonapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import wgt.pokemonapi.filters.*;
import wgt.pokemonapi.requests.SelectionRequest;

import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FilteringSystemTests {

    @Mock
    Map<String, Pokemon> pokemonMapMock;

    @InjectMocks
    FilteringSystem filteringSystem;

    SelectionRequest selectionRequest = new SelectionRequest();

    @Test
    public void collectFiltersTest() {

        selectionRequest.setSpecificType("Grass");
        selectionRequest.setMultipleTypes(true);
        selectionRequest.setLegendary(true);
        selectionRequest.setName("Bulbasaur");

        assertEquals(4, filteringSystem.collectFilters(selectionRequest).size());
        assertEquals(1, filteringSystem.collectFilters(selectionRequest)
                .stream()
                .filter(filter -> filter instanceof FilterByName).collect(Collectors.toList())
                .size());
    }

    @Test
    public void collectFiltersTestCollect2Filters() {

        selectionRequest.setMultipleTypes(false);
        selectionRequest.setLegendary(true);
        selectionRequest.setName("Bulbasaur");

        assertEquals(2, filteringSystem.collectFilters(selectionRequest).size());
    }

}
