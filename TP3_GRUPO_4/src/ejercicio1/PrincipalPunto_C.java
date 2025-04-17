package ejercicio1;

import java.util.TreeSet;

public class PrincipalPunto_C {
	
public static void main(String[] args) {
		
		String rutaEntrada = "Personas.txt";
		
		TreeSet<Persona> listaPersonas =Archivo.leerPersonas(rutaEntrada);
		
		for (Persona persona : listaPersonas) {
			System.err.println(persona.toString());
		}
		
		String rutaSalida = "Resultado.txt";
		boolean resultadoEscritura = Archivo.escribirPersonas(listaPersonas, rutaSalida);
		
		System.out.println("\n===== ESCRITURA DE ARCHIVO RESULTADO.TXT. =====");
		
		if(resultadoEscritura) {
			System.out.println("Archivo: " + rutaSalida + " Creado correctamente.");
		} else {
			System.out.println("Error al crear el archivo: " + rutaSalida);
		}

	}

}
