import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.imageio.event.IIOReadProgressListener;

//Ejercicio cuatro echo por Adrián con Andrea y Jhony
public class Ejercicio4Cliente {
	 public static void main(String[] args) throws InterruptedException{
		 try{
			 Socket cliente;
		 	//Bucle para que no salte la expepción cuando el servidor esta apagado
			 do{
				 cliente = new Socket();
				 try{
					 //Establecer la conexión 
					 InetSocketAddress address = new InetSocketAddress("192.168.26.247", 5555);
					 cliente.connect(address);
				 } catch (Exception e) {
					System.out.println("Imposible establecer la conexión");
					Thread.sleep(3000);
				}
			 }while(!cliente.isConnected());
			 System.out.println("Conexión establecida");
			 
			 InputStream inputStream = cliente.getInputStream();
			 OutputStream outputStream = cliente.getOutputStream();
			 byte[] mensaje = new byte[5000];
			 System.out.println("Mensaje recibido");
			 String linea;
			 InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			 BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			 do{
				 
				 linea = new String(mensaje);
				 System.out.println(linea);
			 }while(linea.compareTo("null-finish") != 0);
			 
			 System.out.println("Cerrando el socket cliente");
			 cliente.close();
			 System.out.println("Terminado");
			 
		 } catch(IOException e){
			 System.out.println(e);
		 }
	 }
}
