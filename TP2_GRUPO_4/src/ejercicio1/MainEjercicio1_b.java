package ejercicio1;

import java.util.Iterator;
import java.util.TreeSet;

public class MainEjercicio1_b {

	public static void main(String[] args) {		
		
		TreeSet<Profesor> listaPro = new TreeSet<>();
		
		Profesor pro1 = new Profesor("Ramiro",28,"Estudiante",1);
		Profesor pro2 = new Profesor("Dario",25,"Quimica",1);			
		Profesor pro3 = new Profesor("Daniela",34,"Plastica",6);
		Profesor pro4 = new Profesor("Gonzalo",26,"Portero",8);
		Profesor pro5 = new Profesor("Ramiro",42,"Tecnologia",19);
		
		listaPro.add(pro1);
		listaPro.add(pro1);
		listaPro.add(pro2);
		listaPro.add(pro3);
		listaPro.add(pro4);
		listaPro.add(pro5);
		
		Iterator<Profesor> iterador = listaPro.iterator();		
		
		while(iterador.hasNext()) {
			System.out.println(iterador.next().toString());
		}
		
		System.out.println("--------------------");
		
		
		//punto7
		Profesor pro6 = new Profesor("Rafael",39,"Fisica",13);
		Profesor pro7 = new Profesor("Rafael",39,"Fisica",13);
				
		listaPro.add(pro6);
		listaPro.add(pro7);			
			
		if(pro6.equals(pro7)) System.out.println("Es el mismo profesor");
	}

}
