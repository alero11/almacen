package axa.egpp.bo.almacen.servicio;

import java.util.List;

import axa.egpp.bo.almacen.model.Usuario;

public interface UsuarioServicio {

	// Metodo que adicionara o modificara si es que tiene el identificador
	Usuario AdicionarModificar(Usuario vUsuario);

	// Metodo que elimina un grupo de producto a traves del identificador
	void Eliminar(Integer pIdUsuario);

	// Metodo para obtener por el identificador
	Usuario ObtenerPorId(Integer pIdUsuario);

	// Lista todo los grupos de producto
	List<Usuario> Lista();
}
