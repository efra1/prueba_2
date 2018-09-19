package modelos;

public class Usuario {

	
		private Integer persona;
		private Integer rol;
		private String alcance;
		private String login;
		private String password;
		private Boolean activo;
		private Integer centro_salud;
		
		public Integer getPersona() {
			return persona;
		}
		public void setPersona(Integer persona) {
			this.persona = persona;
		}
		public Integer getRol() {
			return rol;
		}
		public void setRol(Integer rol) {
			this.rol = rol;
		}
		public String getAlcance() {
			return alcance;
		}
		public void setAlcance(String alcance) {
			this.alcance = alcance;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Boolean getActivo() {
			return activo;
		}
		public void setActivo(Boolean activo) {
			this.activo = activo;
		}
		public Integer getCentro_salud() {
			return centro_salud;
		}
		public void setCentro_salud(Integer centro_salud) {
			this.centro_salud = centro_salud;
		}
		
	

}
