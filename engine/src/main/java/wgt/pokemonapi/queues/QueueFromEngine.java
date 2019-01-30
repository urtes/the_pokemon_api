package wgt.pokemonapi.queues;

import org.springframework.amqp.core.Queue;

public class QueueFromEngine extends Queue {
    public QueueFromEngine(String name) {
        super(name);
    }
}
