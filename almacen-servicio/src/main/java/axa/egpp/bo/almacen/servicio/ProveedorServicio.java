package axa.egpp.bo.almacen.servicio;

import java.util.List;

import axa.egpp.bo.almacen.model.Proveedor;

public interface ProveedorServicio {
	
	// Metodo que adicionara o modificara si es que tiene el identificador
	Proveedor AdicionarModificar(Proveedor vProveedor);

	// Metodo que elimina un grupo de producto a traves del identificador
	void Eliminar(Integer pIdProveedor);

	// Metodo para obtener por el identificador
	Proveedor ObtenerPorId(Integer pIdProveedor);

	// Lista todo los grupos de producto
	List<Proveedor> Lista();
}
