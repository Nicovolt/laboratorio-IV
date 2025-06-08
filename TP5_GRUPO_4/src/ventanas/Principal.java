package ventanas;

import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.DefaultListModel;

import diagramaClases.Categorias;
import diagramaClases.Peliculas;

public class Principal {

	public static void main(String[] args) {		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Ventana frame = new Ventana();						
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});		
		
		/*Peliculas pelicula = new Peliculas("zulo",new Categorias("Terror"));
		Peliculas pelicula1 = new Peliculas("acosta",new Categorias("Comedia"));
		Peliculas pelicula2 = new Peliculas("julio",new Categorias("Drama"));
		
		Set<Peliculas> peliculas = new TreeSet<>();
		peliculas.add(pelicula);
		peliculas.add(pelicula1);
        peliculas.add(pelicula2);
        
        Iterator<Peliculas> listaPeli = peliculas.iterator();        
        
        while(listaPeli.hasNext()) {
        	System.out.println(listaPeli.next().toString());
        }*/
        
        
	}

}
