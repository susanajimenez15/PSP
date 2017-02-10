public class Mensaje {
	
	private Integer codigo;
	private String usuario;
	private String mensaje;
	
	public Mensaje(Integer codigo, String usuario, String mensaje){
		this.codigo = codigo;
		this.usuario = usuario;
		this.mensaje = mensaje; 
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
