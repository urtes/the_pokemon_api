package wgt.pokemonapi;

import lombok.var;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wgt.pokemonapi.requests.BattleRequest;
import wgt.pokemonapi.requests.SelectionRequest;

@Configuration
public class PokemonApplicationConfig {

    @Bean
    public Sender sender() {
        return new Sender();
    }

    @Bean
    public SelectionRequest selectionRequest() { return new SelectionRequest(); }

    @Bean
    public BattleRequest battleRequest() { return new BattleRequest(); }

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
}
