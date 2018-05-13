package axa.egpp.bo.almacen.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axa.egpp.bo.almacen.model.Estado;
import axa.egpp.bo.almacen.repositorio.EstadoRepositorio;
import axa.egpp.bo.almacen.servicio.EstadoServicio;

//gestor de operaciones con SPRING FRAMEWORK
@Service
public class EstadoServicioImpl implements EstadoServicio {

	// Con esto indicamos que vaya a buscar una implementacion que se aducue
	@Autowired
	// Se debe acceder al repositorio
	EstadoRepositorio vEstadoRepositorio;

	public Estado AdicionarModificar(Estado vEstado) {
		// TODO Auto-generated method stub
		return vEstadoRepositorio.saveAndFlush(vEstado);
	}

	public void Eliminar(Integer pIdEstado) {
		// TODO Auto-generated method stub
		vEstadoRepositorio.delete(pIdEstado);
	}

	public Estado ObtenerPorId(Integer pIdEstado) {
		// TODO Auto-generated method stub
		return vEstadoRepositorio.findOne(pIdEstado);
	}

	public List<Estado> Lista() {
		// TODO Auto-generated method stub
		return vEstadoRepositorio.findAll();
	}

}
