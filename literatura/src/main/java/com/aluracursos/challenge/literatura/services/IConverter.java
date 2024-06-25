package com.aluracursos.challenge.literatura.services;

public interface IConverter {
    <T> T obtenerDatos(String json, Class<T> clase);
}
