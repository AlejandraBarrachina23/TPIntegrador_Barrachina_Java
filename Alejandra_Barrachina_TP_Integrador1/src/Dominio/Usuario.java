package Dominio;

public class Usuario {

	@Override
	public String toString() {
		return "Usuario [Usuario=" + Usuario + ", Contrasenia=" + Contrasenia + ", TipoUsuario=" + TipoUsuario
				+ ", Estado=" + Estado + ", IntentosIncio=" + IntentosIncio + ", unProfesor=" + unProfesor + "]";
	}
	private String Usuario;
	private String Contrasenia;
	private String TipoUsuario;
	private boolean Estado;
	private int IntentosIncio;
	private Profesor unProfesor;
	
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getContrasenia() {
		return Contrasenia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Contrasenia == null) ? 0 : Contrasenia.hashCode());
		result = prime * result + (Estado ? 1231 : 1237);
		result = prime * result + IntentosIncio;
		result = prime * result + ((TipoUsuario == null) ? 0 : TipoUsuario.hashCode());
		result = prime * result + ((Usuario == null) ? 0 : Usuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (Contrasenia == null) {
			if (other.Contrasenia != null)
				return false;
		} else if (!Contrasenia.equals(other.Contrasenia))
			return false;
		if (Estado != other.Estado)
			return false;
		if (IntentosIncio != other.IntentosIncio)
			return false;
		if (TipoUsuario == null) {
			if (other.TipoUsuario != null)
				return false;
		} else if (!TipoUsuario.equals(other.TipoUsuario))
			return false;
		if (Usuario == null) {
			if (other.Usuario != null)
				return false;
		} else if (!Usuario.equals(other.Usuario))
			return false;
		return true;
	}
	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}
	public String getTipoUsuario() {
		return TipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}
	public boolean getEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	public int getIntentosIncio() {
		return IntentosIncio;
	}
	public void setIntentosIncio(int intentosIncio) {
		IntentosIncio = intentosIncio;
	}
	
	public Profesor getUnProfesor() {
		return unProfesor;
	}
	public void setUnProfesor(Profesor unProfesor) {
		this.unProfesor = unProfesor;
	}
}
