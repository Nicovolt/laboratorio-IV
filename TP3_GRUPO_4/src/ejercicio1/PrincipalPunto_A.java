package ejercicio1;

import javax.swing.JOptionPane;

public class PrincipalPunto_A {

	public static void main(String[] args) {				
				
		String dni = JOptionPane.showInputDialog("Ingresa un DNI: ");

        if (dni == null) {            
            JOptionPane.showMessageDialog(null, "Cancelaste. Cerrando el programa...");
            System.exit(0); 
        }  
      
        
        try {
			
			Dni.verificarDniInvalido(dni);
			JOptionPane.showMessageDialog(null, "DNI " + dni);
			System.out.println("DNI valido!!!");
		
		} catch (DniInvalido e) {
			
			JOptionPane.showMessageDialog(null, "DNI con errores contiene LETRAS.");
			e.printStackTrace();		
		
		}      
        
    }	

}
