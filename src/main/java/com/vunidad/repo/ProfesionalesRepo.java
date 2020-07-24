package com.vunidad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.vunidad.modelo.Profesionales;


@Repository
public interface ProfesionalesRepo extends JpaRepository<Profesionales, Long>{

}
