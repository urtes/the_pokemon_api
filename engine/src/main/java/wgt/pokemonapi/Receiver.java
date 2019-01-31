package wgt.pokemonapi;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "test.web&engine.from-web")
public class Receiver {

//    @Autowired
//    Sender sender;

    @RabbitHandler
    public Pokemon receive(Request request) {
        System.out.println(" [x] Received '" + request.toString() + "'");
//        sender.send();
        Pokemon pokemon = new Pokemon();
        pokemon.setName("Bulbasaur");
        pokemon.setHealth(100);
        return pokemon;
    }
}
