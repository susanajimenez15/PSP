import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio5servidor {
	public static void main(String[] args) {
		try {
			System.out.println("Creando socket servidor");
			ServerSocket serverSocket = new ServerSocket();
			
			System.out.println("Realizando el bind");
			InetSocketAddress addr = new InetSocketAddress("192.168.26.158", 5555);
			serverSocket.bind(addr);
			
			System.out.println("Aceptando conexiones");
			Socket newSocket;
			//Para aceptar mas conexiones 
			int i = 0;
			int j = 0;
			while (i < 2){
				newSocket = serverSocket.accept();
				i++;
				System.out.println("Conexión recibida");
				j++;
				System.out.println("");
				System.out.println("Cerrando el nuevo socket");
				j--;
				newSocket.close();
				System.out.println("Cerrando el socket servidor");
				System.out.println("Clientes totales se han conectado: " + i);
			}
			
			serverSocket.close();
			System.out.println("Terminado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
