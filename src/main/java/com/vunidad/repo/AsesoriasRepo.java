package com.vunidad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vunidad.modelo.Asesorias;


@Repository
public interface AsesoriasRepo extends JpaRepository<Asesorias, Long>{

}
