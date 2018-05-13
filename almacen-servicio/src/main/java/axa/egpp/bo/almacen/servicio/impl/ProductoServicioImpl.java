package axa.egpp.bo.almacen.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axa.egpp.bo.almacen.model.Producto;
import axa.egpp.bo.almacen.repositorio.ProductoRepositorio;
import axa.egpp.bo.almacen.servicio.ProductoServicio;

//gestor de operaciones con SPRING FRAMEWORK 
@Service
public class ProductoServicioImpl implements ProductoServicio {

	// Con esto indicamos que vaya a buscar una implementacion que se aducue
	@Autowired
	// Se debe acceder al repositorio
	ProductoRepositorio vProductoRepositorio;

	public Producto AdicionarModificar(Producto vProducto) {
		// TODO Auto-generated method stub
		return vProductoRepositorio.saveAndFlush(vProducto);
	}

	public void Eliminar(Integer pIdProducto) {
		// TODO Auto-generated method stub
		vProductoRepositorio.delete(pIdProducto);
	}

	public Producto ObtenerPorId(Integer pIdProducto) {
		// TODO Auto-generated method stub
		return vProductoRepositorio.findOne(pIdProducto);
	}

	public List<Producto> Lista() {
		// TODO Auto-generated method stub
		return vProductoRepositorio.findAll();
	}

}
