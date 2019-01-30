package wgt.pokemonapi.queues;

import org.springframework.amqp.core.Queue;

public class QueueFromWeb extends Queue {
    public QueueFromWeb(String name) {
        super(name);
    }
}
