package com.vunidad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vunidad.modelo.Mejoras;

@Repository
public interface MejorasRepo extends JpaRepository<Mejoras, Long>{

}
