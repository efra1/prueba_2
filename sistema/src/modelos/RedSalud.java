package modelos;

import java.util.Date;


public class RedSalud {
	private Integer id_red;
	private String nombre;
	private Date creado;
	private Date modificado;
	private Boolean activo;
	
	public Integer getId_red() {
		return id_red;
	}
	public void setId_red(Integer id_red) {
		this.id_red = id_red;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getCreado() {
		return creado;
	}
	public void setCreado(Date creado) {
		this.creado = creado;
	}
	public Date getModificado() {
		return modificado;
	}
	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
