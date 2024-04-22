package com.helli.StudyFlix;

import com.helli.StudyFlix.model.DadosSerie;
import com.helli.StudyFlix.service.ConsumoApi;
import com.helli.StudyFlix.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyFlixApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudyFlixApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		var comsumo = new ConsumoApi();
		var json = ConsumoApi.obterDados("https://www.omdbapi.com/?t=friends&apikey=602b6f41");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
