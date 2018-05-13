package axa.egpp.bo.almacen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alm_estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_estado")
	private int IdEstado;
	@Column(name = "nombre_estado", length = 50, nullable = false)
	private String NombreEstado;
	@Column(name = "descripcion_estado", length = 200, nullable = false)
	private String DescripcionEstado;

	public int getIdEstado() {
		return IdEstado;
	}

	public void setIdEstado(int idEstado) {
		IdEstado = idEstado;
	}

	public String getNombreEstado() {
		return NombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		NombreEstado = nombreEstado;
	}

	public String getDescripcionEstado() {
		return DescripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		DescripcionEstado = descripcionEstado;
	}
}
