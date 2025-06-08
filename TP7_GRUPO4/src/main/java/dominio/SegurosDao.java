package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SegurosDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "facultad";
	private String pass = "Facultad2025!";
	private String dbName = "SegurosGroup";
	
public int insertSeguros(Seguros seguro) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		
		String query = "INSERT INTO seguros(descripcion,idTipo,costoContratacion,costoAsegurado)" + " VALUES('" + seguro.getDescripcion() + "'," + "'"
				       + seguro.getIdTipo() + "','" + seguro.getCostoContratacion() + "', '" + seguro.getCostoAsegurado()+ "')";

		Connection cn = null;
		Statement st = null;
		int filas = 0;
	

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			st = cn.createStatement();
			filas = st.executeUpdate(query);

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
		return filas;	
	}

public int obtenerProximoId() {		
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	int proximoId = 1;
	Connection cn = null;
	Statement st = null;
	
	try {
		
		cn = DriverManager.getConnection(host + dbName, user, pass);
		st = cn.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT MAX(idSeguro) AS maxId FROM seguros");
		
			if (rs.next()) {
			    int maxId = rs.getInt("maxId");
			    if (!rs.wasNull()) {
			        proximoId = maxId + 1;
			    }
			}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
	     
		try {
	            if (st != null) st.close();
	            if (cn != null) cn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	}
	
	return proximoId;
}

public List<Seguros> readAllSeguros() {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}		
	
	String query = "SELECT * FROM seguros";

	Connection cn = null;
	Statement st = null;
	List<Seguros> listaSeguros = new ArrayList<Seguros>();	

	try {
		cn = DriverManager.getConnection(host + dbName, user, pass);
		st = cn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			Seguros seguros = new Seguros();
			
			seguros.setIdSeguro(rs.getInt("idSeguro"));
			seguros.setDescripcion(rs.getString("descripcion"));
			seguros.setIdTipo(rs.getInt("idTipo"));
			seguros.setCostoContratacion(rs.getBigDecimal("costoContratacion"));
			seguros.setCostoAsegurado(rs.getBigDecimal("costoAsegurado"));
			
			listaSeguros.add(seguros);
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
	return listaSeguros;		
	}

}
