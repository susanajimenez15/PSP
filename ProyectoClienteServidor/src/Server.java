import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
	public static void main(String[] args) {
		System.out.print("Arrancando servidor");
		try {
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.26.114", 5555);
			serverSocket.bind(inetSocketAddress);
			
			int cont = 0;
			while (cont<5){
				Socket aceptar = serverSocket.accept();
				
				cont++;
			}
			System.out.println("Cliente conectado");
		} catch (Exception e) {
			System.out.println("Imposible conectar con el cliente");
		}
	}
}
