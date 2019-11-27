package Negocio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AlumnosDAO;
import Dominio.Alumno;
import Dominio.Localidad;
import Dominio.Provincia;

/**
 * Servlet implementation class ServeletAlumno
 */
@WebServlet("/ServeletAlumno")
public class ServeletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServeletAlumno() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			if(request.getParameter("btnAceptar")!=null) {
				
				Alumno unNuevoAlumno = new Alumno();
				Localidad LocalidadSeleccionada = new Localidad();
				Provincia ProvinciaSeleccionada = new Provincia();
				unNuevoAlumno.setNombre(request.getParameter("tboxNombre"));
				unNuevoAlumno.setApellido(request.getParameter("tboxApellido"));
				unNuevoAlumno.setFechaNacimiento(request.getParameter("tboxFechaNacimiento"));
				unNuevoAlumno.setDireccion(request.getParameter("tboxDireccion"));
				LocalidadSeleccionada.setIdLocalidad(Integer.parseInt(request.getParameter("cboxLocalidades")));
				ProvinciaSeleccionada.setIdProvincia(Integer.parseInt(request.getParameter("cboxProvincias")));
				unNuevoAlumno.setEmail(request.getParameter("tboxEmail"));
				unNuevoAlumno.setTelefono(request.getParameter("tboxTelefono"));
				unNuevoAlumno.setProvincia(ProvinciaSeleccionada);
				unNuevoAlumno.setLocalidad(LocalidadSeleccionada);
				
				AlumnosDAO Alumno = new AlumnosDAO();
				Alumno.AgregarAlumno(unNuevoAlumno);
				
			}
			
			RequestDispatcher Request = request.getRequestDispatcher("alumnos.jsp");
			Request.forward(request, response);
		} 
		
		catch (Exception e) {
			
			System.out.print("Error al cargar "+ e);
		}
	}

}
