package datos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import modelos.Controles;
import modelos.Defuncion;
import modelos.Persona;
import modelos.Comunidad;
import modelos.Establecimientos;
import modelos.RedSalud;
import modelos.Tipo;
import modelos.etnia;
import modelos.Municipio;
import modelos.embarazo;

@Service
public class embarazos extends Conexion{

	
	public List<Map<String,Object>> listarEmb(Integer id_per){
		return db.queryForList("select * from embarazo where embarazada=?",id_per);
	}
	
	public List<Map<String,Object>> obtenerc(){
		return db.queryForList("select p.*,c.nombre,q.nombres as nombresc,q.apellidos as apellidosc from persona p left join persona q on p.contacto=q.id_per left join comunidad c on p.comunidad=c.id_com where p.sexo='F' ");
	}
	
	public Integer guardar(embarazo e){
		db.update("insert into embarazo(parto_prob,embarazada,tipo) values(?,?,'g')",e.getParto_prob(),e.getEmbarazada());
		Integer id_emb= db.queryForObject("select max(id_emb) from embarazo",Integer.class);
		return id_emb;
	}
	public List<Map<String,Object>> obtenerEmb(Integer id_emb){
		return db.queryForList("select * from embarazo where id_emb=?",id_emb);
		
	}
	public Integer defuncion(Defuncion d){
		db.update("insert into defuncion(embarazada,fecha,observacion) values(?,?,?)",d.getEmbarazada(),d.getFecha(),d.getObservacion());
	Integer id_def=db.queryForObject("select max(id_def) from defuncion",Integer.class);
	return id_def;
	}
	
	
}
