package ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;

public class MainEjercicio1_a {

	public static void main(String[] args) {
		
		ArrayList<Profesor> pro = new ArrayList<>();
		
		pro.add(new Profesor());
		pro.add(new Profesor());
		pro.add(new Profesor("Jose",39,"Matematicas", 12));
		pro.add(new Profesor("Pedro",45,"Lengua",19));
		pro.add(new Profesor("Hernan",29,"Arte",10));
				
		Iterator<Profesor> iterador = pro.iterator();
		
		while(iterador.hasNext()) {			
			System.out.println(iterador.next().toString());			
		}	
		
	}	

}
