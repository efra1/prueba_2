package datos;

import java.util.List;
import java.util.Map;

import modelos.Persona;
import modelos.Tipo;
import modelos.Usuario;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;
@Service
public class Usuarios extends Conexion{
	public Map<String,Object> login(Usuario u){
		try {
			return db.queryForMap("select * from usuario u join persona p on u.persona=p.id_per where login=? and password=? and p.activo and u.activo",u.getLogin(),u.getPassword());
		} catch (Exception e) {e.printStackTrace();
			return null;
		}
	
	}
	
	public List<Map<String,Object>> listar(){
		return db.queryForList("select *,r.nombre as rol,u.activo as activou from usuario u join persona p on u.persona=p.id_per join rol r on r.id_rol=u.rol");
	}
	
	public void guardar(Usuario u){
		db.update("insert into usuario(persona,alcance,login,password,centro_salud,rol) values(?,?,?,?,?,?)",
				u.getPersona(),u.getAlcance(),u.getLogin(),u.getPassword(),u.getCentro_salud(),u.getRol());
	}
	
	public void modificar(Usuario u){
		db.update("update usuario set (login,password,rol,alcance)=(?,?,?,?) where persona=?",u.getLogin(),u.getPassword(),u.getRol(),u.getAlcance(),u.getPersona());
	}

	public Map<String,Object> obtener(Integer persona){
		return db.queryForMap("select * from  usuario where persona=?",persona);
	}
	public void inhabilitar(Integer persona){
		db.update("update usuario set activo=false where persona=?",persona);
	}
	
	public List<Map<String, Object>> listarRoles(){
		return db.queryForList("select * from rol");
	}


}
