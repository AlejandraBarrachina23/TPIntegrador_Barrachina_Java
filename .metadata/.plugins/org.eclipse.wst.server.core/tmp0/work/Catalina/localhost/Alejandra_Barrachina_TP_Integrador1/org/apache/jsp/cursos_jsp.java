/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2019-12-16 18:16:15 UTC
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
import DAO.AlumnosDAO;
import Dominio.Profesor;
import Negocio.MateriaNegocio;
import Negocio.ProfesorNegocio;
import java.util.ArrayList;

public final class cursos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("Dominio.Materia");
    _jspx_imports_classes.add("Dominio.Alumno");
    _jspx_imports_classes.add("Negocio.MateriaNegocio");
    _jspx_imports_classes.add("DAO.AlumnosDAO");
    _jspx_imports_classes.add("Dominio.Profesor");
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
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("     \r\n");
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
      out.write("\t\t<a href=\"ServeletUsuario\">LogOut</a>\r\n");
      out.write("\t</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu-administrador.html", out, false);
      out.write("\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<section class=\"section-principal\">\r\n");
      out.write("\t<div class=\"encabezados\"><h3>ALTA CURSOS</h3></div>\r\n");
      out.write("\t\t<form method=\"post\" action=\"ServeletCurso\" id=\"form-cursos\">\r\n");
      out.write("\t\t\t<!---------------------------------------------------------------------------------------------------------------\r\n");
      out.write("\t\t\t\t\tFORM IZQUIERDA - ARRIBA\r\n");
      out.write("\t\t\t<!-------------------------------------------------------------------------------------------------------------->\r\n");
      out.write("\t\t\t<div id=\"form-curso-izquierda\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"form-cursos-encabezado-izquierda\">\t\t\r\n");
      out.write("\t\t\t\t\t<h2>1. SELECCIONA LOS DATOS DEL CURSO</h2>\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>Materia</label>\r\n");
      out.write("\t\t\t\t\t<select id=\"cboxMaterias\" required>\r\n");
      out.write("\t\t\t\t\t<option disabled selected>Seleccione una Materia</option>\r\n");
      out.write("\t\t\t\t\t");
 MateriaNegocio unaMateriaNegocio = new MateriaNegocio();
					for(Materia unaMateria : unaMateriaNegocio.ListadoMaterias()){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option class=\"opciones\" value=\"");
      out.print(unaMateria.getIdMateria());
      out.write('"');
      out.write('>');
      out.print( unaMateria.getNombre());
      out.write("</option>");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t</select><br>\r\n");
      out.write("\t\t\t\t<label>Semestre</label>\r\n");
      out.write("\t\t\t\t\t<select id=\"cboxSemestre\" required>\r\n");
      out.write("\t\t\t\t\t \t<option disabled selected>Seleccione un Semestre</option>\r\n");
      out.write("\t\t\t\t\t\t<option>Primero</option>\r\n");
      out.write("\t\t\t\t\t\t<option>Segundo</option>\r\n");
      out.write("\t\t\t\t\t</select><br>\r\n");
      out.write("\t\t\t\t<label>Año</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"tboxAnio\" name=\"anio\" required><br>\r\n");
      out.write("\t\t\t\t<label>Profesor</label>\r\n");
      out.write("\t\t\t\t\t<select  id=\"cboxProfesores\" required>\r\n");
      out.write("\t\t\t\t\t<option disabled selected>Seleccione un profesor</option>\r\n");
      out.write("\t\t\t\t\t\t");
 ProfesorNegocio unProfesorNegocio = new ProfesorNegocio();
						for(Profesor unProfesor : unProfesorNegocio.ListadoProfesores()){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option class=\"opciones\" value=\"");
      out.print(unProfesor.getLegajo());
      out.write('"');
      out.write('>');
      out.print( unProfesor.getNombre()+" " +unProfesor.getApellido());
      out.write("</option>");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t</select><br>\r\n");
      out.write("\t\t\t<!---------------------------------------------------------------------------------------------------------------\r\n");
      out.write("\t\t\t\t\tFORM IZQUIERDA - ABAJO\r\n");
      out.write("\t\t\t<!-------------------------------------------------------------------------------------------------------------->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"form-cursos-encabezado-izquierda\">\t\t\r\n");
      out.write("\t\t\t\t<h2>2. SELECCIONA LOS ALUMNOS DEL CURSO</h2>\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\t<table id=\"table_id\" class=\"content-table\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Agregar</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Legajo</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Nombre</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Apellido</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t");
 AlumnosDAO unAlumnoDAO = new AlumnosDAO(); 
				for(Alumno unAlumno : unAlumnoDAO.ListadoAlumnos()){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>  \r\n");
      out.write("\t\t\t\t\t\t\t  <td><input type=\"checkbox\"></input></td>\r\n");
      out.write("\t\t\t\t\t\t\t  <td>");
      out.print( unAlumno.getLegajo() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t  <td>");
      out.print( unAlumno.getNombre() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t  <td>");
      out.print( unAlumno.getApellido() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!---------------------------------------------------------------------------------------------------------------\r\n");
      out.write("\t\t\t\t\tFORM DERECHA\r\n");
      out.write("\t\t\t<!-------------------------------------------------------------------------------------------------------------->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<div id=\"form-curso-derecha\">\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t<div class=\"form-cursos-encabezado-izquierda\">\t\t\r\n");
      out.write("\t\t\t\t<h2>3. PREVISUALIZACIÓN DE LA SELECCIÓN</h2>\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<label>Materia: </label><br>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"tboxMateria-previsualizacion\" name=\"tboxMateria-previsualizacion\" required readonly=true><br>\r\n");
      out.write("\t\t\t\t<label>Semestre: </label><br>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"tboxSemestre-previsualizacion\" name=\"tboxSemestre-previsualizacion\" required readonly=true><br>\r\n");
      out.write("\t\t\t\t<label>Año: </label><br>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"tboxAnio-previsualizacion\" value=\"2019\" name=\"tboxAnio-previsualizacion\" required readonly=true><br>\r\n");
      out.write("\t\t\t\t<label>Profesor: </label><br>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"tboxProfesor-previsualizacion\" name=\"tboxProfesor-previsualizacion\" required readonly=true><br>\r\n");
      out.write("\t\t\t\t<label>Listado de Alumnos: </label><br>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"listado-alumnos-oculto\" name=\"listado-alumnos-oculto\" required/>\r\n");
      out.write("\t\t\t\t<ul id=\"listado-alumnos\"></ul>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" id=\"btnAgregarCurso\" name=\"btnAgregarCurso\" class=\"btnFormulario\" value=\"AGREGAR\">\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready( function () {\r\n");
      out.write("\t    $('#table_id').DataTable();\r\n");
      out.write("\t    \r\n");
      out.write("\t} );\r\n");
      out.write("\t\t\r\n");
      out.write("\t//AÑO POR DEFECTO\r\n");
      out.write("\tlet fecha = new Date();\r\n");
      out.write("\tlet anio = fecha.getFullYear();\r\n");
      out.write("\tdocument.getElementById('tboxAnio').value= anio;\r\n");
      out.write("\t\r\n");
      out.write("\t//CAMBIO VALORES INPUTS\r\n");
      out.write("\tdocument.getElementById(\"tboxAnio\").addEventListener('keyup', autoCompletar);\r\n");
      out.write("\tdocument.getElementById(\"cboxSemestre\").addEventListener('change', autoCompletarSemestre);\r\n");
      out.write("\tdocument.getElementById(\"cboxMaterias\").addEventListener('change', autoCompletarMateria);\r\n");
      out.write("\tdocument.getElementById(\"cboxProfesores\").addEventListener('change', autoCompletarProfesor);\r\n");
      out.write("\t\r\n");
      out.write("\tfunction autoCompletar(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#tboxAnio\").keyup(autoCompletar); \r\n");
      out.write("\t\tvar valor = $(this).val();\r\n");
      out.write("\t\t$(\"#tboxAnio-previsualizacion\").val(valor);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction autoCompletarSemestre(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tlet combobox = document.getElementById(\"cboxSemestre\");\r\n");
      out.write("\t\tlet opcionSeleccionada = combobox.options[combobox.selectedIndex].text;\r\n");
      out.write("\t\tdocument.getElementById(\"tboxSemestre-previsualizacion\").value = opcionSeleccionada;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction autoCompletarMateria(){\r\n");
      out.write("\r\n");
      out.write("\t\tlet combobox = document.getElementById(\"cboxMaterias\");\t\r\n");
      out.write("\t\tlet opcionSeleccionada = combobox.options[combobox.selectedIndex].text;\r\n");
      out.write("\t\tlet indiceSeleccionado = document.getElementById(\"cboxMaterias\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"tboxMateria-previsualizacion\").value = indiceSeleccionado + \"-\" + opcionSeleccionada;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction autoCompletarProfesor(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tlet combobox = document.getElementById(\"cboxProfesores\");\t\r\n");
      out.write("\t\tlet opcionSeleccionada = combobox.options[combobox.selectedIndex].text;\r\n");
      out.write("\t\tlet indiceSeleccionado = document.getElementById(\"cboxProfesores\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"tboxProfesor-previsualizacion\").value = indiceSeleccionado + \"-\" + opcionSeleccionada;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//RECORRE TABLA Y AGREGAR/ELIMINA VALORES EN LA LISTA DE ALUMNOS\r\n");
      out.write("\tlet listadoAlumnos=[];\r\n");
      out.write("\tlet listadoLegajoAlumnos=[];\r\n");
      out.write("\t\r\n");
      out.write("\t$('input[type=checkbox]').click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t const legajo = $(this).parents(\"tr\").find(\"td\").eq(1).text();\r\n");
      out.write("\t\t const nombre = $(this).parents(\"tr\").find(\"td\").eq(2).text();\r\n");
      out.write("\t\t const apellido = $(this).parents(\"tr\").find(\"td\").eq(3).text();\r\n");
      out.write("\t\t const itemSeleccionado = legajo+\"-\"+nombre+\" \"+apellido;\r\n");
      out.write("\t\t const lista = document.getElementById(\"listado-alumnos\");\r\n");
      out.write("\t\t $('#listado-alumnos li').remove();\r\n");
      out.write("\t\t document.getElementById(\"listado-alumnos-oculto\").value=\"\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif($(this).is(\":checked\")){\r\n");
      out.write("\t\t\tlistadoAlumnos.push(itemSeleccionado);\r\n");
      out.write("\t\t\tlistadoLegajoAlumnos.push(legajo);\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t let posicion;\r\n");
      out.write("\t\t\t let posicionLegajo;\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t for (let i = 0; i < listadoAlumnos.length; i++) {\r\n");
      out.write("\t\t\t\t if(itemSeleccionado===listadoAlumnos[i]) posicion=i;\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t for (let j = 0; j < listadoLegajoAlumnos.length; j++) {\r\n");
      out.write("\t\t\t\t if(legajo===listadoLegajoAlumnos[j]) posicionLegajo=j;\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\r\n");
      out.write("\t\t\t listadoAlumnos.splice(posicion,1);\r\n");
      out.write("\t\t\t listadoLegajoAlumnos.splice(posicionLegajo,1);\r\n");
      out.write("\t\t\t $('#listado-alumnos li').remove();\r\n");
      out.write("\t\t\t document.getElementById(\"listado-alumnos-oculto\").value=\"\";\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t for (let i = 0; i < listadoAlumnos.length; i++) {\r\n");
      out.write("\t\t\t let item = document.createElement(\"li\");\r\n");
      out.write("\t\t\t item.appendChild(document.createTextNode(listadoAlumnos[i]));\r\n");
      out.write("\t\t\t lista.appendChild(item);\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t for (let j = 0; j < listadoLegajoAlumnos.length; j++) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t let tboxListadoLegajoAlumnos = document.getElementById(\"listado-alumnos-oculto\");\r\n");
      out.write("\t\t\t tboxListadoLegajoAlumnos.value += listadoLegajoAlumnos[j] +\"-\";\r\n");
      out.write("\t\t }\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
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
