package com.mejiasweb.service;

import com.mejiasweb.model.Persona;

import java.util.List;



public interface IPersonaService {

    void registrar(Persona per);
    void modificar(Persona per);
    void eliminar(Integer id);
    List<Persona> listar();
//    Optional<Persona> listarId(int id);
    Persona listarId(int id);

}
