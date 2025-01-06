package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true) // esto ignora los demas cambpos que no esten asi @JsonAlias("Title") String titulo

public record DatosSerie (
    @JsonAlias("Title") String titulo,
    @JsonAlias("totalSeasons") Integer totalDeTemporadas,
@JsonAlias("imdbRating") float evaluaciones) {

}
