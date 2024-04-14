package com.matinsa.backend.services;

import com.matinsa.backend.dto.ProductoDto;
import com.matinsa.backend.entities.Producto;
import com.matinsa.backend.security.dto.Mensaje;

import java.util.List;

public interface ProductoService extends ICrud<Producto, ProductoDto>{

    List<Producto> findAllProductsByCategoria(Long id);

    List<Producto> findAllMateriaPrima();

}
