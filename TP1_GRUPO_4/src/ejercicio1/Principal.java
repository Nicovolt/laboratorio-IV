package ejercicio1;

public class Principal {

	public static void main(String[] args) {
								
		Empleado[] emp = new Empleado[5];
		
		emp[0] = new Empleado();
		emp[1] = new Empleado();
		emp[2] = new Empleado();
		emp[3] = new Empleado("Jose",45);
		emp[4] = new Empleado("Pablo",24);		
				
		for (var empleado : emp) {
			
			System.out.println(empleado.toString());			
		}				
		System.out.println("---------------");
		System.out.println("Proximo Id empleado: " + Empleado.devuelveProximoID());

	}

}
