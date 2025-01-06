package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties (ignoreUnknown = true)
public record DatosEpisodio(

    @JsonAlias("Title")  String titulo,
    @JsonAlias("Episode") String numeroDeEpisodio,
    @JsonAlias("imdbRating") String calificacion,
    @JsonAlias("Released") String fechaDeLanzamiento)
    {}
