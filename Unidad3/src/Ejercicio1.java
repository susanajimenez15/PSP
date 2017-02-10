import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.IOException;

import java.io.OutputStream;

//Cliente
public class Ejercicio1 {

		public static void main(String[]args) {
			try {
				System.out.println("Creando socket cliente");
				Socket clientSocket = new Socket();
				
				System.out.println("Estableciendo la conexión");
				
				//Para que llegue bien, cambiamos localhost por la IP en String
				InetSocketAddress addr = new InetSocketAddress("192.168.26.152", 5555);
				
				clientSocket.connect(addr);
				
				OutputStream os = clientSocket.getOutputStream();
				
				System.out.println("Enviando mensaje");
				String mensaje = "Hola puta";
				os.write(mensaje.getBytes());
				System.out.println("Mensaje enviado");
				System.out.println("Cerrando el socket cliente");
				clientSocket.close();
				System.out.println("Terminado");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}


