package wgt.pokemonapi;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import wgt.pokemonapi.queues.QueueFromWeb;

public class Sender {

    @Autowired
    private RabbitTemplate template;

//    @Autowired
//    private QueueFromWeb queueFromWeb;

    @Autowired
    private DirectExchange directExchange;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(Request request) {
//        String message = "Hello World, from web!";
//        this.template.convertAndSend(queueFromWeb.getName(), request);
//        System.out.println(" [x] Sent '" + request.toString() + "'");
        Pokemon response = (Pokemon) template.convertSendAndReceive(directExchange.getName(), "web&engine", request);
        System.out.println("Received: " + response.toString());
    }
}
