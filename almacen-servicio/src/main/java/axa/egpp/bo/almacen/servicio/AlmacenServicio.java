package axa.egpp.bo.almacen.servicio;

import java.util.List;

import axa.egpp.bo.almacen.model.Almacen;

public interface AlmacenServicio {
	
	// Metodo que adicionara o modificara si es que tiene el identificador
	Almacen AdicionarModificar(Almacen vAlmacen);

	// Metodo que elimina un grupo de producto a traves del identificador
	void Eliminar(Integer pIdAlmacen);

	// Metodo para obtener por el identificador
	Almacen ObtenerPorId(Integer pIdAlmacen);

	// Lista todo los grupos de producto
	List<Almacen> Lista();
}
