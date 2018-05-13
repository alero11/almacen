package axa.egpp.bo.almacen.servicio;

import java.util.List;

import axa.egpp.bo.almacen.model.GrupoProducto;

public interface GrupoProductoServicio {

	// Metodo que adicionara o modificara si es que tiene el identificador
	GrupoProducto AdicionarModificar(GrupoProducto vGrupoProducto);

	// Metodo que elimina un grupo de producto a traves del identificador
	void Eliminar(Integer pIdGrupoProducto);

	// Metodo para obtener por el identificador
	GrupoProducto ObtenerPorId(Integer pIdGrupoProducto);

	// Lista todo los grupos de producto
	List<GrupoProducto> Lista();

}
