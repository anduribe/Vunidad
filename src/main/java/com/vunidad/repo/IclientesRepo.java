package com.vunidad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.vunidad.modelo.Iclientes;


@Repository
public interface IclientesRepo extends JpaRepository<Iclientes, Long>{

}
