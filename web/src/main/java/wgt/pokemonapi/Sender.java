package wgt.pokemonapi;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import wgt.pokemonapi.queues.QueueFromWeb;

import java.util.HashMap;
import java.util.Map;

public class Sender {

    @Autowired
    private RabbitTemplate template;

//    @Autowired
//    private QueueFromWeb queueFromWeb;

    @Autowired
    private TopicExchange topic;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendSelectionRequest(SelectionRequest selectionRequest) {
//        String message = "Hello World, from web!";
//        this.template.convertAndSend(queueFromWeb.getName(), request);
//        System.out.println(" [x] Sent '" + request.toString() + "'");
        Map<String, Pokemon> pokemons = new HashMap<>();
        pokemons = (Map<String, Pokemon>) template.convertSendAndReceive(topic.getName(), "selection", selectionRequest);
        System.out.println("Send: " + selectionRequest.toString());
        System.out.println("Received: " + pokemons.get("Bulbasaur").toString());
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendBattleRequest(BattleRequest battleRequest) {
//        String message = "Hello World, from web!";
//        this.template.convertAndSend(queueFromWeb.getName(), request);
//        System.out.println(" [x] Sent '" + request.toString() + "'");
        template.convertSendAndReceive(topic.getName(), "battle", battleRequest);
        System.out.println("Send: " + battleRequest.toString());
    }
}
