package modelos;

import java.util.Date;

public class Municipio {
	private Integer id_mun;
	private String nombre;
	private Boolean activo;
	private Date creado;
	private Date modificado;
	private Integer red_salud;
	private Integer departamento;
	
	public Integer getId_mun() {
		return id_mun;
	}
	public void setId_mun(Integer id_mun) {
		this.id_mun = id_mun;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
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
	public Integer getRed_salud() {
		return red_salud;
	}
	public void setRed_salud(Integer red_salud) {
		this.red_salud = red_salud;
	}
	public Integer getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}
}
