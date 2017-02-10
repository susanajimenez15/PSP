import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Ejercicio5cliente {
	public static void main(String[] args) {
		System.out.println("Creando socket cliente");
		Socket cliente = new Socket();
		System.out.println("Estableciendo conexión");
		InetSocketAddress address = new InetSocketAddress("192.168.26.189", 5555);
		try{
			cliente.connect(address);
			
			InputStream inputStream = cliente.getInputStream();
			byte[] mensaje = new byte[5000];
			inputStream.read(mensaje);
			System.out.println(new String(mensaje));
			
			Thread.sleep(3000);
			
			OutputStream outputStream = cliente.getOutputStream();
			String terminado = "terminado";
			
			outputStream.write(terminado.getBytes());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
