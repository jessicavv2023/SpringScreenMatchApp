package com.aluracursos.screenmatch.model;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Episodio {
    private Integer temporada;
    private String titulo;
    private Double calificacion;
    private Integer numeroEpisodio;
    private LocalDate fechaDeLanzamiento;


    public Episodio(Integer numero, DatosEpisodio d ){
        this.temporada = numero;
        this.titulo = d.titulo();
        this.numeroEpisodio = d.numeroDeEpisodio();
        try {
            this.calificacion = Double.valueOf( d.calificacion());
        }catch (NumberFormatException e){
            this.calificacion=0.0;
        }
try{
    this.fechaDeLanzamiento = LocalDate.parse(d.fechaDeLanzamiento()) ;
}catch (DateTimeException e){
    this.fechaDeLanzamiento=null;
}

    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    @Override
    public String toString() {
        return " Este es de la clase Episodio{" +
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", calificacion=" + calificacion +
                ", numeroEpisodio=" + numeroEpisodio +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                '}';
    }
}
