package axa.egpp.bo.almacen.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alm_almacen")
public class Almacen {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_almacen")
	private int IdAlmacen;
	@Column(name = "id_padre_almacen", nullable = true)
	private int IdPadreAlmacen;
	@Column(name = "id_proveedor", nullable = false)
	private int IdProveedor;
	@Column(name = "id_producto", nullable = false)
	private int IdProducto;
	@Column(name = "id_grupo_producto", nullable = false)
	private int IdGrupoProducto;
	@Column(name = "del", nullable = false)
	private int Del;
	@Column(name = "al", nullable = false)
	private int Al;
	@Column(name = "cantidad", nullable = false)
	private int Cantidad;
	@Column(name = "precio_venta", scale = 15, precision = 2, nullable = false)
	private Number PrecioVenta;
	@Column(name = "precio_por_mayor", scale = 15, precision = 2, nullable = false)
	private Number PrecioPorMayor;
	@Column(name = "id_usuario", nullable = false)
	private int IdUsuario;
	@Column(name = "rol_usuario", length = 50, nullable = false)
	private int RolUsuario;
	@Column(name = "activo", nullable = false)
	private boolean Activo;
	@Column(name = "observacion", length = 250, nullable = false)
	private String Observacion;
	@Column(name = "fecha", columnDefinition = "TIMESTAMPTZ", nullable = false)
	private Calendar Fecha;

	public int getIdAlmacen() {
		return IdAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		IdAlmacen = idAlmacen;
	}

	public int getIdPadreAlmacen() {
		return IdPadreAlmacen;
	}

	public void setIdPadreAlmacen(int idPadreAlmacen) {
		IdPadreAlmacen = idPadreAlmacen;
	}

	public int getIdProveedor() {
		return IdProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		IdProveedor = idProveedor;
	}

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public int getIdGrupoProducto() {
		return IdGrupoProducto;
	}

	public void setIdGrupoProducto(int idGrupoProducto) {
		IdGrupoProducto = idGrupoProducto;
	}

	public int getDel() {
		return Del;
	}

	public void setDel(int del) {
		Del = del;
	}

	public int getAl() {
		return Al;
	}

	public void setAl(int al) {
		Al = al;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public Number getPrecioVenta() {
		return PrecioVenta;
	}

	public void setPrecioVenta(Number precioVenta) {
		PrecioVenta = precioVenta;
	}

	public Number getPrecioPorMayor() {
		return PrecioPorMayor;
	}

	public void setPrecioPorMayor(Number precioPorMayor) {
		PrecioPorMayor = precioPorMayor;
	}

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public int getRolUsuario() {
		return RolUsuario;
	}

	public void setRolUsuario(int rolUsuario) {
		RolUsuario = rolUsuario;
	}

	public boolean isActivo() {
		return Activo;
	}

	public void setActivo(boolean activo) {
		Activo = activo;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
	}

	public Calendar getFecha() {
		return Fecha;
	}

	public void setFecha(Calendar fecha) {
		Fecha = fecha;
	}
}
