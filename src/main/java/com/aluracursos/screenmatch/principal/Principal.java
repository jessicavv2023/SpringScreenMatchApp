package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
private Scanner teclado = new Scanner(System.in);
private ConsumoAPI consumiAPI = new ConsumoAPI();

private final String URL_Base = "http://www.omdbapi.com/?apikey=5bcc6528&t=";
private ConvierteDatos conversor = new ConvierteDatos();
public void muestraElMenu (){
    System.out.println("Introduce el nombre de la serie");
var serie = teclado.nextLine();
    var json = consumiAPI.obtenerDatos( URL_Base + serie.replace(" ", "+"));
    //aqui se cconvierten los datos en tipo java

    DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
    System.out.println( "Datos de la serie "+ datos);

////busca datos de todas las temporadas
    List <DatosTemporadas> temporadas = new ArrayList<>();

        for (int i =1; i<= datos.totalDeTemporadas(); i++ ){
            json =consumiAPI.obtenerDatos(URL_Base + serie.replace(" ", "+") + "&Season=" + i );
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }
      //  temporadas.forEach(System.out::println);

//    System.out.println( "*****Muestra solo el titulo de los episodios por temporadas ******");
//    //Mostrar solo el titulo de los episodios para las temporadas
//        for (int i = 0; i < datos.totalDeTemporadas(); i++) {
//        List<DatosEpisodio> episodiosDeTemporadas = temporadas.get(i).episodio();
//        for (int j = 0; j < episodiosDeTemporadas.size(); j++) {
//            System.out.println( "Nombre del episodio: " + episodiosDeTemporadas.get(j).titulo());
//        }
//    }

//
//        // Convertir todas las informaciones a una lista del tipo DatosEpisodio
//List <DatosEpisodio> datosEpisodios = temporadas.stream()
//        // .flatMap para convertir cada uno de los elementos que esta dentrro de cada tenporda en un
//        // de tipos de episodio
//           .flatMap(t -> t.episodio().stream())
//        // collect.Collectors.toList da una lista mutabale y con toList solo es inmutable
//        .collect(Collectors.toList());
//
//
//
////    // Top 5 episodios
//    System.out.println("******Los mejores 5 episodios*****");
//    datosEpisodios.stream()
//            //filtro para que solo laas calificaiones uqe n osean N/A cuenten para hacer la lista
//            .filter(e -> !e.calificacion(). equalsIgnoreCase("N/A"))
//            //peek para ver como hace java cada paso de logica
//            .peek(e -> System.out.println("quita los N/A " + e ))
//            //.sorted ordena de menor a mayor, se usa reversed para que el orden de la lista sea de mayor a menor
//            .sorted(Comparator.comparing(DatosEpisodio::calificacion ).reversed())
//            .peek(e -> System.out.println("Ordena de Mayor a menor " + e))
//            //para imitar a los 5 primeros resultados
//            .limit(5)
//            .forEach(System.out::println);
//    System.out.println("**** Conviertee los datos a una lista de tipo episodio****");
// Covniertiendo los datos a una lista tipo episodio
    List <Episodio> episodios = temporadas.stream()
    //cada elemento de la lista de tempora se va convertir en tipo Episodio
    .flatMap(t -> t.episodio().stream()
            //se crea un contrucotr en clase Episodio para uqe aqui no dde error
            .map (d -> new Episodio(t.numeroDeTemporada(), d )))
            .limit(10)
            .collect(Collectors.toList());
// episodios.forEach( System.out::println);
//
//
//
////busqueda de episodio a partir del año
//    System.out.println("Igresa el año a partir de cual deseas buscar el capitulo de la serie ");
//    var añoEpisodio = teclado.nextInt();
//    teclado.nextLine();
//
//    // se crea fecha de bsuqueda a paritr de loque ingresa el usuario
//    LocalDate fechaBusqueda =LocalDate.of(añoEpisodio, 1 , 1);
////    System.out.println("**** Conviertee los datos a una lista de tipo episodio****");
//// Covniertiendo los datos a una lista tipo episodio
//    List <Episodio> episodios = temporadas.stream()
//    //cada elemento de la lista de tempora se va convertir en tipo Episodio
//    .flatMap(t -> t.episodio().stream()
//            //se crea un contrucotr en clase Episodio para uqe aqui no dde error
//            .map (d -> new Episodio(t.numeroDeTemporada(), d )))
//            .limit(10)
//            .collect(Collectors.toList());
//// episodios.forEach( System.out::println);
////
////
////
//////busqueda de episodio a partir del año
////    System.out.println("Igresa el año a partir de cual deseas buscar el capitulo de la serie ");
////    var añoEpisodio = teclado.nextInt();
////    teclado.nextLine();
////
////    // se crea fecha de bsuqueda a paritr de loque ingresa el usuario
////    LocalDate fechaBusqueda =LocalDate.of(añoEpisodio, 1 , 1);
////
////    // para cambiar el estipo de fecha de lanzamiento
////    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
////
////    episodios.stream()
////            .filter( e -> e.getFechaDeLanzamiento()  != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
////            .forEach(e -> System.out.println(
////                    " **Temporada ** " + e.getTemporada() + " **Episodio** " + e.getTitulo() +
////                            " **Calificacion** " + e.getCalificacion() + " **Fecha de lanzamineto** " + e.getFechaDeLanzamiento().format(dtf)
////            ));
//
//
//
//    // Busca episodio por pedazos del titulo
//    while (true) {
//    System.out.println("Ingrgesa el nombre del Episodio");
//    var pedazoEpisodio = teclado.nextLine();
//    Optional<Episodio> episodioBuscado = episodios.stream()
//            .filter( e -> e.getTitulo().toUpperCase().contains(pedazoEpisodio.toUpperCase()))
//            //.findFirst es para que siempre bsuqe el primer resultado que coincida ocn los parmetros
//            .findFirst();
//    //.isPresent es para ver si el titulo del episodio que ingresa el usario
//    //coincide con algo de la base de datos
//
//        if (episodioBuscado.isPresent()) {
//            System.out.println("Episodio encontrado");
//            System.out.println(episodioBuscado.get());
//            break;
//        } else {
//            System.out.println("Episodio no encontrado, intente de nuevo");
//        }
//    }
//    // para cambiar el estipo de fecha de lanzamiento
//    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//    episodios.stream()
//            .filter( e -> e.getFechaDeLanzamiento()  != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
//            .forEach(e -> System.out.println(
//                    " **Temporada ** " + e.getTemporada() + " **Episodio** " + e.getTitulo() +
//                            " **Calificacion** " + e.getCalificacion() + " **Fecha de lanzamineto** " + e.getFechaDeLanzamiento().format(dtf)
//            ));



    // Busca episodio por pedazos del titulo
//    while (true) {
//    System.out.println("Ingrgesa el nombre del Episodio");
//    var pedazoEpisodio = teclado.nextLine();
//    Optional<Episodio> episodioBuscado = episodios.stream()
//            .filter( e -> e.getTitulo().toUpperCase().contains(pedazoEpisodio.toUpperCase()))
//            //.findFirst es para que siempre bsuqe el primer resultado que coincida ocn los parmetros
//            .findFirst();
//    //.isPresent es para ver si el titulo del episodio que ingresa el usario
//    //coincide con algo de la base de datos
//
//        if (episodioBuscado.isPresent()) {
//            System.out.println("Episodio encontrado");
//            System.out.println(episodioBuscado.get());
//            break;
//        } else {
//            System.out.println("Episodio no encontrado, intente de nuevo");
//        }
//    }

// map tiene una llave y un valor
    Map <Integer, Double>  evaluacionesPorTemporada = episodios.stream()
            .filter(e -> e.getCalificacion()>0.0)
//groupingBy es para traer los datoss de la tmeporada y agruparlos
            .collect(Collectors.groupingBy(Episodio::getTemporada,
                    Collectors.averagingDouble(Episodio::getCalificacion)));
    System.out.println(evaluacionesPorTemporada);

// Para estadisticas
    DoubleSummaryStatistics est = episodios.stream()
            .filter(e -> e.getCalificacion()>0.0)
            .collect(Collectors.summarizingDouble(Episodio::getCalificacion));
    System.out.println( "Media de evaluaciones: " + est.getCount());
    System.out.println("Mwjor evaluado: " + est.getMax());
    System.out.println("Peero evaluado: " + est.getMin());
}
}
