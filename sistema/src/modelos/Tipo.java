package modelos;

import java.util.Date;

public class Tipo {
	private Integer id_tip;
	private String nombre;
	private String descrip;
	private Boolean activo;
	private Date creado;
	private Date modificado;
	
	public Integer getId_tip() {
		return id_tip;
	}
	public void setId_tip(Integer id_tip) {
		this.id_tip = id_tip;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
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
	
	
}
