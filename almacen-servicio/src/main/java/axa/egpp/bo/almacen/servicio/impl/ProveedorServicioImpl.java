package axa.egpp.bo.almacen.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axa.egpp.bo.almacen.model.Proveedor;
import axa.egpp.bo.almacen.repositorio.ProveedorRepositorio;
import axa.egpp.bo.almacen.servicio.ProveedorServicio;

//gestor de operaciones con SPRING FRAMEWORK 
@Service
public class ProveedorServicioImpl implements ProveedorServicio {

	// Con esto indicamos que vaya a buscar una implementacion que se aducue
	@Autowired
	// Se debe acceder al repositorio
	ProveedorRepositorio vProveedorRepositorio;
	
	public Proveedor AdicionarModificar(Proveedor vProveedor) {
		// TODO Auto-generated method stub
		return vProveedorRepositorio.saveAndFlush(vProveedor);
	}

	public void Eliminar(Integer pIdProveedor) {
		// TODO Auto-generated method stub
		vProveedorRepositorio.delete(pIdProveedor);
	}

	public Proveedor ObtenerPorId(Integer pIdProveedor) {
		// TODO Auto-generated method stub
		return vProveedorRepositorio.findOne(pIdProveedor);
	}

	public List<Proveedor> Lista() {
		// TODO Auto-generated method stub
		return vProveedorRepositorio.findAll();
	}

}
