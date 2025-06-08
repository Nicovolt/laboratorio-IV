<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="dominio.TipoSeguros" %>

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
	
	<form action="ServletSeguro" method="post">
	
		<%
			int id = 0;
			if(request.getAttribute("idSeguro") != null){
				id = (int)request.getAttribute("idSeguro");
			}
		%>
		<label>Id. Seguro: </label>  <span name="idTipoVisible"><%= id %></span><br>
		<label>Descripción: </label> <input type="text" name="txtDescripcion"> <br>
		<label>Tipo de Seguro: </label>
				
		
		<select id="opciones" name="idNum">
		
		<%
   			 List<TipoSeguros> tipos = (List<TipoSeguros>) request.getAttribute("listaTipo");
    		 if (tipos != null) {
        		for (TipoSeguros t : tipos) {
		%>		
  			<option value="<%= t.getIdTipo() %>"><%= t.getDescripcion() %></option>
  		<%
        		}
    		}
		%>	
  			
		</select>  <br>
		<label>Costo contratación: </label> <input type="text" name="txtCosto"> <br>
		<label>Costo máximo asegurado: </label> <input type="text" name="txtCostoMax"> <br> 
		<input type="submit" name="txtAceptar" value="Aceptar">	
	</form> 
	
	
	



</body>
</html>