/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2019-12-19 13:00:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Dominio.Alumno;
import Dominio.Materia;
import Dominio.Curso;
import Dominio.Profesor;
import Dominio.Usuario;
import Negocio.AlumnoNegocio;
import Dominio.Calificaciones;
import Negocio.MateriaNegocio;
import Negocio.ProfesorNegocio;
import Negocio.ReportesNegocio;
import java.util.ArrayList;

public final class reportes_002davanzados_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("Negocio.ReportesNegocio");
    _jspx_imports_classes.add("Dominio.Alumno");
    _jspx_imports_classes.add("Negocio.MateriaNegocio");
    _jspx_imports_classes.add("Dominio.Curso");
    _jspx_imports_classes.add("Dominio.Profesor");
    _jspx_imports_classes.add("Dominio.Calificaciones");
    _jspx_imports_classes.add("Negocio.AlumnoNegocio");
    _jspx_imports_classes.add("Negocio.ProfesorNegocio");
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
      out.write("    \r\n");
      out.write("    \r\n");
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
      out.write("<body>\r\n");
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
      out.write("\t<div class=\"encabezados\">\r\n");
      out.write("\t\t<h3>REPORTES AVANZADOS</h3>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"form-reportes-avanzados\">\r\n");
      out.write("\t\t\t<form method=\"post\" action=\"serveletReportes\">\r\n");
      out.write("\t\t\t<div class=\"busqueda-califaciones\">\r\n");
      out.write("\t\t\t\t<h2>SELECCIONE CURSO</h2>\r\n");
      out.write("\t\t\t\t<select name=\"cboxMaterias\" id=\"cboxMaterias\" required>\r\n");
      out.write("\t\t\t\t\t<option disabled selected>Seleccione Materia</option>\r\n");
      out.write("\t\t\t\t\t");

							MateriaNegocio Materias = new MateriaNegocio();
							for(Materia unaMateria : Materias.ListadoMaterias()){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option class=\"opciones\" value=\"");
      out.print(unaMateria.getIdMateria());
      out.write('"');
      out.write('>');
      out.print( unaMateria.getNombre());
      out.write("</option>");
}
      out.write("\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<select name=\"cboxSemestre\" required>\r\n");
      out.write("\t\t\t\t\t<option disabled selected>Seleccione Semestre</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"Primero\">Primero</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"Segundo\">Segundo</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<select name=\"cboxProfesores\" id=\"cboxProfesores\" required>\r\n");
      out.write("\t\t\t\t\t<option disabled selected>Seleccione Profesor</option>\r\n");
      out.write("\t\t\t\t\t");

							ProfesorNegocio ProfesorNegocio = new ProfesorNegocio();
							for(Profesor unProfesor : ProfesorNegocio.ListadoProfesores()){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option class=\"opciones\" value=\"");
      out.print(unProfesor.getLegajo());
      out.write('"');
      out.write('>');
      out.print( unProfesor.getNombre() + " " + unProfesor.getApellido());
      out.write("</option>");
}
      out.write("\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<input name=\"anio\" type=\"number\" placeholder=\"Seleccione año\" max=2030 min=2000>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Buscar\" name=\"btnBuscar\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\t<div class=\"resultado-busqueda\">\r\n");
      out.write("\t\t\t<h2 class=\"titulos\">ESTADO DE CALIFICACIONES DE LOS ALUMNOS</h2>\r\n");
      out.write("\t\t\t\t<div class=\"tabla-resultado-busqueda\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<table class=\"content-table\" id=\"tabla-primera\">\r\n");
      out.write("\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Legajo</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Nombre</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Apellido</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Parcial 1</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Parcial 2</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Nota Final</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Asistencia</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Estado</th>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>  \r\n");
      out.write("\t\t");
 
		
		if(request.getAttribute("ListadoAlumnoxCursoSeleccionado")!=null){
			
			ArrayList<Curso>ListadoAlumnosxCurso = (ArrayList<Curso>)request.getAttribute("ListadoAlumnoxCursoSeleccionado");
			AlumnoNegocio AlumnoNegocio = new AlumnoNegocio();
			
			for(Curso unCurso : ListadoAlumnosxCurso){	

				for(Alumno alumnosxcurso : unCurso.getListadoAlumnos()){			
				
				
      out.write("<tr>\r\n");
      out.write("\t\t\t\t  <td>");
      out.print( alumnosxcurso.getLegajo());
      out.write("</td>\r\n");
      out.write("\t\t\t\t  <td>");
      out.print( alumnosxcurso.getNombre());
      out.write("</td>\r\n");
      out.write("\t\t\t\t  <td>");
      out.print( alumnosxcurso.getApellido() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
for(Calificaciones calificacionxalumno : unCurso.getListadoNotas()){
					
					if(alumnosxcurso.getLegajo()==calificacionxalumno.getLegajoAlumno()){
						int notaUno,notaDos=0;
						float promedio=0;
						String estado="";
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(notaUno = AlumnoNegocio.calcularNota(calificacionxalumno.getParcialUno(), calificacionxalumno.getRecuperatorioUno()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(notaDos = AlumnoNegocio.calcularNota(calificacionxalumno.getParcialDos(), calificacionxalumno.getRecuperatorioDos()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(promedio = AlumnoNegocio.calcularPromedio(notaUno, notaDos));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(estado = calificacionxalumno.getEstado() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(AlumnoNegocio.EstadoAlumno(promedio, estado, notaUno, notaDos));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t");
}
						
				}
			}
      out.write(" \r\n");
      out.write("\t\t\t\t</tr> \r\n");
      out.write("\t");
}}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t<div class=\"graficos-resultado-busqueda\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-reportes-graficos\">\r\n");
      out.write("\t\t\t\t\t\t<h3>RESULTADO GENERAL</h3>\r\n");
      out.write("\t\t\t\t\t\t<canvas id=\"estado-alumnos\"></canvas>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-reportes-graficos\">\r\n");
      out.write("\t\t\t\t\t\t<h3>RESULTADO PRIMER PARCIAL</h3>\r\n");
      out.write("\t\t\t\t\t\t<canvas id=\"notas-primer-parcial\"></canvas>\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-reportes-graficos\">\r\n");
      out.write("\t\t\t\t\t\t<h3>RESULTADO SEGUNDO PARCIAL</h3>\r\n");
      out.write("\t\t\t\t\t\t<canvas id=\"notas-segundo-parcial\"></canvas>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"resultado-busqueda-asistencias\">\r\n");
      out.write("\t\t\t<h2 class=\"titulos\">ESTADO DE ASISTENCIA DE LOS ALUMNOS</h2>\r\n");
      out.write("\t\t\t\t<div class=\"graficos-resultado-busqueda\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-reportes-graficos-asistencias\">\r\n");
      out.write("\t\t\t\t\t\t<h3>TOTAL ESTADO ASISTENCIAS</h3>\r\n");
      out.write("\t\t\t\t\t\t<canvas id=\"estado-asistencias\"></canvas>\r\n");
      out.write("\t\t\t\t\t</div>\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t\t<div class=\"tabla-resultado-busqueda\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<table class=\"content-table\" id=\"tabla-segunda\">\r\n");
      out.write("\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Legajo</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Nombre</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Apellido</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>Estado</th>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t");
if(request.getAttribute("ListadoAsistencia")!=null){
								
								for(Alumno unAlumno : (ArrayList<Alumno>)request.getAttribute("ListadoAsistencia")){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>");
      out.print( unAlumno.getLegajo() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>");
      out.print( unAlumno.getNombre() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>");
      out.print( unAlumno.getApellido() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>");
      out.print( unAlumno.getTelefono() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t");
}
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\t\t\r\n");
      out.write("\t</div>\t\t\r\n");
      out.write("</section>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("function ListadoEstados(){\r\n");
      out.write("\t\r\n");
      out.write("\tlet cuentaPromocion=0;\r\n");
      out.write("\tlet cuentaReguralizacion=0;\r\n");
      out.write("\tlet cuentaDesaprobados =0;\r\n");
      out.write("\t\r\n");
      out.write("\t$('#tabla-primera tr').each(function () {\r\n");
      out.write("\r\n");
      out.write("\t\tvar estado = $(this).find(\"td\").eq(7).html();\r\n");
      out.write("\t\tif(typeof(estado)!=='undefined') {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(estado===\"Promociona\") cuentaPromocion++;\r\n");
      out.write("\t\t\telse if(estado===\"Regulariza\") cuentaReguralizacion++;\r\n");
      out.write("\t\t\telse cuentaDesaprobados++;\r\n");
      out.write("\t\t}\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tlet ListadoEstado=[cuentaDesaprobados,cuentaReguralizacion,cuentaPromocion];\r\n");
      out.write("\t\r\n");
      out.write("\treturn ListadoEstado;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function ListadoEstadoParcialUno(){\r\n");
      out.write("\t\r\n");
      out.write("\tlet cuentaAprobados=0;\r\n");
      out.write("\tlet cuentaDesaprobados=0;\r\n");
      out.write("\t\r\n");
      out.write("\t$('#tabla-primera tr').each(function () {\r\n");
      out.write("\r\n");
      out.write("\t\tvar nota = $(this).find(\"td\").eq(3).html();\r\n");
      out.write("\t\tif(typeof(nota)!=='undefined') {\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(nota>=6) cuentaAprobados++;\r\n");
      out.write("\t\t\telse cuentaDesaprobados++;\r\n");
      out.write("\t\t}\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tlet ListadoNotasParcialUno=[cuentaAprobados,cuentaDesaprobados];\r\n");
      out.write("\treturn ListadoNotasParcialUno;\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function ListadoEstadoParcialDos(){\r\n");
      out.write("\t\r\n");
      out.write("\tlet cuentaAprobados=0;\r\n");
      out.write("\tlet cuentaDesaprobados=0;\r\n");
      out.write("\t\r\n");
      out.write("\t$('#tabla-primera tr').each(function () {\r\n");
      out.write("\r\n");
      out.write("\t\tvar nota = $(this).find(\"td\").eq(4).html();\r\n");
      out.write("\t\tif(typeof(nota)!=='undefined') {\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(nota>=6) cuentaAprobados++;\r\n");
      out.write("\t\t\telse cuentaDesaprobados++;\r\n");
      out.write("\t\t}\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tlet ListadoEstadoParcialDos=[cuentaAprobados,cuentaDesaprobados];\r\n");
      out.write("\treturn ListadoEstadoParcialDos;\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function ListadoAsistencia(){\r\n");
      out.write("\t\r\n");
      out.write("\tlet cuentaRegulares=0;\r\n");
      out.write("\tlet cuentaLibres=0;\r\n");
      out.write("\t\r\n");
      out.write("\t$('#tabla-segunda tr').each(function () {\r\n");
      out.write("\r\n");
      out.write("\t\tvar estado = $(this).find(\"td\").eq(3).html();\r\n");
      out.write("\t\tif(typeof(estado)!=='undefined') {\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(estado==\"Regular\") cuentaRegulares++;\r\n");
      out.write("\t\t\telse cuentaLibres++;\r\n");
      out.write("\t\t}\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tlet ListadoAsistencias=[cuentaRegulares,cuentaLibres];\r\n");
      out.write("\treturn ListadoAsistencias;\t\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("var ctx = document.getElementById('estado-alumnos').getContext('2d');\r\n");
      out.write("var myChart = new Chart(ctx, {\r\n");
      out.write("    type: 'doughnut',\r\n");
      out.write("    data: {\r\n");
      out.write("        labels: ['Recursantes','Regularizados', 'Promocionados'],\r\n");
      out.write("        datasets: [\r\n");
      out.write("        \t\r\n");
      out.write("        \t{\r\n");
      out.write("\t        \tlabel:\"Alumnos\",\r\n");
      out.write("\t            data: ListadoEstados() ,\r\n");
      out.write("\t            fill: false,            \r\n");
      out.write("\t            borderWidth: 1, \r\n");
      out.write("\t            backgroundColor: [\r\n");
      out.write("\t                'rgba(255, 206, 86, 0.2)',\r\n");
      out.write("\t                'rgba(255, 99, 132, 0.2)',\r\n");
      out.write("\t                'rgba(54, 162, 235, 0.2)'\r\n");
      out.write("\t            ],\r\n");
      out.write("\t            borderColor: [\r\n");
      out.write("\t            \t\r\n");
      out.write("\t            \t'rgba(255, 206, 86, 1)',\r\n");
      out.write("\t            \t'rgba(255, 99, 132, 1)',\r\n");
      out.write("\t                'rgba(54, 162, 235, 1)'\r\n");
      out.write("\r\n");
      out.write("\t            ]\r\n");
      out.write("        \t}\r\n");
      out.write("\r\n");
      out.write("        ]\r\n");
      out.write("    }\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var ctx = document.getElementById('notas-segundo-parcial').getContext('2d');\r\n");
      out.write("var myChart = new Chart(ctx, {\r\n");
      out.write("    type: 'doughnut',\r\n");
      out.write("    data: {\r\n");
      out.write("        labels: ['Aprobados','Desaprobados'],\r\n");
      out.write("        datasets: [\r\n");
      out.write("        \t\r\n");
      out.write("        \t{\r\n");
      out.write("\t        \tlabel:\"Alumnos\",\r\n");
      out.write("\t            data: ListadoEstadoParcialDos(),\r\n");
      out.write("\t            fill: false,            \r\n");
      out.write("\t            borderWidth: 1, \r\n");
      out.write("\t            backgroundColor: [\r\n");
      out.write("\t                'rgba(255, 206, 86, 0.2)',\r\n");
      out.write("\t                'rgba(255, 99, 132, 0.2)',\r\n");
      out.write("\t                'rgba(54, 162, 235, 0.2)'\r\n");
      out.write("\t            ],\r\n");
      out.write("\t            borderColor: [\r\n");
      out.write("\t            \t\r\n");
      out.write("\t            \t'rgba(255, 206, 86, 1)',\r\n");
      out.write("\t            \t'rgba(255, 99, 132, 1)',\r\n");
      out.write("\t                'rgba(54, 162, 235, 1)'\r\n");
      out.write("\r\n");
      out.write("\t            ]\r\n");
      out.write("        \t}\r\n");
      out.write("\r\n");
      out.write("        ]\r\n");
      out.write("    }\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var ctx = document.getElementById('notas-primer-parcial').getContext('2d');\r\n");
      out.write("var myChart = new Chart(ctx, {\r\n");
      out.write("    type: 'doughnut',\r\n");
      out.write("    data: {\r\n");
      out.write("        labels: ['Aprobados','Desaprobados'],\r\n");
      out.write("        datasets: [\r\n");
      out.write("        \t\r\n");
      out.write("        \t{\r\n");
      out.write("\t        \tlabel:\"Alumnos\",\r\n");
      out.write("\t            data: ListadoEstadoParcialUno(),\r\n");
      out.write("\t            fill: false,            \r\n");
      out.write("\t            borderWidth: 1, \r\n");
      out.write("\t            backgroundColor: [\r\n");
      out.write("\t                'rgba(255, 206, 86, 0.2)',\r\n");
      out.write("\t                'rgba(255, 99, 132, 0.2)',\r\n");
      out.write("\t                'rgba(54, 162, 235, 0.2)'\r\n");
      out.write("\t            ],\r\n");
      out.write("\t            borderColor: [\r\n");
      out.write("\t            \t\r\n");
      out.write("\t            \t'rgba(255, 206, 86, 1)',\r\n");
      out.write("\t            \t'rgba(255, 99, 132, 1)',\r\n");
      out.write("\t                'rgba(54, 162, 235, 1)'\r\n");
      out.write("\r\n");
      out.write("\t            ]\r\n");
      out.write("        \t}\r\n");
      out.write("\r\n");
      out.write("        ]\r\n");
      out.write("    }\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var ctx = document.getElementById('estado-asistencias').getContext('2d');\r\n");
      out.write("var myChart = new Chart(ctx, {\r\n");
      out.write("    type: 'doughnut',\r\n");
      out.write("    data: {\r\n");
      out.write("        labels: ['Regulares','Libres'],\r\n");
      out.write("        datasets: [\r\n");
      out.write("        \t\r\n");
      out.write("        \t{\r\n");
      out.write("\t        \tlabel:\"Alumnos\",\r\n");
      out.write("\t            data: ListadoAsistencia(),\r\n");
      out.write("\t            fill: false,            \r\n");
      out.write("\t            borderWidth: 1, \r\n");
      out.write("\t            backgroundColor: [\r\n");
      out.write("\t                'rgba(255, 206, 86, 0.2)',\r\n");
      out.write("\t                'rgba(255, 99, 132, 0.2)'\r\n");
      out.write("\t            ],\r\n");
      out.write("\t            borderColor: [\r\n");
      out.write("\t            \t\r\n");
      out.write("\t            \t'rgba(255, 206, 86, 1)',\r\n");
      out.write("\t            \t'rgba(255, 99, 132, 1)'\r\n");
      out.write("\r\n");
      out.write("\t            ]\r\n");
      out.write("        \t}\r\n");
      out.write("\r\n");
      out.write("        ]\r\n");
      out.write("    }\r\n");
      out.write("});\r\n");
      out.write("\r\n");
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
