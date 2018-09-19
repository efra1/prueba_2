package modelos;
import java.util.Date;
public class embarazo {

	private Integer id_emb;
	private Date parto_prob;
	private Date parto_inst;
	private Date creado;
	private Date modificado;
	private Boolean activo;
	private String observacion;
	private Integer embarazada;
	private String tipo;
	
	public Integer getId_emb() {
		return id_emb;
	}
	public void setId_emb(Integer id_emb) {
		this.id_emb = id_emb;
	}
	public Date getParto_prob() {
		return parto_prob;
	}
	public void setParto_prob(Date parto_prob) {
		this.parto_prob = parto_prob;
	}
	public Date getParto_inst() {
		return parto_inst;
	}
	public void setParto_inst(Date parto_inst) {
		this.parto_inst = parto_inst;
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
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Integer getEmbarazada() {
		return embarazada;
	}
	public void setEmbarazada(Integer embarazada) {
		this.embarazada = embarazada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
