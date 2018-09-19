package datos;

import java.util.List;
import java.util.Map;

import modelos.Prestacion;
import org.springframework.stereotype.Service;

@Service
public class PrestacionD extends Conexion{
	public List<Map<String,Object>> listarP(){
		return db.queryForList("select p. *,(select count(*) from centros_salud_prestaciones where prestacion=p.id_pre) as centros from prestaciones p");
	}
	
	public void guardar(Prestacion p){
		db.update("insert into prestaciones(nombre,descrip) values(?,?)",p.getNombre(),p.getDescrip());
	}
	
	public void modificar(Prestacion p){
		db.update("update prestaciones set (nombre,descrip,modificado)=(?,?,now()) where id_pre=?",p.getNombre(),p.getDescrip(),p.getId_pre());
	}
	
	public Map<String,Object> obtener(Integer id_pre){
		return db.queryForMap("select * from prestaciones where id_pre=?",id_pre);
	}
	
	public void inhabilitar(Integer id_pre){
		db.update("update prestaciones set activo=false where id_pre=?",id_pre);
	}
}
