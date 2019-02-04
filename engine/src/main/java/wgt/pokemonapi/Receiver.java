package wgt.pokemonapi;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import wgt.pokemonapi.requests.BattleRequest;
import wgt.pokemonapi.requests.SelectionRequest;

import java.util.Map;

public class Receiver {

    @Autowired
    FilteringSystem filteringSystem;

    @Autowired
    BattleSystem battleSystem;

    @RabbitListener(queues = "#{queueSelection.name}")
    public Map<String, Pokemon> receiveSelection(SelectionRequest selectionRequest) throws InterruptedException {
        return receiveSelectionRequest(selectionRequest);
    }

    @RabbitListener(queues = "#{queueBattle.name}")
    public void receiveBattle(BattleRequest battleRequest) throws InterruptedException {
        receiveBattleRequest(battleRequest);
    }

    public Map<String, Pokemon> receiveSelectionRequest(SelectionRequest selectionRequest) throws  InterruptedException {

        return filteringSystem.filter(selectionRequest);
    }

    public Pokemon receiveBattleRequest(BattleRequest battleRequest) throws  InterruptedException {

        return battleSystem.fight(battleRequest);
    }
}
