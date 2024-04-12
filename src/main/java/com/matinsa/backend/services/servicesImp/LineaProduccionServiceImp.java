package com.matinsa.backend.services.servicesImp;

import com.matinsa.backend.dto.LineaProduccionDto;
import com.matinsa.backend.entities.Cliente;
import com.matinsa.backend.entities.LineaProduccion;
import com.matinsa.backend.entities.OrdenProduccion;
import com.matinsa.backend.enums.EstadoOrden;
import com.matinsa.backend.repositories.LineaProduccionRepository;
import com.matinsa.backend.repositories.OrdenProduccionRepository;
import com.matinsa.backend.security.dto.Mensaje;
import com.matinsa.backend.security.exceptions.CustomException;
import com.matinsa.backend.services.LineaProduccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineaProduccionServiceImp implements LineaProduccionService {

    private final LineaProduccionRepository lineaProduccionRepository;
    private final OrdenProduccionRepository ordenProduccionRepository;
    private static final int LINEA_ROPA= 1;
    private static final int LINEA_GORRA= 2;

    private OrdenProduccion findOrdenProduccionById(Long id) {
        return ordenProduccionRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.CONFLICT, "La orden de producción con ID " + id + " no existe"));
    }

    @Override
    public Page<LineaProduccion> listar(Pageable pageable) {
        return lineaProduccionRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Mensaje crear(LineaProduccionDto dto) {
        OrdenProduccion ordenProduccion = findOrdenProduccionById(dto.ordenProduccion());
        LineaProduccion lineaProduccion = new LineaProduccion(dto.fechaIngreso(),verificarLineaProduccion(dto.lineaProduccion()),ordenProduccion);
        ordenProduccion.setEstado(EstadoOrden.EN_PROCESO);
        lineaProduccionRepository.save(lineaProduccion);
        return null;
    }

    @Override
    @Transactional
    public Mensaje editar(Long id, LineaProduccionDto dto) {
        return null;
    }

    @Override
    @Transactional
    public Mensaje eliminar(Long id) {
        return null;
    }

    @Override
    public List<LineaProduccion> leer() {
        return null;
    }

    private int verificarLineaProduccion(int lineaProduccion){
        if(lineaProduccion == LINEA_ROPA || lineaProduccion == LINEA_GORRA){
            return lineaProduccion;
        }else{
            throw new CustomException(HttpStatus.BAD_REQUEST, "Lo sentimos, la línea de producción seleccionada no existe en nuestro sistema. Por favor, asegúrate de ingresar un valor válido. Las opciones válidas son: 1 - Línea de Ropa, 2 - Línea de Gorra.");
        }
    }
}
