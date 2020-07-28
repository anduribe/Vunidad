package com.vunidad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.vunidad.modelo.Checklist;


@Repository
public interface ChecklistRepo extends JpaRepository<Checklist, Long>{

}
