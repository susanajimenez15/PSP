import java.net.InetSocketAddress;
import java.net.Socket;

public class ComprobarPuertos {
	public static void main (String[] args){
		Socket socket;
		
		//Para recorrer todos los puertos
		for (int i = 0; i < Math.pow(2, 16); i++){
			try{
				socket = new Socket("82.98.160.74", i);
				socket.close();
				System.out.println("Conectado con el puerto " + i);
			} catch (Exception e) {
				//Si ponemos mensaje es muy rayado
			}
		}
		System.out.println("FIN");
	}
}
