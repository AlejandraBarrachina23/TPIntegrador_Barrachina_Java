package Negocio;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AlumnosDAO;
import DAO.CursoDAO;
import Dominio.Alumno;
import Dominio.Calificaciones;
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

		
		if(request.getParameter("Materia")!=null) {	
			
			Curso unCurso = new Curso();
			Materia unaMateria = new Materia();
			
			unaMateria.setIdMateria(Integer.parseInt(request.getParameter("Materia")));
			unaMateria.setNombre(request.getParameter("NombreMateria"));
			unCurso.setAnio(Integer.parseInt(request.getParameter("anio")));
			unCurso.setSemestre(request.getParameter("Semestre"));
			
			unCurso.setMateria(unaMateria);		
			HttpSession cursoSeleccionado = request.getSession();	
			cursoSeleccionado.setAttribute("cursoSeleccionado", unCurso);
			
		}
		
		RequestDispatcher Request = request.getRequestDispatcher("calificaciones.jsp");
		Request.forward(request, response);

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
		
		if(request.getParameter("btnAgregarCalificacion")!=null) {
			
			Curso cursoSeleccionado = new Curso();
			Materia unaMateria = new Materia();
			Profesor unProfesor = new Profesor();
			
			cursoSeleccionado.setAnio(2019);
			unaMateria.setIdMateria(12);
			unProfesor.setLegajo(5);			
			cursoSeleccionado.setMateria(unaMateria);
			cursoSeleccionado.setProfesorTitular(unProfesor);
			cursoSeleccionado.setSemestre("primero");
			
			String[] ListadoNotasxCurso = request.getParameterValues("notas");
			ArrayList <Calificaciones> ListadoNotasxAlumno = new ArrayList<Calificaciones>();
			Calificaciones unaCalificacion = new Calificaciones();
			
			int intervalo=0;
			for (int i = 0; i < ListadoNotasxCurso.length; i++) {

				intervalo++;
				if(intervalo == 1) unaCalificacion.setParcialUno(Integer.parseInt(ListadoNotasxCurso[i]));
				else if(intervalo == 2) unaCalificacion.setParcialDos(Integer.parseInt(ListadoNotasxCurso[i]));
				else if(intervalo == 3) unaCalificacion.setRecuperatorioUno(Integer.parseInt(ListadoNotasxCurso[i]));
				else if (intervalo == 4) {
					unaCalificacion.setRecuperatorioDos(Integer.parseInt(ListadoNotasxCurso[i]));
					ListadoNotasxAlumno.add(unaCalificacion);
					unaCalificacion=null;
					unaCalificacion = new Calificaciones();
					intervalo=0;
				}
			}
		}

	}

}
