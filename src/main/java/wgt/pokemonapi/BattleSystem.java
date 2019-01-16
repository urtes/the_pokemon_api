package wgt.pokemonapi;

public class BattleSystem {

    public Pokemon fight(Pokemon firstToAttack, Pokemon secondToAttack) {

        Pokemon winner;
        Integer healthOfFirstToAttack = firstToAttack.getHealth();
        Integer healthOfSecondToAttack = secondToAttack.getHealth();

        for (int i = 0; i < 8; i++) {

            healthOfSecondToAttack = healthOfSecondToAttack -(firstToAttack.getAttack() - secondToAttack.getDefense());
            healthOfFirstToAttack = healthOfFirstToAttack - (secondToAttack.getAttack() - firstToAttack.getDefense());

            if (healthOfFirstToAttack <= 0 || healthOfSecondToAttack <= 0) {
                break;
            }
        }

        if (healthOfFirstToAttack >= healthOfSecondToAttack) {
            winner = firstToAttack;
        } else {
            winner = secondToAttack;
        }

        return winner;
    }
}
