package com.alura.screensound;

import com.alura.screensound.entidades.Artista;
import com.alura.screensound.programa.Programa;
import com.alura.screensound.repository.ArtistaRepository;
import com.alura.screensound.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository artistaRepository;

	@Autowired
	private MusicaRepository musicaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Programa programa = new Programa(artistaRepository, musicaRepository);
		programa.iniciarPrograma();
	}
}
