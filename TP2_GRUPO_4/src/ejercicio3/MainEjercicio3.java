package ejercicio3;

import java.util.ArrayList;
import java.util.ListIterator;

public class MainEjercicio3 {

	public static void main(String[] args) {		
		
		ArrayList<IEdificio> listaEdificios = new ArrayList<>();
		
		listaEdificios.add(new Polideportivo(700,1,"Salon Voley"));
		listaEdificios.add(new Polideportivo(900.5,2,"Salon Basquet"));
		listaEdificios.add(new Polideportivo(200,3,"Salon Handball"));
		listaEdificios.add(new EdificioOficinas(4, 250.5));
		listaEdificios.add(new EdificioOficinas(7, 325.4));
		
		ListIterator<IEdificio> iterador = listaEdificios.listIterator();
		
		while(iterador.hasNext()) {		
			System.out.println(iterador.next().toString());
		}	

	}

}
