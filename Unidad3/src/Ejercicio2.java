import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio2 {

    public static void main(String[] args) {
        try {
           
           
           
           
            System.out.println("Creando socket servidor");
            ServerSocket serverSocket = new ServerSocket();
           
            System.out.println("Realizando el bind");
            InetSocketAddress addr = new InetSocketAddress("192.168.26.152",5555) ;
           
            serverSocket.bind(addr);
            System.out.println("Aceptando conexiones");
           
           
            int i=0;
            while(i<5){
                Socket newSocket = serverSocket.accept();
                i++;
                hilo1 hijo1 = new hilo1(newSocket);
                hijo1.start();
            }
           
            serverSocket.close();
            System.out.println("Terminado");
           
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class hilo1 extends Thread{
    private Socket socket;
   
    public hilo1(Socket socket){
        this.socket=socket;
    }
   
    public void run(){
        try {
        System.out.println("Conexión recibida");
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
       
        byte[] mensaje = new byte[100];
        is.read(mensaje);
       
        System.out.println("Mensaje recibido:"+ new String(mensaje));
        System.out.println("Cerrando el nuevo socket");
       
        socket.close();
        System.out.println("Cerrando el socket servidor");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
   
}