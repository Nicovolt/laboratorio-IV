<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page import="dominio.Seguros"%>
<%@ page import="dominio.TipoSeguros"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<a href="inicio.jsp">Inicio</a>
	<a href="ServletSeguro?Param=1"> Agregar Seguro </a>
	<a href="ServletSeguro?Parametro=2">Listar Seguro</a>
	
	<h2>"Tipo de seguros de la base de datos"</h2>
	
	<br>
	
	<form action="ServletSeguro" method="get">
		
		<label>Busqueda del tipo de seguro:</label>
		
		<select name="seleccion" >
			
			<option value="0">--Tipo Seguro--</option>			
			
			<%
				List<TipoSeguros> list = null;
			
				if(request.getAttribute("listaTipo") != null){			
				
					list = (List<TipoSeguros>) request.getAttribute("listaTipo");
					
					for(TipoSeguros tipo : list){
						
					
			%>
			
			<option value="<%= tipo.getIdTipo() %>" ><%= tipo.getDescripcion()  %> </option>
			
			<% 		
					}
			
			 	}
			%>
			
		
		</select>
		
		<input type="submit" name="txtFiltrar" value="Filtrar"> 
	
	</form>	
	
		
	<br><br>

	<table border="1px">
		<tr>
			<th>ID</th>
			<th>Descripción Seguro</th>
			<th>Descripción tipo seguro</th>
			<th>Costo contratación</th>
			<th>Costo máximo asegurado</th>
		</tr>

		<%
		List<Seguros> lista = null;
		List<TipoSeguros> listaTipo = null;

		if ((request.getAttribute("listaSeguro") != null || request.getAttribute("listaFiltrada") != null) && request.getAttribute("listaTipo") != null) {

			listaTipo = (List<TipoSeguros>) request.getAttribute("listaTipo");
			
			
			if(request.getAttribute("listaSeguro") != null){
				lista = (List<Seguros>) request.getAttribute("listaSeguro");
			} else{
				lista = (List<Seguros>) request.getAttribute("listaFiltrada");
			}
			
			
			//lista = (List<Seguros>) request.getAttribute("listaSeguro");

			
			for (Seguros seguro : lista) {
		%>

		<tr>
			<td><%=seguro.getIdSeguro()%></td>
			<td><%=seguro.getDescripcion()%></td>
			<td>
				<%
					for (TipoSeguros tipo : listaTipo) {
						if (tipo.getIdTipo() == seguro.getIdTipo()) {
				%> <%=tipo.getDescripcion()%> <%
 					break;
 					}
 				}
			 %>
			</td>

			<td><%=seguro.getCostoContratacion()%></td>
			<td><%=seguro.getCostoAsegurado()%></td>
		</tr>

		<%
		}
		}
		%>

	</table>





</body>
</html>