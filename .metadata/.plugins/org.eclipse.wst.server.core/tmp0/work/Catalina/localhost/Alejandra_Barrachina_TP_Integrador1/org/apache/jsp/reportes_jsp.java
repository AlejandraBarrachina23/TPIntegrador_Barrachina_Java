/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2019-12-19 12:59:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import Dominio.Alumno;
import Dominio.Usuario;
import Negocio.ReportesNegocio;
import Dominio.Curso;
import Dominio.Reporte;
import java.util.ArrayList;

public final class reportes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("org.apache.jasper.tagplugins.jstl.core.ForEach");
    _jspx_imports_classes.add("Dominio.Reporte");
    _jspx_imports_classes.add("Negocio.ReportesNegocio");
    _jspx_imports_classes.add("Dominio.Alumno");
    _jspx_imports_classes.add("Dominio.Curso");
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
      out.write("\r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
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
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.js\"></script>\r\n");
      out.write("<script src=\"jquery-3.4.1.min.js\"></script>\r\n");
      out.write("<script src=\"jquery.dataTables.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
 
	if((Usuario) request.getSession(true).getAttribute("usuario")!=null){
		
		Usuario unUsuario = new Usuario();
		unUsuario = (Usuario) request.getSession(true).getAttribute("usuario");
		if(!unUsuario.getTipoUsuario().equals("administrador")){response.sendRedirect("error404.jsp");}
	
	}

	else {
		response.sendRedirect("error404.jsp");
	}
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<nav>\r\n");
      out.write("<div id=\"user\">\r\n");
      out.write("\t\t<a href=\"index.jsp\"><img id=\"icon-usuario\" src=\"iconos/usuario-admin.svg\" alt=\"imagen-usuario\"></a>\r\n");
      out.write("\t\t<h2>¡Bienvenido!</h2>\r\n");
      out.write("\t\t<p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${usuario.usuario}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t<a href=\"serveletUsuario\">LogOut</a>\r\n");
      out.write("\t</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu-administrador.html", out, false);
      out.write("\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<section class=\"section-principal\">\r\n");
      out.write("\t<div class=\"encabezados\"><h3>REPORTES GENERALES</h3></div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"form-reportes\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<div class=\"form-reportes-estadisticas-alumnos\">\r\n");
      out.write("\t\t\t<div id=\"form-reportes-fila-uno\">\r\n");
      out.write("\t\t\t\t<div class=\"fila-uno-items\">\r\n");
      out.write("\t\t\t\t\t<h2>TOTAL ALUMNOS</h2>\r\n");
      out.write("\t\t\t\t\t<p>");
 ReportesNegocio reporte = new ReportesNegocio();
      out.write("\r\n");
      out.write("\t\t\t\t\t");
      out.print(reporte.CantidadAlumnosAnio(2019));
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t<img alt=\"total-alumnos\" src=\"img/total.svg\">\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"fila-uno-items-pie\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"img-total-alumnos\" src=\"iconos/baja.svg\" alt=\"subida\">\r\n");
      out.write("\t\t\t\t\t\t<p id=\"total-alumnos\"></p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"fila-uno-items\">\r\n");
      out.write("\t\t\t\t\t<h2>ALUMNOS REGULARES</h2>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<p>");
      out.print(reporte.CantidadAlumnosRegulares() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t<img alt=\"alumno-regular\" src=\"img/regular.svg\">\r\n");
      out.write("\t\t\t\t\t<div class=\"fila-uno-items-pie\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"img-alumno-regular\" src=\"iconos/alta.svg\" alt=\"subida\">\r\n");
      out.write("\t\t\t\t\t\t<p id=\"alumno-regular\"></p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"fila-uno-items\">\r\n");
      out.write("\t\t\t\t\t<h2>ALUMNOS LIBRES</h2>\r\n");
      out.write("\t\t\t\t\t<p>");
      out.print( reporte.CantidadAlumnosLibres() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t<img alt=\"alumno-libre\" src=\"img/libre.svg\">\r\n");
      out.write("\t\t\t\t\t<div class=\"fila-uno-items-pie\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"img-alumno-libre\" src=\"iconos/baja.svg\" alt=\"subida\">\r\n");
      out.write("\t\t\t\t\t\t<p id=\"alumno-libre\"></p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"fila-uno-items\">\r\n");
      out.write("\t\t\t\t\t<h2>TOTAL PROFESORES</h2>\r\n");
      out.write("\t\t\t\t\t<p>");
      out.print( reporte.CantidadProfesoresActivos() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t<img alt=\"profesores\" src=\"img/maestros.svg\">\r\n");
      out.write("\t\t\t\t\t<div class=\"fila-uno-items-pie\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"iconos/alta.svg\" alt=\"subida\">\r\n");
      out.write("\t\t\t\t\t\t<p id=\"profesores\">0.00</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\t\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t\t<div id=\"form-reportes-fila-dos\">\r\n");
      out.write("\t\t\t<h2>INSCRIPCIONES 2019</h2>\r\n");
      out.write("\t\t\t\t<div class=\"form-reportes-graficos\">\r\n");
      out.write("\t\t\t\t\t<h3>COMPARATIVA ALUMNOS INSCRIPTOS</h3>\r\n");
      out.write("\t\t\t\t\t<canvas id=\"cantidad-inscriptos\"></canvas>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-reportes-graficos\">\r\n");
      out.write("\t\t\t\t\t<h3>MATERIAS CON MÁS INSCRIPTOS 2019</h3>\r\n");
      out.write("\t\t\t\t\t<canvas id=\"materias-mas-inscriptos\"></canvas>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-reportes-graficos\">\r\n");
      out.write("\t\t\t\t\t<h3>COMPARATIVA ALUMNOS REGULARES LIBRES</h3>\r\n");
      out.write("\t\t\t\t\t<canvas id=\"comparativa-alumnos\"></canvas>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"form-reportes-fila-tres\">\r\n");
      out.write("\t\t\t\t<h2>CARRERAS-MATERIAS</h2>\r\n");
      out.write("\t\t\t\t<div class=\"reporte-fila-tres-promedio\">\r\n");
      out.write("\t\t\t\t\t<h3>MEJORES PROMEDIOS DE LA CARRERA</h3>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<table class=\"content-table\">\r\n");
      out.write("\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Legajo</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Nombre</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Apellido</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Promedio</th>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t");
for(Reporte unReporte : reporte.MejoresPromedios(2019)){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr> \r\n");
      out.write("\t\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t\t\t  <td>");
      out.print( unReporte.getUnAlumno().getLegajo() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <td>");
      out.print( unReporte.getUnAlumno().getNombre() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <td>");
      out.print( unReporte.getUnAlumno().getApellido() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <td>");
      out.print( unReporte.getPromedio() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"reporte-fila-tres-promedio\">\r\n");
      out.write("\t\t\t\t<h3>PEORES PROMEDIOS DE LA CARRERA</h3>\r\n");
      out.write("\t\t\t\t<table class=\"content-table\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Legajo</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Nombre</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Apellido</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Promedio</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t");
for(Reporte unReporte : reporte.PeoresPromedios(2019)){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr> \r\n");
      out.write("\t\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t\t\t  <td>");
      out.print( unReporte.getUnAlumno().getLegajo() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <td>");
      out.print( unReporte.getUnAlumno().getNombre() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <td>");
      out.print( unReporte.getUnAlumno().getApellido() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <td>");
      out.print( unReporte.getPromedio() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t<div class=\"reporte-fila-tres-promedio\">\r\n");
      out.write("\t\t\t\t<h3>MATERIAS CON MÁS EGRESO</h3>\r\n");
      out.write("\t\t\t\t<table class=\"content-table\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>ID Curso</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Materia</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Semestre</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Profesor</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Egresos</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>  \r\n");
      out.write("\t\t\t\t\t\t");
 for(Curso unCurso : reporte.MateriasConMasEgresos()){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t <td>");
      out.print( unCurso.getMateria().getIdMateria() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t <td>");
      out.print( unCurso.getMateria().getNombre() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t <td>");
      out.print( unCurso.getSemestre() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t <td>");
      out.print( unCurso.getProfesorTitular().getNombre() + " " + unCurso.getProfesorTitular().getApellido() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t <td>");
      out.print( unCurso.getAnio() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"reporte-fila-tres-promedio\">\r\n");
      out.write("\t\t\t\t<h3>MATERIAS CON MÁS ABANDONOS</h3>\r\n");
      out.write("\t\t\t\t<table class=\"content-table\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>ID Curso</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Materia</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Semestre</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Profesor</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Abandonos</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t<tr>  \r\n");
      out.write("\t\t\t\t\t\t\t");
 for(Curso unCurso : reporte.MateriasConMasAbandono()){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print( unCurso.getMateria().getIdMateria() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print( unCurso.getMateria().getNombre() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print( unCurso.getSemestre() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print( unCurso.getProfesorTitular().getNombre() + " " + unCurso.getProfesorTitular().getApellido() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print( unCurso.getAnio() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t<a href=\"reportes-avanzados.jsp\"><input type=\"button\" id=\"btnAgregarAlumno\" class=\"btnFormulario\" value=\"REPORTES AVANZADOS\"></a>\t\t\r\n");
      out.write("</section>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("CalcularDiferencia();\r\n");
      out.write("ComparativaAlumnosInscriptos();\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready( function () {\r\n");
      out.write("\t    $('#table_id').DataTable();\r\n");
      out.write("\t} );\r\n");
      out.write("\t\r\n");
      out.write("\tfunction CalcularDiferencia(cantidadAlumnosActual,cantidadAlumnosAnterior){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tlet totalAlumnos = ");
      out.print(reporte.DiferenciaAlumnosxAnio(2019, 2018) );
      out.write(" ;\r\n");
      out.write("\t\tlet totalAlumnosRegulares = ");
      out.print(reporte.DiferenciaAlumnosRegularesxAnio(2019, 2018) );
      out.write(";\r\n");
      out.write("\t\tlet totalAlumnosLibres = ");
      out.print(reporte.DiferenciaAlumnosRegularesxAnio(2018, 2019) );
      out.write(";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"total-alumnos\").innerText= totalAlumnos+ \"%\";\r\n");
      out.write("\t\tdocument.getElementById(\"alumno-regular\").innerText= totalAlumnosRegulares+ \"%\";\r\n");
      out.write("\t\tdocument.getElementById(\"alumno-libre\").innerText= totalAlumnosLibres+ \"%\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(totalAlumnos>0) document.getElementById(\"img-total-alumnos\").src= \"iconos/alta.svg\";\r\n");
      out.write("\t\telse document.getElementById(\"img-total-alumnos\").src= \"iconos/baja.svg\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(totalAlumnosRegulares>0) document.getElementById(\"img-alumno-regular\").src= \"iconos/alta.svg\";\r\n");
      out.write("\t\telse document.getElementById(\"img-alumno-regular\").src= \"iconos/baja.svg\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(totalAlumnosLibres>0) document.getElementById(\"img-alumno-libre\").src= \"iconos/alta.svg\";\r\n");
      out.write("\t\telse document.getElementById(\"img-alumno-libre\").src= \"iconos/baja.svg\";\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction ComparativaAlumnosInscriptos(){\r\n");
      out.write("\t\r\n");
      out.write("\t\tListado = [];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
ArrayList<Reporte>ListadoComparativaInscriptos = reporte.ComparativaAlumnosInscriptos(2019);
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
for(Reporte unReporte : ListadoComparativaInscriptos){ 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tListado.push(");
      out.print(unReporte.getCantidad());
      out.write(");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t ");
}
      out.write("\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\treturn Listado; \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction MateriaConMasInscriptosMateriasCantidad(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tListado = [];\r\n");
      out.write("\t\t");
 ArrayList<Reporte>ListadoMateriaMasInscriptos = reporte.MateriasMasInscripciones(2019);
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
for(Reporte unReporte : ListadoMateriaMasInscriptos){ 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tListado.push(");
      out.print(unReporte.getCantidad());
      out.write(");\r\n");
      out.write("\t\r\n");
      out.write("\t\t ");
}
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t return Listado;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction MateriaConMasInscriptosMateriasNombre(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tListado = [];\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t");
for(Reporte unReporte : ListadoMateriaMasInscriptos){ 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tListado.push('");
      out.print(unReporte.getMateria());
      out.write("');\r\n");
      out.write("\t\r\n");
      out.write("\t\t ");
}
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t return Listado;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction EstadosAlumnosxAnioRegulares(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tListado = [];\r\n");
      out.write("\t\t");
 ArrayList<Reporte>EstadosAlumnosxAnioRegulares = reporte.EstadosAlumnosxAnio(2019);
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
for(Reporte unReporte : EstadosAlumnosxAnioRegulares){ 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tListado.push(");
      out.print(unReporte.getCantidad());
      out.write(");\r\n");
      out.write("\t\r\n");
      out.write("\t\t ");
}
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t return Listado;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction EstadosAlumnosxAnioLibres(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tListado = [];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
 ArrayList<Reporte>ListadoLibres = reporte.EstadosAlumnosxAnioLibres(2019);
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
for(Reporte unReporte : ListadoLibres){ 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tListado.push(");
      out.print(unReporte.getCantidad());
      out.write(");\r\n");
      out.write("\t\r\n");
      out.write("\t\t ");
}
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t return Listado;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\tvar ctx = document.getElementById('comparativa-alumnos').getContext('2d');\r\n");
      out.write("\tvar myChart = new Chart(ctx, {\r\n");
      out.write("\t    type: 'line',\r\n");
      out.write("\t    data: {\r\n");
      out.write("\t        labels: ['2015', '2016', '2017', '2018', '2019'],\r\n");
      out.write("\t        datasets: [\r\n");
      out.write("\t        \t\r\n");
      out.write("\t        \t{\r\n");
      out.write("\t\t        \tlabel:\"Libres\",\r\n");
      out.write("\t\t            data: EstadosAlumnosxAnioLibres(),\r\n");
      out.write("\t\t            fill: false,\r\n");
      out.write("\t\t            backgroundColor:\"rgba(54, 162, 235, 0.2)\",\r\n");
      out.write("\t\t            lineTension: 0.1,\r\n");
      out.write("\t\t            borderColor: \"rgba(44,80,96,0.5)\",\t            \r\n");
      out.write("\t\t            borderWidth: 2\r\n");
      out.write("\t        \t},\r\n");
      out.write("\t        \t{\r\n");
      out.write("\t\t        \tlabel: \"Regular\",\r\n");
      out.write("\t\t            data: EstadosAlumnosxAnioRegulares(),\r\n");
      out.write("\t\t            fill: false,\r\n");
      out.write("\t\t            lineTension: 0.1,\r\n");
      out.write("\t\t            borderColor: \"rgba(225,108,96,0.5)\",\r\n");
      out.write("\t\t            borderWidth: 2\r\n");
      out.write("\t        \r\n");
      out.write("\t        \t}\r\n");
      out.write("\r\n");
      out.write("\t        ]\r\n");
      out.write("\t    },\r\n");
      out.write("\t    options: {\r\n");
      out.write("\t        scales: {\r\n");
      out.write("\t            yAxes: [{\r\n");
      out.write("\t                ticks: {\r\n");
      out.write("\t                    beginAtZero: true\r\n");
      out.write("\t                }\r\n");
      out.write("\t            }]\r\n");
      out.write("\t        }\r\n");
      out.write("\t    }\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready( function () {\r\n");
      out.write("\t    $('#table_id').DataTable();\r\n");
      out.write("\t} );\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tvar ctx = document.getElementById('cantidad-inscriptos').getContext('2d');\r\n");
      out.write("\tvar myChart = new Chart(ctx, {\r\n");
      out.write("\t    type: 'line',\r\n");
      out.write("\t    data: {\r\n");
      out.write("\t        labels: ['2015', '2016', '2017', '2018', '2019'],\r\n");
      out.write("\t        datasets: [{\r\n");
      out.write("\t            label: 'Cantidad Alumnos',\r\n");
      out.write("\t            data: ComparativaAlumnosInscriptos(),\r\n");
      out.write("\t            borderWidth: 1,\r\n");
      out.write("\t            backgroundColor: [\r\n");
      out.write("\t                'rgba(255, 99, 132, 0.2)',\r\n");
      out.write("\t                'rgba(54, 162, 235, 0.2)',\r\n");
      out.write("\t                'rgba(255, 206, 86, 0.2)',\r\n");
      out.write("\t                'rgba(75, 192, 192, 0.2)',\r\n");
      out.write("\t                'rgba(153, 102, 255, 0.2)',\r\n");
      out.write("\t                'rgba(255, 255, 255, 0.2)'\r\n");
      out.write("\t            ],\r\n");
      out.write("\t            borderColor: [\r\n");
      out.write("\t                'rgba(255, 99, 132, 1)',\r\n");
      out.write("\t                'rgba(54, 162, 235, 1)',\r\n");
      out.write("\t                'rgba(255, 206, 86, 1)',\r\n");
      out.write("\t                'rgba(75, 192, 192, 1)',\r\n");
      out.write("\t                'rgba(153, 102, 255, 1)',\r\n");
      out.write("\t                'rgba(255, 255, 255, 1)'\r\n");
      out.write("\t            ]\r\n");
      out.write("\t        }]\r\n");
      out.write("\t    },\r\n");
      out.write("\t    options: {\r\n");
      out.write("\t        scales: {\r\n");
      out.write("\t            yAxes: [{\r\n");
      out.write("\t                ticks: {\r\n");
      out.write("\t                    beginAtZero: true\r\n");
      out.write("\t                }\r\n");
      out.write("\t            }]\r\n");
      out.write("\t        }\r\n");
      out.write("\t    }\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tvar ctx = document.getElementById('materias-mas-inscriptos').getContext('2d');\r\n");
      out.write("\tvar myChart = new Chart(ctx, {\r\n");
      out.write("\t    type: 'bar',\r\n");
      out.write("\t    data: {\r\n");
      out.write("\t        labels: MateriaConMasInscriptosMateriasNombre(),\r\n");
      out.write("\t        datasets: [{\r\n");
      out.write("\t            label: 'Cantidad Inscriptos',\r\n");
      out.write("\t            data: MateriaConMasInscriptosMateriasCantidad(),\r\n");
      out.write("\t            borderWidth: 1,\r\n");
      out.write("\t            backgroundColor: [\r\n");
      out.write("\t                'rgba(255, 99, 132, 0.2)',\r\n");
      out.write("\t                'rgba(54, 162, 235, 0.2)',\r\n");
      out.write("\t                'rgba(255, 206, 86, 0.2)',\r\n");
      out.write("\t                'rgba(75, 192, 192, 0.2)',\r\n");
      out.write("\t                'rgba(153, 102, 255, 0.2)',\r\n");
      out.write("\t                'rgba(255, 159, 64, 0.2)'\r\n");
      out.write("\t            ],\r\n");
      out.write("\t            borderColor: [\r\n");
      out.write("\t                'rgba(255, 99, 132, 1)',\r\n");
      out.write("\t                'rgba(54, 162, 235, 1)',\r\n");
      out.write("\t                'rgba(255, 206, 86, 1)',\r\n");
      out.write("\t                'rgba(75, 192, 192, 1)',\r\n");
      out.write("\t                'rgba(153, 102, 255, 1)',\r\n");
      out.write("\t                'rgba(255, 159, 64, 1)'\r\n");
      out.write("\t            ]\r\n");
      out.write("\t        }]\r\n");
      out.write("\t    },\r\n");
      out.write("\t    options: {\r\n");
      out.write("\t     \r\n");
      out.write("\t    }\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
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
