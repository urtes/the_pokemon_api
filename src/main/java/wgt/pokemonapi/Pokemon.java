package wgt.pokemonapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Pokemon {
    @JsonProperty("#")
    private Integer id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Type 1")
    private String type1;

    @JsonProperty("Type 2")
    private String type2;

    @JsonProperty("Total")
    private Integer total;

    @JsonProperty("HP")
    private Integer health;

    @JsonProperty("Attack")
    private Integer attack;

    @JsonProperty("Defense")
    private Integer defense;

    @JsonProperty("Sp. Atk")
    private Integer attackSpeed;

    @JsonProperty("Sp. Def")
    private Integer defenseSpeed;

    @JsonProperty("Speed")
    private Integer speed;

    @JsonProperty("Generation")
    private Integer generation;

    @JsonProperty("Legendary")
    private Boolean legendary;
}
