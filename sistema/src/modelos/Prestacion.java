package modelos;
import java.util.Date;
public class Prestacion {
	private Integer id_pre;
	private String nombre;
	private String descrip;
	private String creado;
	private String modificado;
	private String activo;
	
	
	public Integer getId_pre() {
		return id_pre;
	}
	public void setId_pre(Integer id_pre) {
		this.id_pre = id_pre;
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
	public String getCreado() {
		return creado;
	}
	public void setCreado(String creado) {
		this.creado = creado;
	}
	public String getModificado() {
		return modificado;
	}
	public void setModificado(String modificado) {
		this.modificado = modificado;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	
	
}
