package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Personas;

public class PersonaDaoImpl implements PersonaDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdPersonas";

	@Override
	public int insertPersona(Personas persona) {
		
		String query = "INSERT INTO Personas(Dni,Nombre,Apellido)" + " VALUES('" + persona.getDni() + "'," + "'"
				       + persona.getNombre() + "','" + persona.getApellido() + "')";

		Connection cn = null;
		Statement st = null;
		int filas = 0;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			st = cn.createStatement();
			filas = st.executeUpdate(query);

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Error ya exite DNI");
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

	@Override
	public int deletePersona(Personas persona){
		
		Connection cn = null;
		PreparedStatement st = null;
		int filas = 0;
		
		try {
			
			cn = DriverManager.getConnection(host + dbName, user, pass);
			String query = "DELETE FROM Personas WHERE Dni = ?";
			
		    st = cn.prepareStatement(query);
			st.setString(1, persona.getDni());
			filas = st.executeUpdate();			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
		     
			try {
		             if (st != null)st.close();
		            if (cn != null) cn.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		}
		
		return filas;
	}

	@Override
	public int updatePersona(Personas persona) {
		 
		Connection cn = null;
		PreparedStatement ps = null;		
		int filas = 0;
		
		try {
			
			cn = DriverManager.getConnection(host + dbName, user, pass);			
			String query = "UPDATE Personas SET Nombre = ?, Apellido = ? WHERE Dni = ?";
			
			ps = cn.prepareStatement(query);			
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setString(3, persona.getDni());
			
			filas = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        try {
	            if (ps != null) ps.close();
	            if (cn != null) cn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
				
		return filas;
	}

	@Override
	public List<Personas> readAllPersona() {
		
		Connection cn = null;
		Statement st = null;
		List<Personas> listaPersonas = new ArrayList<Personas>();
		
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);			
			st = cn.createStatement();
			String query = "SELECT * FROM Personas";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				Personas persona = new Personas();
				persona.setDni(rs.getString("Dni"));
				persona.setNombre(rs.getString("Nombre"));
				persona.setApellido(rs.getString("Apellido"));
				listaPersonas.add(persona);
			}						
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}			
		
		return listaPersonas;
	}

}
