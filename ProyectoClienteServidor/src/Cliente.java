import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.Socket;
import java.net.SocketException;

public class Cliente {
	public static void main(String[] args) throws SocketException {

		try {
			System.out.println("Creando socket cliente. ");
			
			Socket clientSocket = new Socket();
			
			System.out.println("Estableciendo conexion");
			InetSocketAddress address =  new InetSocketAddress("192.168.26.36", 5555);
			
			clientSocket.connect(address);
			
			// Mandamos mensaje al servidor
			ClienteEnvio enviar = new ClienteEnvio(clientSocket);
			ClienteRecibo recibo = new ClienteRecibir(clientSocket);
			
			enviar.start();
			recibo.start();
			
			System.out.println("Enviando un mensaje");
			
			Mensaje mensaje = new Mensaje(1, "Cliente 1", " PHILIPEE");
			
			outputStream.writeObject(mensaje);
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}

	}
	
	public void ClienteEnvio extends Thread(){
		
	}
}
