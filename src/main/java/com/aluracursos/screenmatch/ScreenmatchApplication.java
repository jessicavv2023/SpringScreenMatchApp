package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		//SpringAplication.run inicia la aplicacion y el contexto de Spring
		SpringApplication.run(ScreenmatchApplication.class, args);
		//ScreenmatchApplication.class es la clase prinicpal que contiene la ocnfiguracion de la aplicacion
	}
// este metodo run  sale de implements CommandLineRunner, se ejecuta despues de que el que contiene el
	//contexto de SpringBoot este completamente cargado
	@Override
	public void run(String... args) throws Exception {
//		var consumiAPI = new ConsumoAPI();
////		var json = consumiAPI.obtenerDatos("http://www.omdbapi.com/?apikey=5bcc6528&t=gossip+girl&Season=1");
//		System.out.println(json);
//
//		ConvierteDatos conversor = new ConvierteDatos ();
//		// se epecifica que los datos json los va a convertir en tipo  DAtosSerie
//var datos = conversor.obtenerDatos(json, DatosSerie.class);
//		System.out.println(datos);
//
//		var jsonn = consumiAPI.obtenerDatos("http://www.omdbapi.com/?apikey=5bcc6528&t=gossip+girl&Season=1&Episode=1");
//		DatosEpisodio episodio = conversor.obtenerDatos (jsonn, DatosEpisodio.class);
//		System.out.println(episodio);

		Principal principal = new Principal();
		 principal.muestraElMenu();
	}




}
