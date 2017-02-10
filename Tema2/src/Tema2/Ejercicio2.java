package Tema2;
/***********************************************************/
/* Ejercicio	2_EJERCICIO */
/* Autor:	SUSANA JIMENEZ CATALA	*/
/* Fecha:	25-11-2016 */
/***********************************************************/


public class Ejercicio2 {
	
	 static Hilo11Thread hilo1;
	 static Hilo11Thread hilo2;
	
	public static void main (String args []){
			
		//Creamos dos hilos a partir de una misma clase
		hilo1 = new Hilo11Thread();
		hilo1.setName("Hilo 1");
		
		hilo2 = new Hilo11Thread();
		hilo2.setName("Hilo 2");
		
		//Iniciamos los hilos
		hilo2.start();
		hilo1.start();
		
		//Hacemos que el hilo principal se espere a los hilos hijos
		try{
			hilo1.join();
			hilo2.join();
		}catch(InterruptedException e){
			
		}
		System.out.println("Dejaos de gilipolleces");
	}
}

class Hilo11Thread extends Thread{
	
	public void run(){
		
		
			for (int i = 0; i <5; i++){
				if(Thread.currentThread().getName().compareTo("Hilo 1")==0){
					//Escribe el hilo 1 y despierta al hilo2
					System.out.println("A mi me rebota y a ti te explota");
					Ejercicio2.hilo2.interrupt();
					try{
						Ejercicio2.hilo2.join();
					}catch(Exception e){
						
					}
					
				}
				if(Thread.currentThread().getName().compareTo("Hilo 2")==0){
					//System.out.println("ASD");
					//Despierta al hilo 1 y escribe
					try{
						Ejercicio2.hilo1.join();
					}catch(InterruptedException e){
					
					}
					System.out.println("Y tú más");
					Ejercicio2.hilo1.interrupt();
				}
			}
	}
	
}
