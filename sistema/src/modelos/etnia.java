package modelos;
import java.util.Date;
public class etnia {

	private String nombre;
	private Boolean activo;
	private Date creado;
	private Date modificado;
	private Integer id_etn;
	
	
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
	public Integer getId_etn() {
		return id_etn;
	}
	public void setId_etn(Integer id_etnia) {
		this.id_etn = id_etn;
	}
	
}
