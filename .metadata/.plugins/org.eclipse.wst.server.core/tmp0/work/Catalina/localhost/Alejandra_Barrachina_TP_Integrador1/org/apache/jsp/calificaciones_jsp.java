/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2019-12-14 00:17:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Materia;
import Dominio.Calificaciones;
import Dominio.Profesor;
import Dominio.Usuario;
import Negocio.CursoNegocio;
import java.util.ArrayList;

public final class calificaciones_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("Dominio.Usuario");
    _jspx_imports_classes.add("Dominio.Materia");
    _jspx_imports_classes.add("Negocio.CursoNegocio");
    _jspx_imports_classes.add("Dominio.Alumno");
    _jspx_imports_classes.add("Dominio.Curso");
    _jspx_imports_classes.add("Dominio.Calificaciones");
    _jspx_imports_classes.add("Dominio.Profesor");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("    \r\n");
      out.write("        \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Sistema Universitarios</title>\r\n");
      out.write("<link href=\"estilos.css\" type=\"text/css\" rel=stylesheet>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Oswald&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,600&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Roboto&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Francois+One&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"jquery.dataTables.min.css\" type=\"text/css\" rel=sytlesheet>\r\n");
      out.write("<script src=\"jquery-3.4.1.min.js\"></script>\r\n");
      out.write("<script src=\"jquery.dataTables.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav>\r\n");
      out.write("<div id=\"user\">\r\n");
      out.write("\t\t<a href=\"index.jsp\"><img id=\"icon-usuario\" src=\"iconos/usuario-admin.svg\" alt=\"imagen-usuario\"></a>\r\n");
      out.write("\t\t<h2>¡Bienvenido!</h2>\r\n");
      out.write("\t\t<p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${usuario.usuario}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t<a href=\"serveletUsuario\">LogOut</a>\r\n");
      out.write("\t</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu-profesores.html", out, false);
      out.write("\r\n");
      out.write("</nav>\r\n");
      out.write("<section class=\"section-principal\">\r\n");
      out.write("\t<div class=\"encabezados\"><h3>CALIFICACIONES</h3></div>\r\n");
      out.write("\t");
 
		HttpSession sesionActiva = request.getSession();
		Curso cursoActivo = (Curso)sesionActiva.getAttribute("cursoSeleccionado");
	 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t<div class=\"busqueda-califaciones\">\r\n");
      out.write("\t\t<h2>1. CURSO SELECCIONADO</h2>\r\n");
      out.write("\t\t\t<input type=\"text\" value=\"");
      out.print(cursoActivo.getMateria().getNombre() );
      out.write("\" disabled>\r\n");
      out.write("\t\t\t<input type=\"text\" value=\"");
      out.print(cursoActivo.getSemestre() );
      out.write("\" disabled>\r\n");
      out.write("\t\t\t<input type=\"number\" value=\"");
      out.print(cursoActivo.getAnio() );
      out.write("\" disabled>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"form-listado-calificaciones\">\r\n");
      out.write("\t\t\t<h2>2. CARGUE LAS CALIFICACIONES</h2>\r\n");
      out.write("\t\t\t<form action=\"ServeletCurso\" method=\"post\" >\r\n");
      out.write("\t\t\t<table id=\"table_id\" class=\"content-table\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>Legajo</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Nombre</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Apellido</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Parcial Uno</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Parcial Dos</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Recuperatorio Uno</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Recuperatorio Dos</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Estado</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t");
 
						
			CursoNegocio unCursoNegocio = new CursoNegocio();
			Curso cursoSeleccionado = new Curso();
			Profesor unProfesor = new Profesor();
			
			HttpSession cursoxprofesor = request.getSession();
			Usuario usuarioLogeado = (Usuario)cursoxprofesor.getAttribute("usuario");
			unProfesor.setLegajo(usuarioLogeado.getUnProfesor().getLegajo());
			cursoSeleccionado = (Curso)cursoxprofesor.getAttribute("cursoSeleccionado");
			cursoSeleccionado.setProfesorTitular(unProfesor);
			
			for(Curso unCurso : unCursoNegocio.AlumnosxCurso(cursoSeleccionado)){
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
 for(Alumno alumnosxcurso : unCurso.getListadoAlumnos()){
      out.write("<tr>\r\n");
      out.write("\t\t\t\t\t\t  <td>");
      out.print( alumnosxcurso.getLegajo());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  <td>");
      out.print( alumnosxcurso.getNombre());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  <td>");
      out.print( alumnosxcurso.getApellido() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
for(Calificaciones calificacionxalumno : unCurso.getListadoNotas()){
							
							if(alumnosxcurso.getLegajo()==calificacionxalumno.getLegajoAlumno()){
      out.write("\r\n");
      out.write("        \t\t\t\t\t\t  <td><input type=\"number\" name=\"notas\" value=\"");
      out.print(calificacionxalumno.getParcialUno() );
      out.write("\" max=\"10\" min=\"0\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <td><input type=\"number\" name=\"notas\" value=\"");
      out.print(calificacionxalumno.getParcialDos() );
      out.write("\" max=\"10\" min=\"0\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <td><input type=\"number\" name=\"notas\" value=\"");
      out.print(calificacionxalumno.getRecuperatorioUno() );
      out.write("\" max=\"10\" min=\"0\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <td><input type=\"number\" name=\"notas\" value=\"");
      out.print(calificacionxalumno.getRecuperatorioDos() );
      out.write("\" max=\"10\" min=\"0\"><input type=\"hidden\" class=\"Estado-oculto\" value=\"");
      out.print( calificacionxalumno.getEstado() );
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <select class=\"cboxEstado\" name=\"cboxEstado\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <option value=\"Libre\">Libre</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <option value=\"Regular\">Regular</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t  </select>\r\n");
      out.write("\t\t\t\t\t\t\t\t  </td>\r\n");
      out.write("\t\t\t\t\t\t\t");
}
						}
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t");
	}
				}
      out.write("\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"listado-legajos\" value=\"\" name=\"listado-legajos\">\r\n");
      out.write("\t\t\t\t<input type=\"submit\" id=\"btnAgregarCalificacion\" name=\"btnAgregarCalificacion\" class=\"btnFormulario\" value=\"CARGAR CALIFICACIONES\">\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\t\t\r\n");
      out.write("</section>\r\n");
      out.write("<script>\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready( function () {\r\n");
      out.write("\t    $('#table_id').DataTable();\r\n");
      out.write("\t    \r\n");
      out.write("\t\tlet estadosAlumnos = document.getElementsByClassName('Estado-oculto');\r\n");
      out.write("\t\tlet selectEstado = document.getElementsByClassName('cboxEstado');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfor(let i=0; i<estadosAlumnos.length;i++){\r\n");
      out.write("\r\n");
      out.write("\t\t\tfor(let j=0; j<selectEstado.length;j++){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(i===j){\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tselectEstado[i].value = estadosAlumnos[j].value;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t   \r\n");
      out.write("\t} );\r\n");
      out.write("\t\r\n");
      out.write("\tconst AgregarCalificacion = document.getElementById('btnAgregarCalificacion');\r\n");
      out.write("\t\r\n");
      out.write("\tAgregarCalificacion.addEventListener('click', function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tListadoLegajos();\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\tfunction ListadoLegajos(){\r\n");
      out.write("\t\t$('#table_id tr').each(function () {\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tvar legajo = $(this).find(\"td\").eq(0).html();\r\n");
      out.write("\t\t\tif(typeof(legajo)!=='undefined') {\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"listado-legajos\").value += legajo+\"-\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
