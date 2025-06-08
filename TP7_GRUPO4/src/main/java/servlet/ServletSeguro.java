package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguros;
import dominio.SegurosDao;
import dominio.TipoSeguros;
import dominio.TipoSegurosDao;


@WebServlet("/ServletSeguro")
public class ServletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ServletSeguro() {
        super();       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		if(request.getParameter("Param") != null || request.getParameter("txtAceptar") != null){
			
			List<TipoSeguros> listaTipoSeguros = new ArrayList<TipoSeguros>();			
			TipoSegurosDao tipoDao = new TipoSegurosDao();
			
			listaTipoSeguros = tipoDao.readAllTipoSeguros();
			
			request.setAttribute("listaTipo", listaTipoSeguros);
			
			SegurosDao seguroDao = new SegurosDao();
			int id = seguroDao.obtenerProximoId();
			
			request.setAttribute("idSeguro", id);			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("agregar.jsp");
	        dispatcher.forward(request, response);			
		}
		
		
		if(request.getParameter("Parametro") != null){
				
				List<Seguros> listaSeguros = new ArrayList<Seguros>();
				List<TipoSeguros> listaTipo = new ArrayList<TipoSeguros>();
				
				SegurosDao seguroDao = new SegurosDao();				
				TipoSegurosDao tipoDao = new TipoSegurosDao();
				
				listaSeguros = seguroDao.readAllSeguros();
				
				listaTipo = tipoDao.readAllTipoSeguros();
				
				request.setAttribute("listaTipo", listaTipo);
				request.setAttribute("listaSeguro", listaSeguros);				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
		        dispatcher.forward(request, response);			
			}
		
		if(request.getParameter("txtFiltrar") != null) {
			
			List<Seguros> seguros = new ArrayList<Seguros>();
			List<Seguros> listaFiltrada = new ArrayList<Seguros>();
			List<TipoSeguros> listaTipo = new ArrayList<TipoSeguros>();
			
			SegurosDao segurosDao = new SegurosDao();
			TipoSegurosDao tipoDao = new TipoSegurosDao();	
			
			seguros = segurosDao.readAllSeguros();
			listaTipo = tipoDao.readAllTipoSeguros();
			
			 int idSeleccionado = Integer.parseInt(request.getParameter("seleccion"));
			
			
			if(request.getParameter("seleccion") != null && !request.getParameter("seleccion").isEmpty() 
			   && idSeleccionado != 0) {					
				
				for(Seguros segu : seguros) {
					
					if(segu.getIdTipo() == idSeleccionado) {
						
						listaFiltrada.add(segu);
						
					} 
				}
				
				request.setAttribute("listaFiltrada", listaFiltrada);
				request.setAttribute("listaTipo", listaTipo);
				
			} else {
				request.setAttribute("listaFiltrada", seguros);
				request.setAttribute("listaTipo", listaTipo);
				
			}		
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
			dispatcher.forward(request, response);			
			
		}		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		if(request.getParameter("txtAceptar") != null) {
			
			Seguros seguro = new Seguros();
			SegurosDao seguroDao = new SegurosDao();
			
			
			seguro.setDescripcion(request.getParameter("txtDescripcion"));			
		    seguro.setIdTipo(Integer.parseInt(request.getParameter("idNum")));
			seguro.setCostoContratacion(new BigDecimal(request.getParameter("txtCosto")));
			seguro.setCostoAsegurado(new BigDecimal(request.getParameter("txtCostoMax")));	
			
			int filas = seguroDao.insertSeguros(seguro);			
			
			
			if(filas == 0) {
				System.out.println("Aca esta el error");				
			} 
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("agregar.jsp");
			response.sendRedirect("ServletSeguro?Param=1");
	        //dispatcher.forward(request, response);
			
		}
		
	}

}
