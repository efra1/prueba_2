package modelos;
import java.util.Date;
public class Establecimientos {
private Integer id_cen;
private String nombre;
private Boolean activo;
private Date creado;
private Date modificado;
private Integer encargado;
private String tipo;
private String comunidad;

public Integer getId_cen() {
	return id_cen;
}
public void setId_cen(Integer id_cen) {
	this.id_cen = id_cen;
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
public Integer getEncargado() {
	return encargado;
}
public void setEncargado(Integer encargado) {
	this.encargado = encargado;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getComunidad() {
	return comunidad;
}
public void setComunidad(String comunidad) {
	this.comunidad = comunidad;
}
 

 
}
