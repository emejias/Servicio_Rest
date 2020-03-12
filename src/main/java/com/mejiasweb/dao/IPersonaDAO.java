package com.mejiasweb.dao;
import com.mejiasweb.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;


@Repository
public interface IPersonaDAO extends JpaRepository<Persona, Serializable> {
    Persona findByIdpersona(int id);
}
