package com.matinsa.backend.services;

import com.matinsa.backend.dto.OrdenProduccionDto;
import com.matinsa.backend.entities.OrdenProduccion;
import com.matinsa.backend.security.dto.Mensaje;

import java.time.LocalDate;

public interface OrdenProducionService extends ICrud<OrdenProduccion, OrdenProduccionDto>{

    public Mensaje finalizarOrdenProduccion(Long idOrden, LocalDate fechaFinalizacion);

}
