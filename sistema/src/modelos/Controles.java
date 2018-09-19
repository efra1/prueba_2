package modelos;
import java.util.Date;
public class Controles {

	private Integer id_con;
	private Date fecha;
	private String tipo;
	private String observaciones;
	private Integer numero;
	private Boolean asistido;
	private Integer persona;
	private Integer embarazo;
	private Integer recien_nacido;
	public Integer getId_con() {
		return id_con;
	}
	public void setId_con(Integer id_con) {
		this.id_con = id_con;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Boolean getAsistido() {
		return asistido;
	}
	public void setAsistido(Boolean asistido) {
		this.asistido = asistido;
	}
	public Integer getPersona() {
		return persona;
	}
	public void setPersona(Integer persona) {
		this.persona = persona;
	}
	public Integer getEmbarazo() {
		return embarazo;
	}
	public void setEmbarazo(Integer embarazo) {
		this.embarazo = embarazo;
	}
	public Integer getRecien_nacido() {
		return recien_nacido;
	}
	public void setRecien_nacido(Integer recien_nacido) {
		this.recien_nacido = recien_nacido;
	}
	
	
	
}
