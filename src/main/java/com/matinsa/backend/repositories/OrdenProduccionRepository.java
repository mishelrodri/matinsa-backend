package com.matinsa.backend.repositories;

import com.matinsa.backend.entities.OrdenProduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenProduccionRepository extends JpaRepository<OrdenProduccion,Long> {
}
