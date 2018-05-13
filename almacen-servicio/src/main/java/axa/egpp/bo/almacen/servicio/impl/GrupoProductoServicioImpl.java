package axa.egpp.bo.almacen.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import axa.egpp.bo.almacen.model.GrupoProducto;
import axa.egpp.bo.almacen.repositorio.GrupoProductoRepositorio;
import axa.egpp.bo.almacen.servicio.GrupoProductoServicio;

// gestor de operaciones con SPRING FRAMEWORK 
@Service
public class GrupoProductoServicioImpl implements GrupoProductoServicio {

	// Con esto indicamos que vaya a buscar una implementacion que se aducue
	@Autowired
	// Se debe acceder al repositorio
	GrupoProductoRepositorio vGrupoProductoRepositorio;
	
	public GrupoProducto AdicionarModificar(GrupoProducto vGrupoProducto) {
		// TODO Auto-generated method stub
		return vGrupoProductoRepositorio.saveAndFlush(vGrupoProducto);
	}
	
	@Transactional
	public void Eliminar(Integer pIdGrupoProducto) {
		// TODO Auto-generated method stub
		vGrupoProductoRepositorio.delete(pIdGrupoProducto);
	}

	@Transactional
	public GrupoProducto ObtenerPorId(Integer pIdGrupoProducto) {
		// TODO Auto-generated method stub
		return vGrupoProductoRepositorio.findOne(pIdGrupoProducto);
	}

	public List<GrupoProducto> Lista() {
		// TODO Auto-generated method stub
		return vGrupoProductoRepositorio.findAll();
	}

}
