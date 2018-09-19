package datos;

import java.util.List;
import java.util.Map;

import modelos.Tipo;

import org.springframework.stereotype.Service;

@Service
public class TipoD extends Conexion{
	public List<Map<String,Object>> listar(){
		return db.queryForList("select t.*,(select count(*) from persona_tipo where tipo=t.id_tip) as personas from tipo t");
	}
	
	public void guardar(Tipo t){
		db.update("insert into tipo(nombre,descrip) values(?,?)",t.getNombre(),t.getDescrip());
	}
	
	public void modificar(Tipo t){
		db.update("update tipo set (nombre,descrip,modificado)=(?,?,now()) where id_tip=?",t.getNombre(),t.getDescrip(),t.getId_tip());
	}
	
	public Map<String,Object> obtener(Integer id_tip){
		return db.queryForMap("select * from tipo where id_tip=?",id_tip);
	}
	
	public void inhabilitar(Integer id_tip){
		db.update("update tipo set activo=false where id_tip=?",id_tip);
	}
}
