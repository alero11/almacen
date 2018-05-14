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

import axa.egpp.bo.almacen.model.Producto;
import axa.egpp.bo.almacen.servicio.ProductoServicio;

/**
 * Servlet implementation class ProductoServlet
 */
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	ProductoServicio vProductoServicio;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
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
						"Ejemplo de actualización: ?op=M&IdProducto=vIdProducto&NumeroDocumento=vCI&Nombre=vNombre&PrimerApellido=vPrimerApellido&SegundoApellido=vSegundoApellido&Celular=vCelular<br />");
				response.getWriter().append("Ejemplo de borrado: ?op=E&IdProducto=vIdProducto<br />");
				response.getWriter().append("Ejemplo de obtener por Id: ?op=O&IdProducto=vIdProducto<br />");
				return;
			}
			//
			WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext())
					.getAutowireCapableBeanFactory().autowireBean(this);

			// Instanciamos el objeto.
			StringBuilder vStr = new StringBuilder();

			// Listar Productos
			if ("L".equals(vOperacion)) {
				List<Producto> vListaProducto = vProductoServicio.Lista();
				vStr.append("<table border=\"1\"><tr><th>ID</th><th>CI</th><th>Nombres</th></tr>");
				for (Producto vProducto : vListaProducto) {
					vStr.append("<tr><td>")
							.append(vProducto.getIdProducto()).append("</td><td>")
							.append(vProducto.getNombreProducto()).append("</td></tr>");
				}
				vStr.append("</table>");
			}
			// Adicionar o Modificar Productos
			if ("A".equals(vOperacion)) {

				String vNombreProducto = request.getParameter("NombreProducto");
				Producto vProducto = new Producto();
				vProducto.setNombreProducto(vNombreProducto);
				vProducto = vProductoServicio.AdicionarModificar(vProducto);
				vStr.append("Producto agregado correctamente con el ID: " + vProducto.getIdProducto());
			}

			// Actualizar el Producto
			if ("M".equals(vOperacion)) {
				int vIdProducto = Integer.parseInt(request.getParameter("IdProducto"));
				String vNombreProducto = request.getParameter("NombreProducto");				
				Producto vProducto = new Producto();
				vProducto.setIdProducto(vIdProducto);
				vProducto.setNombreProducto(vNombreProducto);
				vProducto = vProductoServicio.AdicionarModificar(vProducto);
				vStr.append("Producto agregado correctamente con el ID: " + vProducto.getIdProducto());
			}

			// Eliminar un objeto
			if ("E".equals(vOperacion)) {
				int vIdProducto = Integer.parseInt(request.getParameter("IdProducto"));
				vProductoServicio.Eliminar(vIdProducto);
				vStr.append("Producto eliminado correctamente");
			}

			// Obtener por el identificador
			if ("O".equals(vOperacion)) {
				int vIdProducto = Integer.parseInt(request.getParameter("IdProducto"));
				Producto vProducto = vProductoServicio.ObtenerPorId(vIdProducto);
				vStr.append("El Producto es:").append("<br/>")
						.append("Identificador:" + vProducto.getIdProducto() + "<br/>")
						.append("Nombre:" + vProducto.getNombreProducto() + "<br/>");
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
