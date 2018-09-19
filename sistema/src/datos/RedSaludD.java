package datos;
import java.util.List;
import java.util.Map;

import modelos.Prestacion;
import modelos.RedSalud;
import org.springframework.stereotype.Service;

@Service
public class RedSaludD extends Conexion{
	public List<Map<String,Object>> listar(){
		return db.queryForList("select r.*,(select count(*) from municipio where red_salud=r.id_red) as municipios from red_salud r");
	}
	
	public void guardar(RedSalud r){
		
		db.update("insert into red_salud(nombre) values(?)",r.getNombre());
		
	}
	
	public void modificar(RedSalud r){
		db.update("update red_salud set (nombre,modificado)=(?,now()) where id_red=?",r.getNombre(),r.getId_red());
	}
	
	public Map<String,Object> obtener(Integer id_red){
		return db.queryForMap("select * from red_salud where id_red=?",id_red);
	}
	
	public void inhabilitar(Integer id_red){
		db.update("update red_salud set activo=false where id_red=?",id_red);
	}
}
