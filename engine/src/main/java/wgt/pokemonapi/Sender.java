package wgt.pokemonapi;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import wgt.pokemonapi.queues.QueueFromEngine;

public class Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private QueueFromEngine queueFromEngine;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World, from engine!";
        this.template.convertAndSend(queueFromEngine.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
