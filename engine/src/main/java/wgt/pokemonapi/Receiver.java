package wgt.pokemonapi;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class Receiver {

    @RabbitListener(queues = "#{autoDeleteQueueSelection.name}")
    public void receiveSelection(SelectionRequest selectionRequest) throws InterruptedException {
        receiveSelectionRequest(selectionRequest);
    }

    @RabbitListener(queues = "#{autoDeleteQueueBattle.name}")
    public void receiveBattle(BattleRequest battleRequest) throws InterruptedException {
        receiveBattleRequest(battleRequest);
    }

    public void receiveSelectionRequest(SelectionRequest selectionRequest) throws  InterruptedException {
        System.out.println("Received: " + selectionRequest.toString() );
    }

    public void receiveBattleRequest(BattleRequest battleRequest) throws  InterruptedException {
        System.out.println("Received: " + battleRequest.toString());
    }
}
