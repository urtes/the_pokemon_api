//package wgt.pokemonapi;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import wgt.pokemonapi.filters.*;
//import wgt.pokemonapi.requests.SelectionRequest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import static com.sun.javaws.JnlpxArgs.verify;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class FilteringSystemTests {
//
//    @Mock
//    Map<String, Pokemon> pokemonMapMock;
//
//    @InjectMocks
//    FilteringSystem filteringSystem;
//
//    SelectionRequest selectionRequest = new SelectionRequest();
//    List<PokemonFilter> filters = new ArrayList<>();
//
//
//    @Test
//    public void filterTestInvokeMethod4Times() {
//
//        selectionRequest.setSpecificType("Grass");
//        selectionRequest.setMultipleTypes(true);
//        selectionRequest.setLegendary(true);
//        selectionRequest.setName("Bulbasaur");
//
//        Map<String, Pokemon> filteredPokemons = pokemonMapMock;
//
//        PokemonFilter filterMock = Mockito.mock(PokemonFilter.class);
//        when(filters.add(filterMock)).then(filters.add(filterMock));
//
//        verify(filteringSystem, times(4).filter.apply());
//    }
//
//}
