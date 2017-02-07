package procesosSincronos;

import java.util.*;

public class ejercicio9 extends Thread {
	
	//Creamos variables estaticas para usarlas en todo el programa.
	static String frase;
	static int contador = 0;
	
	//Hacemos el contructor para ahorrarnos preguntar el nombre o cambiarlo en cada hilo.
	public ejercicio9 (String nombre){
		this.setName(nombre);
	}
	
	//Todos los métodos para contar vocales.
	private void contarA ()
	{
		
		for(int i=0; i<frase.length(); i++){
			if(frase.charAt(i) == 'a' || frase.charAt(i) == 'A')
				sumaVocal();
		}
	}
	
	private void contarE ()
	{

		for(int i=0; i<frase.length(); i++){
			if(frase.charAt(i) == 'e' || frase.charAt(i) == 'E')
				sumaVocal();
		}
		
	}
	
	private void contarI ()
	{

		for(int i=0; i<frase.length(); i++){
			if(frase.charAt(i) == 'i' || frase.charAt(i) == 'I')
				sumaVocal();
		}
	}
	
	private void contarO ()
	{

		for(int i=0; i<frase.length(); i++){
			if(frase.charAt(i) == 'o' || frase.charAt(i) == 'O')
				sumaVocal();
		}
	}
	private void contarU ()
	{

		for(int i=0; i<frase.length(); i++){
			if(frase.charAt(i) == 'u' || frase.charAt(i) == 'U')
				sumaVocal();
		}
	}
	
	private synchronized void sumaVocal(){
		contador++;
	}
	
	
	public static void main (String [] args){
		
		System.out.println("Dime una frase: ");
		Scanner sc = new Scanner(System.in);
		frase = sc.nextLine();
		
		
		ejercicio9 hilo1 = new ejercicio9("hilo1");
		ejercicio9 hilo2 = new ejercicio9("hilo2");
		ejercicio9 hilo3 = new ejercicio9("hilo3");
		ejercicio9 hilo4 = new ejercicio9("hilo4");
		ejercicio9 hilo5 = new ejercicio9("hilo5");
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		
		//Nos tenemos que esperar a que acaben todos los hilos para mostrar el resultado final
		try{
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
			hilo5.join();
			
		}catch (InterruptedException e ){
			System.out.println("Error"+e);
		}
		System.out.println("El numero de vocales es: "+contador);
		
	}
	
	public void run(){
		if(this.getName().compareTo("hilo1")==0){
			contarA();
		}
		if(this.getName().compareTo("hilo2")==0){
			this.contarE();
		}
		if(this.getName().compareTo("hilo3")==0){
			this.contarI();
		}
		if(this.getName().compareTo("hilo4")==0){
			this.contarO();
		}
		if(this.getName().compareTo("hilo5")==0){
			this.contarU();
		}
		
	}
	
	
}

