package com.vunidad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vunidad.modelo.Accidentabilidad;



@Repository
public interface AccidentabilidadRepo extends JpaRepository<Accidentabilidad, Long>{

}
