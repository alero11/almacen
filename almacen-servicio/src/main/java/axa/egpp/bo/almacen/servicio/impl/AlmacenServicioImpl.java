package axa.egpp.bo.almacen.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axa.egpp.bo.almacen.model.Almacen;
import axa.egpp.bo.almacen.repositorio.AlmacenRepositorio;
import axa.egpp.bo.almacen.servicio.AlmacenServicio;

//gestor de operaciones con SPRING FRAMEWORK
@Service
public class AlmacenServicioImpl implements AlmacenServicio {

	// Con esto indicamos que vaya a buscar una implementacion que se aducue
	@Autowired
		// Se debe acceder al repositorio
	AlmacenRepositorio vAlmacenRepositorio;

	public Almacen AdicionarModificar(Almacen vAlmacen) {
		// TODO Auto-generated method stub
		return vAlmacenRepositorio.saveAndFlush(vAlmacen);
	}

	public void Eliminar(Integer pIdAlmacen) {
		// TODO Auto-generated method stub
		vAlmacenRepositorio.delete(pIdAlmacen);
	}

	public Almacen ObtenerPorId(Integer pIdAlmacen) {
		// TODO Auto-generated method stub
		return vAlmacenRepositorio.findOne(pIdAlmacen);
	}

	public List<Almacen> Lista() {
		// TODO Auto-generated method stub
		return vAlmacenRepositorio.findAll();
	}

}
