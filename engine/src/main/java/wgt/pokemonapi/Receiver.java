package wgt.pokemonapi;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "from web")
public class Receiver {

    @RabbitHandler
    public void receive(Request request) {
        System.out.println(" [x] Received '" + request.toString() + "'");
    }
}
