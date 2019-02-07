package wgt.pokemonapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import wgt.pokemonapi.requests.BattleRequest;

import java.util.Map;

public class BattleSystem {

    @Autowired
    @Getter
    private Map<String, Pokemon> pokemonMap;

    public Pokemon fight(BattleRequest battleRequest) {

        Pokemon winner = new Pokemon();
        Pokemon firstToAttack;
        Pokemon secondToAttack;

        Pokemon pokemonA = pokemonMap.get(battleRequest.getNameOfPokemonA());
        Pokemon pokemonB = pokemonMap.get(battleRequest.getNameOfPokemonB());

        if (pokemonA != null && pokemonB != null) {
            if (pokemonA.getAttackSpeed() >= pokemonB.getAttackSpeed()) {
                firstToAttack = pokemonA;
                secondToAttack = pokemonB;
            } else {
                firstToAttack = pokemonB;
                secondToAttack = pokemonA;
            }

            Integer healthOfFirstToAttack = firstToAttack.getHealth();
            Integer healthOfSecondToAttack = secondToAttack.getHealth();
            final int rounds = 8;

            for (int i = 0; i < rounds; i++) {

                healthOfSecondToAttack -= (firstToAttack.getAttack() - secondToAttack.getDefense());
                healthOfFirstToAttack -= (secondToAttack.getAttack() - firstToAttack.getDefense());

                if (healthOfFirstToAttack <= 0 || healthOfSecondToAttack <= 0) {
                    break;
                }
            }

            winner = (healthOfFirstToAttack >= healthOfSecondToAttack) ? firstToAttack : secondToAttack;
        }
        return winner;
    }
}
