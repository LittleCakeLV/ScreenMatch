package com.ramos.screenmatch;

import com.ramos.screenmatch.model.DadosSerie;
import com.ramos.screenmatch.service.ConsumoAPI;
import com.ramos.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        var consumoAPI = new ConsumoAPI();
        var json = consumoAPI.obterDados("https://www.omdbapi.com/?apikey=33a8b67e&t=supernatural");
        ConverteDados converter = new ConverteDados();
        DadosSerie dados = converter.obterDados(json, DadosSerie.class);
        System.out.println(dados);
    }
}
