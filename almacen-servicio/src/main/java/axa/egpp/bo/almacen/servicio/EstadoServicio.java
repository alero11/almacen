package axa.egpp.bo.almacen.servicio;

import java.util.List;

import axa.egpp.bo.almacen.model.Estado;

public interface EstadoServicio {

	// Metodo que adicionara o modificara si es que tiene el identificador
	Estado AdicionarModificar(Estado vEstado);

	// Metodo que elimina un grupo de producto a traves del identificador
	void Eliminar(Integer pIdEstado);

	// Metodo para obtener por el identificador
	Estado ObtenerPorId(Integer pIdEstado);

	// Lista todo los grupos de producto
	List<Estado> Lista();

}
