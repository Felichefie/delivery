public class Main {// el nombre de la clase debe ser igual al nombre el archivo


	public static void main(String argumentos []){		
		//System.out.println("\nPrueba clase ubicacion");
	//	Ubicacion morelia = new Ubicacion(19.70078, -101.18443);
		//Ubicacion monterrey = new Ubicacion(25.67507, -100.31847);
		//double distancia_km = morelia.distancia( monterrey) * 111.319;
		//System.out.println(distancia_km);

		Direccion mi_direccion = new Direccion();
   		 mi_direccion.imprimir();

		Ubicacion ubicacion = new Ubicacion(19.0, -101);
		Usuario elena = new Usuario(ubicacion,mi_direccion);

		elena.imprimir_direccion();
		elena.imprimir_ubicacion();
		 
    

	}

}