package axa.egpp.bo.almacen.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import axa.egpp.bo.almacen.model.GrupoProducto;
import axa.egpp.bo.almacen.servicio.GrupoProductoServicio;

/**
 * Servlet implementation class GrupoGrupoProductoServlet
 */
public class GrupoProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	GrupoProductoServicio vGrupoProductoServicio;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrupoProductoServlet() {
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
						"Ejemplo de actualización: ?op=M&IdGrupo Producto=vIdGrupo Producto&NumeroDocumento=vCI&Nombre=vNombre&PrimerApellido=vPrimerApellido&SegundoApellido=vSegundoApellido&Celular=vCelular<br />");
				response.getWriter().append("Ejemplo de borrado: ?op=E&IdGrupo Producto=vIdGrupo Producto<br />");
				response.getWriter().append("Ejemplo de obtener por Id: ?op=O&IdGrupo Producto=vIdGrupo Producto<br />");
				return;
			}
			//
			WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext())
					.getAutowireCapableBeanFactory().autowireBean(this);

			// Instanciamos el objeto.
			StringBuilder vStr = new StringBuilder();

			// Listar Grupo Productos
			if ("L".equals(vOperacion)) {
				List<GrupoProducto> vListaGrupoProducto = vGrupoProductoServicio.Lista();
				vStr.append("<table border=\"1\"><tr><th>ID</th><th>CI</th><th>Nombres</th></tr>");
				for (GrupoProducto vGrupoProducto : vListaGrupoProducto) {
					vStr.append("<tr><td>")
							.append(vGrupoProducto.getIdGrupoProducto()).append("</td><td>")
							.append(vGrupoProducto.getNombreGrupoProducto()).append("</td></tr>");
				}
				vStr.append("</table>");
			}
			// Adicionar o Modificar Grupo Productos
			if ("A".equals(vOperacion)) {

				String vNombreGrupoProducto = request.getParameter("NombreGrupoProducto");
				GrupoProducto vGrupoProducto = new GrupoProducto();
				vGrupoProducto.setNombreGrupoProducto(vNombreGrupoProducto);
				vGrupoProducto = vGrupoProductoServicio.AdicionarModificar(vGrupoProducto);
				vStr.append("Grupo Producto agregado correctamente con el ID: " + vGrupoProducto.getIdGrupoProducto());
			}

			// Actualizar el Grupo Producto
			if ("M".equals(vOperacion)) {
				int vIdGrupoProducto = Integer.parseInt(request.getParameter("IdGrupoProducto"));
				String vNombreGrupoProducto = request.getParameter("NombreGrupoProducto");				
				GrupoProducto vGrupoProducto = new GrupoProducto();
				vGrupoProducto.setIdGrupoProducto(vIdGrupoProducto);
				vGrupoProducto.setNombreGrupoProducto(vNombreGrupoProducto);
				vGrupoProducto = vGrupoProductoServicio.AdicionarModificar(vGrupoProducto);
				vStr.append("Grupo Producto agregado correctamente con el ID: " + vGrupoProducto.getIdGrupoProducto());
			}

			// Eliminar un objeto
			if ("E".equals(vOperacion)) {
				int vIdGrupoProducto = Integer.parseInt(request.getParameter("IdGrupoProducto"));
				vGrupoProductoServicio.Eliminar(vIdGrupoProducto);
				vStr.append("Grupo Producto eliminado correctamente");
			}

			// Obtener por el identificador
			if ("O".equals(vOperacion)) {
				int vIdGrupoProducto = Integer.parseInt(request.getParameter("IdGrupoProducto"));
				GrupoProducto vGrupoProducto = vGrupoProductoServicio.ObtenerPorId(vIdGrupoProducto);
				vStr.append("El Grupo Producto es:").append("<br/>")
						.append("Identificador:" + vGrupoProducto.getIdGrupoProducto() + "<br/>")
						.append("Nombre:" + vGrupoProducto.getNombreGrupoProducto() + "<br/>");
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
