package datos;

import modelos.Comunidad;
import modelos.embarazo;
import modelos.recienNacido;

public class registroD extends Conexion {
	
	public void fechaParto(embarazo e){
		db.update("update embarazo set(parto_inst)=(?) where id_emb=?",e.getParto_inst(),e.getId_emb());
	}
	
	public void recienNacido(recienNacido r){
		db.update("insert into recien_nacido(sexo,peso,nombres,apellidos,embarazo) values(?,?,?,?,?)",r.getSexo(),r.getPeso(),r.getNombres(),r.getApellidos(),r.getEmbarazo());
	}
	
	
}
