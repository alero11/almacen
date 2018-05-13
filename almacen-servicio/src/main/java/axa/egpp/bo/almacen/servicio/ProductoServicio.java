package axa.egpp.bo.almacen.servicio;

import java.util.List;

import axa.egpp.bo.almacen.model.Producto;

public interface ProductoServicio {
	
	// Metodo que adicionara o modificara si es que tiene el identificador
	Producto AdicionarModificar(Producto vProducto);

	// Metodo que elimina un grupo de producto a traves del identificador
	void Eliminar(Integer pIdProducto);

	// Metodo para obtener por el identificador
	Producto ObtenerPorId(Integer pIdProducto);

	// Lista todo los grupos de producto
	List<Producto> Lista();

}
