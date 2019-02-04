//package wgt.pokemonapi;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.junit.Assert.assertTrue;
//
//@RunWith(MockitoJUnitRunner.class)
//public class BattleSystemTests {
//
//    BattleSystem battleSystem = new BattleSystem();
//
//    Pokemon firstToAttack = new Pokemon();
//    Pokemon secondToAttack = new Pokemon();
//
//    @Test
//    public void fightTestFirstToWin() {
//
//        firstToAttack.setName("firstToAttack");
//        firstToAttack.setHealth(100);
//        firstToAttack.setAttack(100);
//        firstToAttack.setDefense(100);
//
//        secondToAttack.setName("secondToAttack");
//        secondToAttack.setHealth(20);
//        secondToAttack.setAttack(20);
//        secondToAttack.setDefense(20);
//
//        assertTrue("firstToAttack".equals(battleSystem.fight(firstToAttack, secondToAttack).getName()));
//    }
//
//    @Test
//    public void fightTestWithEqualValues() {
//
//        firstToAttack.setName("firstToAttack");
//        firstToAttack.setHealth(100);
//        firstToAttack.setAttack(100);
//        firstToAttack.setDefense(100);
//
//        secondToAttack.setName("secondToAttack");
//        secondToAttack.setHealth(100);
//        secondToAttack.setAttack(100);
//        secondToAttack.setDefense(100);
//
//        assertTrue("firstToAttack".equals(battleSystem.fight(firstToAttack, secondToAttack).getName()));
//    }
//}
