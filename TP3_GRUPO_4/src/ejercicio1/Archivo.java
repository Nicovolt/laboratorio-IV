package ejercicio1;

import java.io.*;
import java.util.*;

public class Archivo {

	public static TreeSet<Persona> leerPersonas(String rutaArchivo) {
		List<String> lineas = new ArrayList<>();
		TreeSet<Persona> listaPersona = new TreeSet<Persona>();

		try {
			FileReader entrada = new FileReader(rutaArchivo);
			BufferedReader miBuffer = new BufferedReader(entrada);

			String linea;
			while ((linea = miBuffer.readLine()) != null) {
				lineas.add(linea);
			}
			entrada.close();

			if (lineas.isEmpty()) {
				System.out.println("El archivo está vacío o no contiene líneas.");
			} else {
				System.out.println("Archivo leído correctamente:");
				for (String l : lineas) {
					String[] separador = l.split("-");
					if (separador.length == 3) {

						String apellido = separador[0];
						String nombre = separador[1];
						String dni = separador[2];

						try {
							Dni.verificarDniInvalido(dni);
							Persona p = new Persona(apellido, nombre, dni);
							listaPersona.add(p);
						} catch (DniInvalido e) {
							System.out.println("DNI inválido detectado y descartado: " + dni);
						}
					}
				}

			}

		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		return listaPersona;
	}
	
	public static boolean escribirPersonas(Collection<Persona> personas, String rutaArchivo) {
		
		try {
			FileWriter escritor = new FileWriter(rutaArchivo);
			BufferedWriter miBuffer = new BufferedWriter(escritor);
			
			for(Persona persona : personas) {
				miBuffer.write(persona.toString());
				miBuffer.newLine();
			}
			
			miBuffer.close();
			escritor.close();
			return true;
			
		} catch (IOException e) {

			System.out.println("Error al escribir en elArchivo: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}

}
