package axa.egpp.bo.almacen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import axa.egpp.bo.almacen.model.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
