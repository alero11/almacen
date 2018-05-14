package axa.egpp.bo.almacen.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import axa.egpp.bo.almacen.model.Almacen;
import axa.egpp.bo.almacen.servicio.AlmacenServicio;

/**
 * Servlet implementation class AlmacenServlet
 */
public class AlmacenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	AlmacenServicio vAlmacenServicio;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlmacenServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String vOperacion = request.getParameter("op");
			if (vOperacion == null) {
				response.getWriter().append("De indicar en el QUERY que tipo de operacion (CRUD) desea realizar");
				response.getWriter().append("Ejemplo de listado: ?op=L<br />");
				response.getWriter().append(
						"Ejemplo de creacion: ?op=A&NumeroDocumento=vCI&Nombre=vNombre&PrimerApellido=vPrimerApellido&SegundoApellido=vSegundoApellido&Celular=vCelular<br />");
				response.getWriter().append(
						"Ejemplo de actualización: ?op=M&IdAlmacen=vIdAlmacen&NumeroDocumento=vCI&Nombre=vNombre&PrimerApellido=vPrimerApellido&SegundoApellido=vSegundoApellido&Celular=vCelular<br />");
				response.getWriter().append("Ejemplo de borrado: ?op=E&IdAlmacen=vIdAlmacen<br />");
				response.getWriter().append("Ejemplo de obtener por Id: ?op=O&IdAlmacen=vIdAlmacen<br />");
				return;
			}
			//
			WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext())
					.getAutowireCapableBeanFactory().autowireBean(this);

			// Instanciamos el objeto.
			StringBuilder vStr = new StringBuilder();

			// Listar Almacens
			if ("L".equals(vOperacion)) {
				List<Almacen> vListaAlmacen = vAlmacenServicio.Lista();
				vStr.append("<table border=\"1\"><tr><th>ID</th><th>CI</th><th>Nombres</th></tr>");
				for (Almacen vAlmacen : vListaAlmacen) {
					vStr.append("<tr><td>").append(vAlmacen.getIdAlmacen()).append("</td><td>")
							.append(vAlmacen.getIdPadreAlmacen()).append("</td><td>").append(vAlmacen.getIdProveedor())
							.append("</td><td>").append(vAlmacen.getIdProducto()).append("</td><td>")
							.append(vAlmacen.getIdGrupoProducto()).append("</td><td>").append(vAlmacen.getDel())
							.append("</td><td>").append(vAlmacen.getAl()).append("</td><td>")
							.append(vAlmacen.getCantidad()).append("</td><td>").append(vAlmacen.getPrecioVenta())
							.append("</td><td>").append(vAlmacen.getPrecioPorMayor()).append("</td><td>")
							.append(vAlmacen.getIdUsuario()).append("</td><td>").append(vAlmacen.getRolUsuario())
							.append("</td><td>").append(vAlmacen.isActivo()).append("</td><td>")
							.append(vAlmacen.getObservacion()).append("</td><td>").append(vAlmacen.getFecha())
							.append("</td></tr>");
				}
				vStr.append("</table>");
			}
			// Adicionar o Modificar Almacens
			if ("A".equals(vOperacion)) {
				String vIdPadreAlmacen = request.getParameter("IdPadreAlmacen");
				String vIdProveedor = request.getParameter("IdProveedor");
				String vIdProducto = request.getParameter("IdProducto");
				String vIdGrupoProducto = request.getParameter("IdGrupoProducto");
				String vDel = request.getParameter("Del");
				String vAl = request.getParameter("Al");
				String vCantidad = request.getParameter("Cantidad");
				String vPrecioVenta = request.getParameter("PrecioVenta");
				String vPrecioPorMayor = request.getParameter("PrecioPorMayor");
				String vIdUsuario = request.getParameter("IdUsuario");
				String vRolUsuario = request.getParameter("RolUsuario");
				String vActivo = request.getParameter("Activo");
				String vObservacion = request.getParameter("Observacion");
				String vFecha = request.getParameter("Fecha");
				Almacen vAlmacen = new Almacen();
				vAlmacen.setIdPadreAlmacen(Integer.parseInt(vIdPadreAlmacen));
				vAlmacen.setIdProveedor(Integer.parseInt(vIdProveedor));
				vAlmacen.setIdProducto(Integer.parseInt(vIdProducto));
				vAlmacen.setIdGrupoProducto(Integer.parseInt(vIdGrupoProducto));
				vAlmacen.setDel(Integer.parseInt(vDel));
				vAlmacen.setAl(Integer.parseInt(vAl));
				vAlmacen.setCantidad(Integer.parseInt(vCantidad));
				vAlmacen.setPrecioVenta(Integer.parseInt(vPrecioVenta));
				vAlmacen.setPrecioPorMayor(Integer.parseInt(vPrecioPorMayor));
				vAlmacen.setIdUsuario(Integer.parseInt(vIdUsuario));
				vAlmacen.setRolUsuario(vRolUsuario);
				vAlmacen.setActivo(Boolean.parseBoolean(vActivo));
				vAlmacen.setObservacion(vObservacion);
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(df.parse(vFecha));
				vAlmacen.setFecha(cal);

				vAlmacen = vAlmacenServicio.AdicionarModificar(vAlmacen);
				vStr.append("Almacen agregado correctamente con el ID: " + vAlmacen.getIdAlmacen());
			}

			// Actualizar el Almacen
			if ("M".equals(vOperacion)) {
				int vIdAlmacen = Integer.parseInt(request.getParameter("IdAlmacen"));
				String vIdPadreAlmacen = request.getParameter("IdPadreAlmacen");
				String vIdProveedor = request.getParameter("IdProveedor");
				String vIdProducto = request.getParameter("IdProducto");
				String vIdGrupoProducto = request.getParameter("IdGrupoProducto");
				String vDel = request.getParameter("Del");
				String vAl = request.getParameter("Al");
				String vCantidad = request.getParameter("Cantidad");
				String vPrecioVenta = request.getParameter("PrecioVenta");
				String vPrecioPorMayor = request.getParameter("PrecioPorMayor");
				String vIdUsuario = request.getParameter("IdUsuario");
				String vRolUsuario = request.getParameter("RolUsuario");
				String vActivo = request.getParameter("Activo");
				String vObservacion = request.getParameter("Observacion");
				String vFecha = request.getParameter("Fecha");

				Almacen vAlmacen = new Almacen();

				vAlmacen.setIdAlmacen(vIdAlmacen);
				vAlmacen.setIdPadreAlmacen(Integer.parseInt(vIdPadreAlmacen));
				vAlmacen.setIdProveedor(Integer.parseInt(vIdProveedor));
				vAlmacen.setIdProducto(Integer.parseInt(vIdProducto));
				vAlmacen.setIdGrupoProducto(Integer.parseInt(vIdGrupoProducto));
				vAlmacen.setDel(Integer.parseInt(vDel));
				vAlmacen.setAl(Integer.parseInt(vAl));
				vAlmacen.setCantidad(Integer.parseInt(vCantidad));
				vAlmacen.setPrecioVenta(Integer.parseInt(vPrecioVenta));
				vAlmacen.setPrecioPorMayor(Integer.parseInt(vPrecioPorMayor));
				vAlmacen.setIdUsuario(Integer.parseInt(vIdUsuario));
				vAlmacen.setRolUsuario(vRolUsuario);
				vAlmacen.setActivo(Boolean.parseBoolean(vActivo));
				vAlmacen.setObservacion(vObservacion);
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(df.parse(vFecha));
				vAlmacen.setFecha(cal);

				vAlmacen = vAlmacenServicio.AdicionarModificar(vAlmacen);
				vStr.append("Almacen agregado correctamente con el ID: " + vAlmacen.getIdAlmacen());
			}

			// Eliminar un objeto
			if ("E".equals(vOperacion)) {
				int vIdAlmacen = Integer.parseInt(request.getParameter("IdAlmacen"));
				vAlmacenServicio.Eliminar(vIdAlmacen);
				vStr.append("Almacen eliminado correctamente");
			}

			// Obtener por el identificador
			if ("O".equals(vOperacion)) {
				int vIdAlmacen = Integer.parseInt(request.getParameter("IdAlmacen"));
				Almacen vAlmacen = vAlmacenServicio.ObtenerPorId(vIdAlmacen);
				vStr.append("El Almacen es:").append("<br/>").append("IdAlmacen: " + vAlmacen.getIdAlmacen() + "<br/>")
						.append("IdPadreAlmacen: " + vAlmacen.getIdPadreAlmacen() + "<br/>")
						.append("IdProveedor: " + vAlmacen.getIdProveedor() + "<br/>")
						.append("IdProducto: " + vAlmacen.getIdProducto() + "<br/>")
						.append("IdGrupoProducto: " + vAlmacen.getIdGrupoProducto() + "<br/>")
						.append("Del: " + vAlmacen.getDel() + "<br/>").append("Al: " + vAlmacen.getAl() + "<br/>")
						.append("Cantidad: " + vAlmacen.getCantidad() + "<br/>")
						.append("PrecioVenta: " + vAlmacen.getPrecioVenta() + "<br/>")
						.append("PrecioPorMayor: " + vAlmacen.getPrecioPorMayor() + "<br/>")
						.append("IdUsuario: " + vAlmacen.getIdUsuario() + "<br/>")
						.append("RolUsuario: " + vAlmacen.getRolUsuario() + "<br/>")
						.append("Activo: " + vAlmacen.isActivo() + "<br/>")
						.append("Observacion: " + vAlmacen.getObservacion() + "<br/>")
						.append("Fecha: " + vAlmacen.getFecha() + "<br/>");
			}
			// muestra el resultado.
			response.getWriter().append(vStr.toString());

		} catch (Exception ex) {
			response.getWriter().append("Error: " + ex.getMessage());
			ex.printStackTrace(response.getWriter());
		}
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
