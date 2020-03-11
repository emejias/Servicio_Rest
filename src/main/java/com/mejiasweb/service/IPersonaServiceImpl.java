package com.mejiasweb.service;

import com.mejiasweb.dao.IPersonaDAO;
import com.mejiasweb.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IPersonaServiceImpl implements IPersonaService {


    @Autowired
    private IPersonaDAO personaDAO;



    @Override
    public void registrar(Persona per) {

        personaDAO.save(per);

    }

    @Override
    public void modificar(Persona per) {
            personaDAO.save(per);
    }

    @Override
    public void eliminar(Integer id) {

        personaDAO.deleteById(id);

    }

    @Override
    public List<Persona> listar() {
//
//        List<Persona> lista = new ArrayList<>();
//        lista.add(new Persona(1,"Jaime", "Medina", 27));
//        lista.add(new Persona(2,"Mito", "Medina", 26));
//        lista.add(new Persona(3,"Code", "Medina", 25));

        return personaDAO.findAll();

//        return lista;
    }

//    @Override
//    public Optional<Persona> listarId(int id) {
////        return Optional.empty();
//
//        return personaDAO.findById(id);
//    }

    @Override
    public Persona listarId(int idpersona) {
//        return personaDAO.delete(id);

//        Persona persona = new Persona();
//        List<T> findAllById(Iterable<ID> var1);
      return personaDAO.findByIdpersona(idpersona);

//    return null;
    }
}
