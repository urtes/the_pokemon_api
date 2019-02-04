package wgt.pokemonapi.requests;

import lombok.Data;

@Data
public class SelectionRequest {
    private String specificType;
    private boolean multipleTypes;
    private boolean legendary;
    private String name;
}
