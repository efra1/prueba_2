package modelos;
import java.util.Date;

public class Defuncion {
private Integer id_def;
private Integer embarazada;
private Date fecha;
private String observacion;


public Integer getId_def() {
	return id_def;
}
public void setId_def(Integer id_def) {
	this.id_def = id_def;
}
public Integer getEmbarazada() {
	return embarazada;
}
public void setEmbarazada(Integer embarazada) {
	this.embarazada = embarazada;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getObservacion() {
	return observacion;
}
public void setObservacion(String observacion) {
	this.observacion = observacion;
}


}
