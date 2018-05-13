package axa.egpp.bo.almacen.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axa.egpp.bo.almacen.model.Usuario;
import axa.egpp.bo.almacen.repositorio.UsuarioRepositorio;
import axa.egpp.bo.almacen.servicio.UsuarioServicio;

//gestor de operaciones con SPRING FRAMEWORK 
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	// Con esto indicamos que vaya a buscar una implementacion que se aducue
	@Autowired
	// Se debe acceder al repositorio
	UsuarioRepositorio vUsuarioRepositorio;

	public Usuario AdicionarModificar(Usuario vUsuario) {
		// TODO Auto-generated method stub
		return vUsuarioRepositorio.saveAndFlush(vUsuario);
	}

	public void Eliminar(Integer pIdUsuario) {
		// TODO Auto-generated method stub
		vUsuarioRepositorio.delete(pIdUsuario);
	}

	public Usuario ObtenerPorId(Integer pIdUsuario) {
		// TODO Auto-generated method stub
		return vUsuarioRepositorio.findOne(pIdUsuario);
	}

	public List<Usuario> Lista() {
		// TODO Auto-generated method stub
		return vUsuarioRepositorio.findAll();
	}

}
