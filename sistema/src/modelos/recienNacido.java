package modelos;
import java.util.Date;
public class recienNacido {

	private Integer id_rcn;
	private String nombres;
	private String apellidos;
	private String sexo;
	private String peso;
	private Date defuncion;
	private Integer embarazo;
	public Integer getId_rcn() {
		return id_rcn;
	}
	public void setId_rcn(Integer id_rcn) {
		this.id_rcn = id_rcn;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public Date getDefuncion() {
		return defuncion;
	}
	public void setDefuncion(Date defuncion) {
		this.defuncion = defuncion;
	}
	public Integer getEmbarazo() {
		return embarazo;
	}
	public void setEmbarazo(Integer embarazo) {
		this.embarazo = embarazo;
	}
	
	
}
