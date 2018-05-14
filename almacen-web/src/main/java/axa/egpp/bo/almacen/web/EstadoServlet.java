package axa.egpp.bo.almacen.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import axa.egpp.bo.almacen.model.Estado;
import axa.egpp.bo.almacen.servicio.EstadoServicio;

/**
 * Servlet implementation class EstadoServlet
 */
public class EstadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	EstadoServicio vEstadoServicio;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String vOperacion = request.getParameter("op");
			if (vOperacion == null) {
				response.getWriter().append("De indicar en el QUERY que tipo de operacion (CRUD) desea realizar");
				response.getWriter().append("Ejemplo de listado: ?op=L<br />");
				response.getWriter().append(
						"Ejemplo de creacion: ?op=A&NumeroDocumento=vCI&Nombre=vNombre&PrimerApellido=vPrimerApellido&SegundoApellido=vSegundoApellido&Celular=vCelular<br />");
				response.getWriter().append(
						"Ejemplo de actualización: ?op=M&IdEstado=vIdEstado&NumeroDocumento=vCI&Nombre=vNombre&PrimerApellido=vPrimerApellido&SegundoApellido=vSegundoApellido&Celular=vCelular<br />");
				response.getWriter().append("Ejemplo de borrado: ?op=E&IdEstado=vIdEstado<br />");
				response.getWriter().append("Ejemplo de obtener por Id: ?op=O&IdEstado=vIdEstado<br />");
				return;
			}
			//
			WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext())
					.getAutowireCapableBeanFactory().autowireBean(this);

			// Instanciamos el objeto.
			StringBuilder vStr = new StringBuilder();

			// Listar Estados
			if ("L".equals(vOperacion)) {
				List<Estado> vListaEstado = vEstadoServicio.Lista();
				vStr.append("<table border=\"1\"><tr><th>ID</th><th>CI</th><th>Nombres</th></tr>");
				for (Estado vEstado : vListaEstado) {
					vStr.append("<tr><td>")
							.append(vEstado.getIdEstado()).append("</td><td>")
							.append(vEstado.getNombreEstado()).append("</td></tr>");
				}
				vStr.append("</table>");
			}
			// Adicionar o Modificar Estados
			if ("A".equals(vOperacion)) {

				String vNombreEstado = request.getParameter("NombreEstado");
				Estado vEstado = new Estado();
				vEstado.setNombreEstado(vNombreEstado);
				vEstado = vEstadoServicio.AdicionarModificar(vEstado);
				vStr.append("Estado agregado correctamente con el ID: " + vEstado.getIdEstado());
			}

			// Actualizar el Estado
			if ("M".equals(vOperacion)) {
				int vIdEstado = Integer.parseInt(request.getParameter("IdEstado"));
				String vNombreEstado = request.getParameter("NombreEstado");				
				Estado vEstado = new Estado();
				vEstado.setIdEstado(vIdEstado);
				vEstado.setNombreEstado(vNombreEstado);
				vEstado = vEstadoServicio.AdicionarModificar(vEstado);
				vStr.append("Estado agregado correctamente con el ID: " + vEstado.getIdEstado());
			}

			// Eliminar un objeto
			if ("E".equals(vOperacion)) {
				int vIdEstado = Integer.parseInt(request.getParameter("IdEstado"));
				vEstadoServicio.Eliminar(vIdEstado);
				vStr.append("Estado eliminado correctamente");
			}

			// Obtener por el identificador
			if ("O".equals(vOperacion)) {
				int vIdEstado = Integer.parseInt(request.getParameter("IdEstado"));
				Estado vEstado = vEstadoServicio.ObtenerPorId(vIdEstado);
				vStr.append("El Estado es:").append("<br/>")
						.append("Identificador:" + vEstado.getIdEstado() + "<br/>")
						.append("Nombre:" + vEstado.getNombreEstado() + "<br/>");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
