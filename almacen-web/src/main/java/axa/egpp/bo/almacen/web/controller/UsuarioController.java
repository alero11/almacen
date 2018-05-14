package axa.egpp.bo.almacen.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import axa.egpp.bo.almacen.model.Usuario;
import axa.egpp.bo.almacen.servicio.UsuarioServicio;


public class UsuarioController {
	
	@Autowired
	UsuarioServicio vUsuarioServicio;
	
	public List<Usuario> ListarUsuario(){
		return	vUsuarioServicio.Lista();
	}
	
	public Usuario ObtenerPorIdUsuario(Integer pIdUsuario) {
		return vUsuarioServicio.ObtenerPorId(pIdUsuario);
	}
	
	public Usuario AgregarUsuario(Usuario pUsuario) {
		return vUsuarioServicio.AdicionarModificar(pUsuario);
	}
	
	public Usuario ModificarUsuario(Usuario pUsuario) {
		return vUsuarioServicio.AdicionarModificar(pUsuario);
	}
	
	public String EliminarUsuario(Integer pIdUsuario) {
		vUsuarioServicio.Eliminar(pIdUsuario);
		return "Se ha eliminado correctamente ";
	}

}
