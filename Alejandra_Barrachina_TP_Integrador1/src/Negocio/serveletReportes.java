package Negocio;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Materia;
import Dominio.Profesor;


@WebServlet("/serveletReportes")
public class serveletReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public serveletReportes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnBuscar")!=null) {
			
			CursoNegocio unCursoNegocio = new CursoNegocio();
			ReportesNegocio reporte = new ReportesNegocio();
			Curso CursoSeleccionado = new Curso();
			Materia unaMateria = new Materia();
			Profesor unProfesor = new Profesor();
			
			//GUARDO LOS VALORES DEL CURSO PARA LA BUSQUEDA
			unaMateria.setIdMateria(Integer.parseInt(request.getParameter("cboxMaterias")));
			unProfesor.setLegajo(Integer.parseInt(request.getParameter("cboxProfesores")));
			CursoSeleccionado.setProfesorTitular(unProfesor);
			CursoSeleccionado.setMateria(unaMateria);
			CursoSeleccionado.setAnio(Integer.parseInt(request.getParameter("anio")));
			CursoSeleccionado.setSemestre(request.getParameter("cboxSemestre"));
			
			//LLENO TABLAS
			//LISTADO DE ALUMNOS DEL CURSO SELECCIONADO CALIFICACIONES
			ArrayList<Curso>ListadoAlumnosxCurso = unCursoNegocio.AlumnosxCurso(CursoSeleccionado);
			//LISTADO DE ALUMNOS DEL CURSO SELECCIONADO ESTADO
			ArrayList<Alumno>ListadoAsistenciaAlumnosxCurso = reporte.EstadoAsistenciasxCurso(CursoSeleccionado);
			
			//LLENO GRÁFICOS
			
			//LLEVO AL HTML
			request.setAttribute("ListadoAlumnoxCursoSeleccionado", ListadoAlumnosxCurso);
			request.setAttribute("ParcialUnoAprobados", reporte.NotasPrimerParcial(CursoSeleccionado));
			request.setAttribute("ListadoAsistencia", ListadoAsistenciaAlumnosxCurso);
			
			//REDIRECCION
			RequestDispatcher Request = request.getRequestDispatcher("reportes-avanzados.jsp");
			Request.forward(request, response);
			
		}
	}

}
