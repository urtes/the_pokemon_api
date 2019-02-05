package wgt.pokemonapi;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import wgt.pokemonapi.requests.BattleRequest;
import wgt.pokemonapi.requests.SelectionRequest;

import java.util.Map;

public class Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange topicPokemons;

    @Autowired
    private TopicExchange topicBattle;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public Map<String, Pokemon> sendSelectionRequest(SelectionRequest selectionRequest) {

        Map<String, Pokemon> pokemons;
        pokemons = (Map<String, Pokemon>) template.convertSendAndReceive(topicPokemons.getName(), "selection", selectionRequest);

        return pokemons;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public Pokemon sendBattleRequest(BattleRequest battleRequest) {

        Pokemon pokemon;
        pokemon = (Pokemon) template.convertSendAndReceive(topicBattle.getName(), "battle", battleRequest);

        return pokemon;
    }
}
