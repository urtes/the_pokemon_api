//package wgt.pokemonapi;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import wgt.pokemonapi.requests.BattleRequest;
//
//import java.util.Map;
//
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class BattleSystemTests {
//
//    @Mock
//    Map<String, Pokemon> pokemonMapMock;
//
//    @InjectMocks
//    BattleSystem battleSystem;
//
//    BattleRequest battleRequest = new BattleRequest();
//    Pokemon firstToAttack = new Pokemon();
//    Pokemon secondToAttack = new Pokemon();
//
//    @Test
//    public void fightTestFirstToWin() {
//
//        battleRequest.setNameOfPokemonA("firstToAttack");
//        battleRequest.setNameOfPokemonB("secondToAttack");
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
//        when(pokemonMapMock.get(battleRequest.getNameOfPokemonA())).thenReturn(firstToAttack);
//        when(pokemonMapMock.get(battleRequest.getNameOfPokemonB())).thenReturn(secondToAttack);
//
//        assertTrue("firstToAttack".equals(battleSystem.fight(battleRequest).getName()));
//    }
//
//    @Test
//    public void fightTestWithEqualValues() {
//
//        battleRequest.setNameOfPokemonA("firstToAttack");
//        battleRequest.setNameOfPokemonB("secondToAttack");
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
//        when(pokemonMapMock.get(battleRequest.getNameOfPokemonA())).thenReturn(firstToAttack);
//        when(pokemonMapMock.get(battleRequest.getNameOfPokemonB())).thenReturn(secondToAttack);
//
//        assertTrue("firstToAttack".equals(battleSystem.fight(battleRequest).getName()));
//    }
//}
