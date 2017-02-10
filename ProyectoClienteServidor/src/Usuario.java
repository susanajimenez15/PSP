
public class Usuario {

	private String usuario;
	private int puerto;
	
	public Usuario(String usuario, int puerto){
		
		this.usuario = usuario;
		this.puerto = puerto;
	}
	
	public String getUsuario(){
		return usuario;
	}
	
	public int getPuerto(){
		return puerto;
	}
}
