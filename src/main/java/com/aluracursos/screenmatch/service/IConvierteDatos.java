package com.aluracursos.screenmatch.service;

public interface IConvierteDatos {

 // EL T ES DE GENERICO
    <T> T obtenerDatos (String json, Class   <T> clase);

}









