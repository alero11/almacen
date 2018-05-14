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

import axa.egpp.bo.almacen.model.Proveedor;
import axa.egpp.bo.almacen.servicio.ProveedorServicio;

/**
 * Servlet implementation class ProveedorServlet
 */
public class ProveedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	ProveedorServicio vProveedorServicio;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProveedorServlet() {
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
						"Ejemplo de actualización: ?op=M&IdUsuario=vIdUsuario&NumeroDocumento=vCI&Nombre=vNombre&PrimerApellido=vPrimerApellido&SegundoApellido=vSegundoApellido&Celular=vCelular<br />");
				response.getWriter().append("Ejemplo de borrado: ?op=E&IdUsuario=vIdUsuario<br />");
				response.getWriter().append("Ejemplo de obtener por Id: ?op=O&IdUsuario=vIdUsuario<br />");
				return;
			}
			//
			WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext())
					.getAutowireCapableBeanFactory().autowireBean(this);

			// Instanciamos el objeto.
			StringBuilder vStr = new StringBuilder();

			// Listar Usuarios
			if ("L".equals(vOperacion)) {
				List<Proveedor> vListaProveedor = vProveedorServicio.Lista();
				vStr.append("<table border=\"1\"><tr><th>ID</th><th>CI</th><th>Nombres</th></tr>");
				for (Proveedor vProveedor : vListaProveedor) {
					vStr.append("<tr><td>").append(vProveedor.getIdProveedor()).append("</td><td>")
							.append(vProveedor.getNombreProveedor()).append("</td><td>")
							.append(vProveedor.getDireccionProveedor()).append("</td><td>")
							.append(vProveedor.getCorreoProveedor()).append("</td><td>")
							.append(vProveedor.getNitProveedor()).append("</td><td>")
							.append(vProveedor.getMatriculaProveedor()).append("</td><td>")
							.append(vProveedor.getTelefonoProveedor()).append("</td><td>")
							.append(vProveedor.getNombreRepresentante()).append("</td><td>")
							.append(vProveedor.getTelefonoRepresentante()).append("</td><td>")
							.append(vProveedor.getFechaIngreso()).append("</td></tr>");
				}
				vStr.append("</table>");
			}
			// Adicionar o Modificar Usuarios
			if ("A".equals(vOperacion)) {

				String vNombreProveedor = request.getParameter("NombreProveedor");
				String vDireccionProveedor = request.getParameter("DireccionProveedor");
				String vCorreoProveedor = request.getParameter("CorreoProveedor");
				String vNitProveedor = request.getParameter("NitProveedor");
				String vMatriculaProveedor = request.getParameter("MatriculaProveedor");
				String vTelefonoProveedor = request.getParameter("TelefonoProveedor");
				String vNombreRepresentante = request.getParameter("NombreRepresentante");
				String vTelefonoRepresentante = request.getParameter("TelefonoRepresentante");
				String vFechaIngreso = request.getParameter("FechaIngreso");
				Proveedor vProveedor = new Proveedor();
				vProveedor.setNombreProveedor(vNombreProveedor);
				vProveedor.setDireccionProveedor(vDireccionProveedor);
				vProveedor.setCorreoProveedor(vCorreoProveedor);
				vProveedor.setNitProveedor(vNitProveedor);
				vProveedor.setMatriculaProveedor(vMatriculaProveedor);
				vProveedor.setTelefonoProveedor(vTelefonoProveedor);
				vProveedor.setNombreRepresentante(vNombreRepresentante);
				vProveedor.setTelefonoRepresentante(vTelefonoRepresentante);
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(df.parse(vFechaIngreso));
				vProveedor.setFechaIngreso(cal);

				vProveedor = vProveedorServicio.AdicionarModificar(vProveedor);
				vStr.append("Usuario agregado correctamente con el ID: " + vProveedor.getIdProveedor());
			}

			// Actualizar el usuario
			if ("M".equals(vOperacion)) {
				int vIdProveedor = Integer.parseInt(request.getParameter("IdProveedor"));
				String vNombreProveedor = request.getParameter("NombreProveedor");
				String vDireccionProveedor = request.getParameter("DireccionProveedor");
				String vCorreoProveedor = request.getParameter("CorreoProveedor");
				String vNitProveedor = request.getParameter("NitProveedor");
				String vMatriculaProveedor = request.getParameter("MatriculaProveedor");
				String vTelefonoProveedor = request.getParameter("TelefonoProveedor");
				String vNombreRepresentante = request.getParameter("NombreRepresentante");
				String vTelefonoRepresentante = request.getParameter("TelefonoRepresentante");
				String vFechaIngreso = request.getParameter("FechaIngreso");

				Proveedor vProveedor = new Proveedor();
				vProveedor.setIdProveedor(vIdProveedor);
				vProveedor.setNombreProveedor(vNombreProveedor);
				vProveedor.setDireccionProveedor(vDireccionProveedor);
				vProveedor.setCorreoProveedor(vCorreoProveedor);
				vProveedor.setNitProveedor(vNitProveedor);
				vProveedor.setMatriculaProveedor(vMatriculaProveedor);
				vProveedor.setTelefonoProveedor(vTelefonoProveedor);
				vProveedor.setNombreRepresentante(vNombreRepresentante);
				vProveedor.setTelefonoRepresentante(vTelefonoRepresentante);
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(df.parse(vFechaIngreso));
				vProveedor.setFechaIngreso(cal);

				vProveedor = vProveedorServicio.AdicionarModificar(vProveedor);
				vStr.append("Usuario agregado correctamente con el ID: " + vProveedor.getIdProveedor());
			}

			// Eliminar un objeto
			if ("E".equals(vOperacion)) {
				int vIdProveedor = Integer.parseInt(request.getParameter("IdProveedor"));
				vProveedorServicio.Eliminar(vIdProveedor);
				vStr.append("Usuario eliminado correctamente");
			}

			// Obtener por el identificador
			if ("O".equals(vOperacion)) {
				int vIdProveedor = Integer.parseInt(request.getParameter("IdProveedor"));
				Proveedor vProveedor = vProveedorServicio.ObtenerPorId(vIdProveedor);
				vStr.append("El usuario es:").append("<br/>")
						.append("Identificador:" + vProveedor.getIdProveedor() + "<br/>")
						.append("Nombre:" + vProveedor.getNombreProveedor() + "<br/>")
						.append("Matricula:" + vProveedor.getMatriculaProveedor() + "<br/>")
						.append("NIT:" + vProveedor.getNitProveedor() + "<br/>")
						.append("Direccion:" + vProveedor.getDireccionProveedor() + "<br/>")
						.append("Correo:" + vProveedor.getCorreoProveedor() + "<br/>")
						.append("telefono:" + vProveedor.getTelefonoProveedor() + "<br/>")
						.append("Representante:" + vProveedor.getNombreRepresentante() + "<br/>")
						.append("Telefono Representante:" + vProveedor.getTelefonoRepresentante() + "<br/>")
						.append("Fecha Ingreso:" + vProveedor.getFechaIngreso() + "<br/>");
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
