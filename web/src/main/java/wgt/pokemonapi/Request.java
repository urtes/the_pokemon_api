package wgt.pokemonapi;

import lombok.Data;

import java.io.Serializable;

@Data
public class Request implements Serializable {

    private boolean legendary;
    private String name;

}
