package axa.egpp.bo.almacen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alm_grupo_producto")
public class GrupoProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_grupo_producto")
	private int IdGrupoProducto;

	@Column(name = "nombre_grupo_producto", length = 50, nullable = false)
	private String NombreGrupoProducto;

	public int getIdGrupoProducto() {
		return IdGrupoProducto;
	}

	public void setIdGrupoProducto(int idGrupoProducto) {
		IdGrupoProducto = idGrupoProducto;
	}

	public String getNombreGrupoProducto() {
		return NombreGrupoProducto;
	}

	public void setNombreGrupoProducto(String nombreGrupoProducto) {
		NombreGrupoProducto = nombreGrupoProducto;
	}
}
