package wgt.pokemonapi;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "from web")
public class Receiver {

    @Autowired
    Sender sender;

    @RabbitHandler
    public void receive(Request request) {
        System.out.println(" [x] Received '" + request.toString() + "'");
        sender.send();
    }
}
