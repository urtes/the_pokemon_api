package wgt.pokemonapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class PokemonApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(PokemonApplication.class, args);

    }
}

