package wgt.pokemonapi;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wgt.pokemonapi.queues.QueueFromEngine;
import wgt.pokemonapi.queues.QueueFromWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class PokemonApplicationConfig {

    @Value("${csv.path}")
    String csvPath;

    @Bean
    public InputStream pokemonStream() throws IOException {

        File initialFile = new File(csvPath);
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

    @Bean
    public QueueFromEngine helloFromEngine() {
        return new QueueFromEngine("from engine");
    }

    @Bean
    public QueueFromWeb helloFromWeb() {
        return new QueueFromWeb("from web");
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

    @Bean
    public Sender sender() {
        return new Sender();
    }
}
