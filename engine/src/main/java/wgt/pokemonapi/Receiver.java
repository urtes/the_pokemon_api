package wgt.pokemonapi;

import org.omg.PortableServer.POA;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class Receiver {

    @RabbitListener(queues = "#{autoDeleteQueueSelection.name}")
    public Map<String, Pokemon> receiveSelection(SelectionRequest selectionRequest) throws InterruptedException {
        return receiveSelectionRequest(selectionRequest);
    }

    @RabbitListener(queues = "#{autoDeleteQueueBattle.name}")
    public void receiveBattle(BattleRequest battleRequest) throws InterruptedException {
        receiveBattleRequest(battleRequest);
    }

    public Map<String, Pokemon> receiveSelectionRequest(SelectionRequest selectionRequest) throws  InterruptedException {
        System.out.println("Received: " + selectionRequest.toString() );
        Pokemon pokemon = new Pokemon();
        pokemon.setName("Bulbasaur");
        pokemon.setLegendary(true);
        pokemon.setAttack(100);
        Map<String, Pokemon> pokemons = new HashMap<>();
        pokemons.put(pokemon.getName(), pokemon);
        return pokemons;
    }

    public void receiveBattleRequest(BattleRequest battleRequest) throws  InterruptedException {
        System.out.println("Received: " + battleRequest.toString());
    }
}
