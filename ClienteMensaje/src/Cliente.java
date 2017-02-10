import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		try {
			
			int opcion;
			String telf;
			Scanner scan = new Scanner(System.in);
			System.out.println("Creamos socket datagrama");
			
			DatagramSocket datagramSocket = new DatagramSocket();
			
			System.out.println("Enviando petición");
			
			do{
				do{
					
					System.out.println("---- MENU ----");
					System.out.println("Elige una de las siguientes acciones");
					System.out.println("1. Ver lista de teléfonos.");
					System.out.println("2. Introducir teléfono.");
					System.out.println("--------------");
					opcion = scan.nextInt();
					
				}while(opcion < 1 || opcion > 2);
				
	
				InetAddress serverAddr = InetAddress.getByName("192.168.26.30");
				DatagramPacket datagrama;
				
				
				
				switch (opcion) {
				case 1:
					System.out.println("Listado de teléfonos");
					String mensaje = new String("v");
					datagrama = new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length, serverAddr, 5555);
					datagramSocket.send(datagrama);
					datagramSocket.close();
					
					System.out.println("Enviando petición.");
					System.out.println("Recibiendo respuesta.");
					byte[] respuesta = new byte[9];
					DatagramPacket datagramaResp = new DatagramPacket(respuesta, respuesta.length);
					datagramSocket.receive(datagramaResp);
					
					System.out.println("Mensaje recibido: "+new String(respuesta));
					datagramSocket.close();
					
					break;
				case 2:
					System.out.println("Introduce tu nombre seguido de tu numero de teléfono");
					mensaje = scan.nextLine();
					datagrama = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, serverAddr, 5555);
					datagramSocket.send(datagrama);
					break;
	
				case 0:
					System.out.println("Saliendo");
					
				default:
					break;
				}
		}while(opcion != 0);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
