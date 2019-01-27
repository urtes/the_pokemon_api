package wgt.pokemonapi;

import org.springframework.stereotype.Component;

@Component
public class BattleSystem {

    public Pokemon fight(Pokemon firstToAttack, Pokemon secondToAttack) {

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

        return (healthOfFirstToAttack >= healthOfSecondToAttack) ? firstToAttack : secondToAttack;
    }
}
