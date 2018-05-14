package axa.egpp.bo.almacen.model;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alm_proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_proveedor")
	private int IdProveedor;
	@Column(name = "nombre_proveedor", length = 250, nullable = false)
	private String NombreProveedor;
	@Column(name = "direccion_proveedor", length = 200, nullable = false)
	private String DireccionProveedor;
	@Column(name = "telefono_proveedor", length = 20, nullable = true)
	private String TelefonoProveedor;
	@Column(name = "correo_proveedor", length = 50, nullable = true)
	private String CorreoProveedor;
	@Column(name = "nit_proveedor", length = 50, nullable = false)
	private String NitProveedor;
	@Column(name = "matricula_proveedor", length = 150, nullable = false)
	private String MatriculaProveedor;
	@Column(name = "nombre_representante", length = 100, nullable = false)
	private String NombreRepresentante;
	@Column(name = "telefono_representante", length = 20, nullable = true)
	private String TelefonoRepresentante;
	@Column(name = "fecha_ingreso", columnDefinition = "TIMESTAMPTZ", nullable = false)
	private Calendar FechaIngreso;

	public int getIdProveedor() {
		return IdProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		IdProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return NombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		NombreProveedor = nombreProveedor;
	}

	public String getDireccionProveedor() {
		return DireccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		DireccionProveedor = direccionProveedor;
	}

	public String getTelefonoProveedor() {
		return TelefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		TelefonoProveedor = telefonoProveedor;
	}

	public String getCorreoProveedor() {
		return CorreoProveedor;
	}

	public void setCorreoProveedor(String correoProveedor) {
		CorreoProveedor = correoProveedor;
	}

	public String getNitProveedor() {
		return NitProveedor;
	}

	public void setNitProveedor(String nitProveedor) {
		NitProveedor = nitProveedor;
	}

	public String getMatriculaProveedor() {
		return MatriculaProveedor;
	}

	public void setMatriculaProveedor(String matriculaProveedor) {
		MatriculaProveedor = matriculaProveedor;
	}

	public String getNombreRepresentante() {
		return NombreRepresentante;
	}

	public void setNombreRepresentante(String nombreRepresentante) {
		NombreRepresentante = nombreRepresentante;
	}

	public String getTelefonoRepresentante() {
		return TelefonoRepresentante;
	}

	public void setTelefonoRepresentante(String telefonoRepresentante) {
		TelefonoRepresentante = telefonoRepresentante;
	}

	public Calendar getFechaIngreso() {
		return FechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}
}
