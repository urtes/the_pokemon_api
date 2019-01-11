package wgt.thepokemonapi;

import lombok.Data;

@Data
public class ThePokemon {
    private Integer id;
    private String name;
    private String type1;
    private String type2;
    private Integer total;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer spAtk;
    private Integer spDef;
    private Integer speed;
    private Integer generation;
    private Boolean legendary;
}
