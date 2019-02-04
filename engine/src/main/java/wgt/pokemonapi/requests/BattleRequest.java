package wgt.pokemonapi.requests;

import lombok.Data;

@Data
public class BattleRequest {

    private String nameOfPokemonA;
    private String nameOfPokemonB;
}
