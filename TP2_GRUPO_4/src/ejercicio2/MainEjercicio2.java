package ejercicio2;

public class MainEjercicio2 {

	public static void main(String[] args) {
		
		
		Fresco fresco = new Fresco("01/01/2025",5001,"11/12/2024","Argentina");
		Refrigerado refrigerado = new Refrigerado("12/02/2025",159,12540);
		Congelado congelado = new Congelado("23/03/2025",505,5.4f);
		
		System.out.println(fresco.toString());		
		System.out.println("-------------------");
		
		System.out.println(refrigerado.toString());
		System.out.println("-------------------");
		
		System.out.println(congelado.toString());
		System.out.println("-------------------");		

	}

}
