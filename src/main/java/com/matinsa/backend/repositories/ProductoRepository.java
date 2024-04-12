package com.matinsa.backend.repositories;

import com.matinsa.backend.entities.Producto;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

    @Query(value = "SELECT count(id_producto) from producto WHERE tipo_producto=:tipo",nativeQuery = true)
    Long getCorrelativo(@PathParam("tipo") int tipo);

    boolean existsByNombreProducto(String nombre);
}
