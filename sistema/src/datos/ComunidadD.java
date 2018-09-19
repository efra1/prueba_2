package datos;

import java.util.List;
import java.util.Map;

import modelos.Comunidad;

import org.springframework.stereotype.Service;

@Service
public class ComunidadD extends Conexion {
	
	public List<Map<String,Object>> listar(Integer municipio){
		return db.queryForList("select c.*,(select count(*) from centro_salud where comunidad=c.id_com) as centros from comunidad c where c.municipio=?",municipio);
	}
	
	public void adicionar(Comunidad c){
		db.update("insert into comunidad(nombre,municipio,telf) values(?,?,?)",c.getNombre(),c.getMunicipio(),c.getTelf());
	}
	
	public void moificar(Comunidad c){
		db.update("update comunidad set (nombre,telf)=(?,?) where id_com=?",c.getNombre(),c.getTelf(),c.getId_com());
	}
	
	public Map<String,Object> obtener(Integer id_com){
		return db.queryForMap("select c.* from comunidad c where id_com=?",id_com);
	}
	
	public void inhabilitar(Integer id_com){
	db.update("update comunidad set activo=false where id_com=?",id_com);
	}
	public List<Map<String,Object>> lista(){
		return db.queryForList("select * from comunidad");
	}

}