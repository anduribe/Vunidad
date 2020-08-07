package com.vunidad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.vunidad.modelo.CPclientes;


@Repository
public interface CPclientesRepo extends JpaRepository<CPclientes, Long>{

}
