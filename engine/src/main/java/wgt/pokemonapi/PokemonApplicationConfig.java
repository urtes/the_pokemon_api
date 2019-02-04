package wgt.pokemonapi;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.var;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
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
    public FilteringSystem filteringSystem() { return new FilteringSystem(); }

    @Bean
    public BattleSystem battleSystem() { return new BattleSystem(); }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public TopicExchange topic() { return new TopicExchange("test.web&engine"); }

    @Bean
    public Queue queueSelection() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue queueBattle() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding bindingSelection (TopicExchange topic, Queue queueSelection) {
        return BindingBuilder.bind(queueSelection)
                .to(topic)
                .with("selection");
    }

    @Bean
    public Binding bindingBattle (TopicExchange topic, Queue queueBattle) {
        return BindingBuilder.bind(queueBattle)
                .to(topic)
                .with("battle");
    }
}
