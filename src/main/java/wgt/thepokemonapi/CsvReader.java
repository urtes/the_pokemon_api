package wgt.thepokemonapi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvReader {

    public Map<String, ThePokemon> readFromCvs() {
        Map<String, ThePokemon> pokemonMap = new HashMap<>();
        String csvFile = "src/main/resources/static/pokemons.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            String headerLIne = br.readLine();
            ThePokemon thePokemon = new ThePokemon();

            while ((line = br.readLine()) != null) {
                String[] splitedLine = line.split(csvSplitBy);

                thePokemon.setId(Integer.parseInt(splitedLine[0]));
                thePokemon.setName(splitedLine[1]);
                thePokemon.setType1(splitedLine[2]);

                pokemonMap.put(thePokemon.getName(), thePokemon);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return pokemonMap;
    }
}
