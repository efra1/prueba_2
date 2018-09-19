package datos;
import java.util.List;
import java.util.Map;

import modelos.Municipio;
import modelos.RedSalud;

import org.springframework.stereotype.Service;

@Service
public class MunicipioD extends Conexion {
	public List<Map<String,Object>> listar(Integer red_salud){
		return db.queryForList("select m.*,d.nombre as departamento,(select count(*) from comunidad where municipio=m.id_mun) as comunidades from municipio m join departamento d on m.departamento=d.id_dep where red_salud=?",red_salud);
	}
	
	public void guardar(Municipio m){
		db.update("insert into municipio(nombre,red_salud,departamento) values(?,?,?)",m.getNombre(),m.getRed_salud(),m.getDepartamento());
	}
	
	public void modificar(Municipio m){
		db.update("update municipio set (nombre,red_salud,departamento,modificado)=(?,?,?,now()) where id_mun=?",m.getNombre(),m.getRed_salud(),m.getDepartamento(),m.getId_mun());
	}
	
	public Map<String,Object> obtener(Integer id_mun){
		return db.queryForMap("select * from municipio where id_mun=?",id_mun);
	}
	
	public void inhabilitar(Integer id_mun){
		db.update("update municipio set activo=false where id_mun=?",id_mun);
	}
	
	public List<Map<String,Object>> listarDepartamentos(){
		return db.queryForList("select * from departamento");
	}
	public List<Map<String,Object>> lista(){
		return db.queryForList("select * from municipio");
	}
}