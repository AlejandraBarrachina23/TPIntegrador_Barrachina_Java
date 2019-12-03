package Negocio;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CursoDAO;
import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Materia;
import Dominio.Profesor;


@WebServlet("/ServeletCurso")
public class ServeletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServeletCurso() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAgregarCurso")!=null) {
			
			ArrayList <Alumno> ListadoAlumnos = new ArrayList<Alumno>();
			CursoDAO unCursoDAO = new CursoDAO();
			Curso unNuevoCurso = new Curso();
			Materia materiaDictada = new Materia();
			Profesor profesorTitular = new Profesor();
			String [] listadoLegajos = request.getParameter("listado-alumnos-oculto").split("-");
			String[] idMateria = request.getParameter("tboxMateria-previsualizacion").split("-");
			String[] idProfesor = request.getParameter("tboxProfesor-previsualizacion").split("-");
			
			materiaDictada.setIdMateria(Integer.parseInt(idMateria[0]));
			profesorTitular.setLegajo(Integer.parseInt(idProfesor[0]));
			unNuevoCurso.setSemestre(request.getParameter("tboxSemestre-previsualizacion"));
			unNuevoCurso.setAnio(Integer.parseInt(request.getParameter("tboxAnio-previsualizacion")));
			unNuevoCurso.setMateria(materiaDictada);
			unNuevoCurso.setProfesorTitular(profesorTitular);
						
			for (String legajo : listadoLegajos) {

				unCursoDAO.AgregarCuros(unNuevoCurso, Integer.parseInt(legajo));			
			
			}

		}
	}

}