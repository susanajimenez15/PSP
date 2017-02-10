import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLProtocolException;

public class Ejercicio6 extends Thread{
	private String mensaje;
	
	public static void main(String[] args){
		HiloServidorEj6 hiloservidor = new HiloServidorEj6();
		hiloservidor.start();
		HiloClienteEj6 hilocliente = new HiloClienteEj6();
		hilocliente.start();
	}
}

//Clase para el socket servidor
class HiloServidorEj6 extends Thread{
	public void run(){
		try{
			//Creamos el socket servidor
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress address = new InetSocketAddress("192.168.26.158", 60000);
			serverSocket.bind(address);
			
			Socket aceptar = serverSocket.accept();
			System.out.println("Cliente conectado");
			while(true){
			}
			
		} catch (Exception e){
			System.out.println("Error creando el socket servidor");
		}
		
	}
}

//Clase para el socket cliente
class HiloClienteEj6 extends Thread{
	public void run(){
		Socket cliente;
		 do{
			 cliente = new Socket();
			 try{
				 //Establecer la conexión 
				 InetSocketAddress address = new InetSocketAddress("192.168.26.189", 60000);
				 cliente.connect(address);
			 } catch (Exception e) {
				System.out.println("Imposible establecer la conexión");
				try {
					sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			 }
		 }while(!cliente.isConnected());
		 System.out.println("Conectado al servidor");
	}				 
}