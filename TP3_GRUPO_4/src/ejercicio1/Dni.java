package ejercicio1;

public class Dni {


	public static void verificarDniInvalido(String dni) throws DniInvalido {		
		
		
		for(int i = 0 ; i < dni.length() ; i++) {
			
			if(!Character.isDigit(dni.charAt(i))) { 		
				
			DniInvalido invalido = new DniInvalido(); 
				throw invalido;	
			}	
		}
		

		
	}
	
}
