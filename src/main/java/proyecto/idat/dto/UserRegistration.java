package proyecto.idat.dto;


public class UserRegistration {
	
	private String nombre;
	
	private String apellidos;

	private String telefono;
	
	private String num_docu;
	
	private String username;

	private String password;
	public UserRegistration() {}
	public UserRegistration(String nombre, String apellidos, String telefono, String num_docu, String username,
			String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.num_docu = num_docu;
		this.username = username;
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNum_docu() {
		return num_docu;
	}
	public void setNum_docu(String num_docu) {
		this.num_docu = num_docu;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserRegistration [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", num_docu=" + num_docu + ", username=" + username + ", password=" + password + "]";
	}
	

	
}
