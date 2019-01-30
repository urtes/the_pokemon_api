package wgt.pokemonapi;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "from engine")
public class Receiver {

    @RabbitHandler
    public void receive(Pokemon pokemon) {
        System.out.println(" [x] Received '" + pokemon.toString() + "'");
    }
}
