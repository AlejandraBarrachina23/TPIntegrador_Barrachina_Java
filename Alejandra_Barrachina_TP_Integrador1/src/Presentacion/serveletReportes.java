package Presentacion;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Materia;
import Dominio.Profesor;
import Negocio.CursoNegocio;
import Negocio.ReportesNegocio;


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
			String Estado = "";
			
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
			int Contador=0;
			
			for (Alumno alumno : ListadoAsistenciaAlumnosxCurso) {
				
				Contador++;
			}
			
			if(Contador>0) Estado="lleno";
			else Estado="vacio";
			
			System.out.println(Contador);
			
			//LLENO GR�FICOS
			
			//LLEVO AL HTML
			request.setAttribute("ListadoAlumnoxCursoSeleccionado", ListadoAlumnosxCurso);
			request.setAttribute("ParcialUnoAprobados", reporte.NotasPrimerParcial(CursoSeleccionado));
			request.setAttribute("ListadoAsistencia", ListadoAsistenciaAlumnosxCurso);
			HttpSession estadoBusquedaAvanzada = request.getSession();	
			estadoBusquedaAvanzada.setAttribute("ResultadoBusquedaAvanzada", Estado );
			
			//REDIRECCION
			RequestDispatcher Request = request.getRequestDispatcher("reportes-avanzados.jsp");
			Request.forward(request, response);
			
		}
	}

}
