package datos;
import java.util.List;
import java.util.Map;

import modelos.Tipo;
import modelos.etnia;

import org.springframework.stereotype.Service;
@Service
public class EtniaD extends Conexion{
public List<Map<String,Object>> listarEtnias(){
	return db.queryForList("select *,(select count(*) from persona where etnia=id_etn and activo) as personas from etnia");
}
public void guardar(etnia e){
	db.update("insert into etnia(nombre) values(?)",e.getNombre());
}

public void modificar(etnia e){
	db.update("update etnia set (nombre)=(?) where id_etn=?",e.getNombre(),e.getId_etn());
}

public Map<String,Object> obtener(Integer id_etn){
	return db.queryForMap("select * from etnia where id_etn=?",id_etn);
}

public void inhabilitar(Integer id_etn){
	db.update("update etnia set activo=false where id_etn=?",id_etn);
}
}
