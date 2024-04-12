package com.matinsa.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    private String codigo;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    private String descripcion;
    @Column(name = "tipo_producto")
    private int tipoProducto;

    @ManyToOne
    @JoinColumn(name = "id_unidad")
    private Unidad unidad;

    @ManyToOne
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    private int cantidad;
    private Boolean estado= Boolean.FALSE;



}
