package wgt.pokemonapi;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class PokemonApplicationConfig {

    @Bean
    public InputStream pokemonStream() throws IOException {

        File initialFile = new File("src/main/resources/static/pokemons.csv");
        InputStream stream = new FileInputStream(initialFile);

        return stream;
    }

    @Bean
    public Map<String, Pokemon> pokemons(InputStream stream) throws IOException {

        Map<String, Pokemon> pokemonMap = new HashMap<>();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Pokemon.class).withHeader().withColumnReordering(true);
        ObjectReader reader = mapper.readerFor(Pokemon.class).with(schema);
        List<Pokemon> pokemonList = reader.<Pokemon>readValues(stream).readAll();

        for (Pokemon pokemon : pokemonList) {
            pokemonMap.put(pokemon.getName(), pokemon);
        }

        return pokemonMap;
    }
}
