package axa.egpp.bo.almacen.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import axa.egpp.bo.almacen.model.Usuario;
import axa.egpp.bo.almacen.servicio.UsuarioServicio;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	UsuarioServicio vUsuarioServicio;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
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
			// asdfasd
			WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()). getAutowireCapableBeanFactory().autowireBean(this);
 			
			// Instanciamos el objeto.
			StringBuilder vStr = new StringBuilder();

			// Listar Usuarios
			if ("L".equals(vOperacion)) {
				List<Usuario> vListaUsuarios = vUsuarioServicio.Lista();
				vStr.append("<table border=\"1\"><tr><th>ID</th><th>CI</th><th>Nombres</th></tr>");
				for (Usuario vUsuario : vListaUsuarios) {
					vStr.append("<tr><td>").append(vUsuario.getIdUsuario()).append("</td><td>")
							.append(vUsuario.getNumeroDocumento()).append("</td><td>").append(vUsuario.getNombre())
							.append("</td><td>").append(vUsuario.getPrimerApellido()).append("</td><td>")
							.append(vUsuario.getSegundoApellido()).append("</td><td>").append(vUsuario.getCelular())
							.append("</td></tr>");
				}
				vStr.append("</table>");
			}
			// Adicionar o Modificar Usuarios
			if ("A".equals(vOperacion)) {

				String vNumeroDocumento = request.getParameter("NumeroDocumento");
				String vNombre = request.getParameter("Nombre");
				String vPrimerApellido = request.getParameter("PrimerApellido");
				String vSegundoApellido = request.getParameter("SegundoApellido");
				String vCelular = request.getParameter("Celular");
				Usuario vUsuario = new Usuario();
				vUsuario.setNumeroDocumento(vNumeroDocumento);
				vUsuario.setNombre(vNombre);
				vUsuario.setPrimerApellido(vPrimerApellido);
				vUsuario.setSegundoApellido(vSegundoApellido);
				vUsuario.setCelular(vCelular);

				vUsuario = vUsuarioServicio.AdicionarModificar(vUsuario);
				vStr.append("Usuario agregado correctamente con el ID: " + vUsuario.getIdUsuario());
			}

			// Actualizar el usuario
			if ("M".equals(vOperacion)) {
				int vIdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
				String vNumeroDocumento = request.getParameter("NumeroDocumento");
				String vNombre = request.getParameter("Nombre");
				String vPrimerApellido = request.getParameter("PrimerApellido");
				String vSegundoApellido = request.getParameter("SegundoApellido");
				String vCelular = request.getParameter("Celular");
				Usuario vUsuario = new Usuario();
				vUsuario.setIdUsuario(vIdUsuario);
				vUsuario.setNumeroDocumento(vNumeroDocumento);
				vUsuario.setNombre(vNombre);
				vUsuario.setPrimerApellido(vPrimerApellido);
				vUsuario.setSegundoApellido(vSegundoApellido);
				vUsuario.setCelular(vCelular);

				vUsuario = vUsuarioServicio.AdicionarModificar(vUsuario);
				vStr.append("Usuario actualizado correctamente con el ID: " + vUsuario.getIdUsuario());
			}

			// Eliminar un objeto
			if ("E".equals(vOperacion)) {
				int vIdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
				vUsuarioServicio.Eliminar(vIdUsuario);
				vStr.append("Usuario eliminado correctamente");
			}

			// Obtener por el identificador
			if ("O".equals(vOperacion)) {
				int vIdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
				Usuario vUsuario = vUsuarioServicio.ObtenerPorId(vIdUsuario);
				vStr.append("El usuario es:").append("<br/>")
						.append("Identificador:" + vUsuario.getIdUsuario() + "<br/>")
						.append("Numero de Documento:" + vUsuario.getNumeroDocumento() + "<br/>")
						.append("Nombres:" + vUsuario.getNombre() + "<br/>")
						.append("Primer Apellido:" + vUsuario.getPrimerApellido() + "<br/>")
						.append("Segundo Apellido:" + vUsuario.getSegundoApellido() + "<br/>")
						.append("Celular:" + vUsuario.getCelular());
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
