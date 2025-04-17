package ejercicio1;

import java.util.TreeSet;

public class PrincipalPunto_B {

	public static void main(String[] args) {
		
		String rutaEntrada = "Personas.txt";
		
		TreeSet<Persona> listaPersonas =Archivo.leerPersonas(rutaEntrada);
		
		for (Persona persona : listaPersonas) {
			System.err.println(persona.toString());
		}

	}

}
