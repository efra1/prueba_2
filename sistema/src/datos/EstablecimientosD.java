package datos;
import java.util.List;
import java.util.Map;

import modelos.Establecimientos;

import org.springframework.stereotype.Service;

@Service
public class EstablecimientosD extends Conexion {

	
	public List<Map<String,Object>> listar(){
		return db.queryForList("select * from centro_salud where activo");
	}
	public List<Map<String,Object>> listar(Integer comunidad){
		return db.queryForList("select * from centro_salud where comunidad=?",comunidad);
	}

	
	public void adicionar(Establecimientos e){
		db.update("insert into centro_salud(nombre, tipo, comunidad) values (?,?,?)",e.getNombre(),e.getTipo(),e.getComunidad());
	}
	
	public Map<String,Object> obtener(Integer id_cen){
		return db.queryForMap("select e.* from centro_salud e where id_cen=?",id_cen);
	}
	
	public void inhabilitar(Integer id_cen){
	db.update("update centro_salud set activo=false where id_cen=?",id_cen);
	}

	public List<Map<String,Object>> lista(){
		return db.queryForList("select * from centro_salud");
	}
}
