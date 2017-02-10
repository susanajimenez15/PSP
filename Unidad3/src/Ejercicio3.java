import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio3 {
//SERVIDOR
    public static void main(String[] args) {
        try {
      
            System.out.println("Creando socket servidor");
            ServerSocket serverSocket = new ServerSocket();
           
            System.out.println("Realizando el bind");
            InetSocketAddress addr = new InetSocketAddress("localhost",5555) ;
           
            serverSocket.bind(addr);
            System.out.println("Aceptando conexiones");
           
            boolean isClosed = true;

            
            while(isClosed){
                Socket newSocket = serverSocket.accept();
                
                Hilo12 hijo1 = new Hilo12(newSocket, isClosed);
                hijo1.start();
            }
           
            serverSocket.close();
            System.out.println("Cerrando el socket servidor");
            System.out.println("Terminado");
           
            } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}

class Hilo12 extends Thread{
    private Socket socket;
    private boolean isClosed;
   
    public Hilo12(Socket socket, boolean isClosed){
        this.socket=socket;
        this.isClosed = isClosed;
    }
   
    public void run(){
        try {
        System.out.println("Conexión recibida");
        InputStream is = socket.getInputStream();
        
        byte[] mensaje = new byte[100];
        is.read(mensaje);
        
        if (mensaje.toString().compareTo("close") == 0){
        	socket.close();
        	isClosed = false;
        	return;
        }
       
        System.out.println("Mensaje recibido:"+ new String(mensaje));
        System.out.println("Cerrando el nuevo socket");
       
        socket.close();
       
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
   
}

