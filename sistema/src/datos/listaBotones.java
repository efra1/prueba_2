package datos;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class listaBotones extends Conexion {
	public List<Map<String,Object>> ListaMujeres(){
		return db.queryForList("select length(max(id_per)::text) from persona where sexo='F'");
	}
	public List<Map<String,Object>> ListaMujeresRegistradas(){
		return db.queryForList("select count(distinct embarazada) from persona,embarazo");
	}
	public List<Map<String,Object>> Riesgo(){
		return db.queryForList("select distinct count(id_emb) from embarazo where tipo='r'");
	}
	public List<Map<String,Object>> RecienNacido(){
		return db.queryForList("select distinct count(id_rcn) from recien_nacido");
	}
	
	
	
}
