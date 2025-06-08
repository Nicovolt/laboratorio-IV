package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class TipoSegurosDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "facultad";
	private String pass = "Facultad2025!";
	private String dbName = "SegurosGroup";
	
public List<TipoSeguros> readAllTipoSeguros() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		
		String query = "SELECT * FROM tipoSeguros";

		Connection cn = null;
		Statement st = null;
		List<TipoSeguros> listaTipo = new ArrayList<TipoSeguros>();	

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				TipoSeguros tipoSeguros = new TipoSeguros();
				tipoSeguros.setIdTipo(rs.getInt("idTipo"));
				tipoSeguros.setDescripcion(rs.getString("descripcion"));
				
				listaTipo.add(tipoSeguros);
			}
			

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Error");
		} finally {
		     
			try {
		            if (st != null) st.close();
		            if (cn != null) cn.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		}

		return listaTipo;		
	}

public TipoSeguros readTipoSeguros(int id) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}		
	
	String query = "SELECT * FROM tipoSeguros WHERE idTipo = "+ id + "";

	Connection cn = null;
	Statement st = null;		

	try {
		cn = DriverManager.getConnection(host + dbName, user, pass);
		st = cn.createStatement();
		ResultSet rs = st.executeQuery(query);
		TipoSeguros tipoSeguros = new TipoSeguros();
		
		if (rs.next()) {			
			tipoSeguros.setIdTipo(rs.getInt("idTipo"));
			tipoSeguros.setDescripcion(rs.getString("descripcion"));
			
			return tipoSeguros;
		}
		

	} catch (Exception e) {

		e.printStackTrace();
		System.out.println("Error");
	} finally {
	     
		try {
	            if (st != null) st.close();
	            if (cn != null) cn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	}

		return null;		
	}


}
