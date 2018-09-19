

package datos;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import modelos.Controles;
import modelos.embarazo;


@Service
public class ControlesD extends Conexion{

		public void adicionarControlesPreNatales(Integer id_emb,Date parto_prob){
			DateTime parto=new DateTime(parto_prob);
			DateTime aux=new DateTime(parto_prob);
			DateTime actual=new DateTime();
			
			if(aux.minusDays(245).isAfter(actual))
			db.update("insert into control(fecha,tipo,observaciones,numero,asistido,persona,embarazo) values(?,?,?,?,?,?,?)",
					new Date(parto.minusDays(245).getMillis()),"p","",1,false,null,id_emb);
			
			aux=new DateTime(parto_prob);
			parto=new DateTime(parto_prob);
			if(aux.minusDays(168).isAfter(actual))
			db.update("insert into control(fecha,tipo,observaciones,numero,asistido,persona,embarazo) values(?,?,?,?,?,?,?)",
					new Date(parto.minusDays(168).getMillis()),"p","",2,false,null,id_emb);
			
			aux=new DateTime(parto_prob);
			parto=new DateTime(parto_prob);
			if(aux.minusDays(91).isAfter(actual))
			db.update("insert into control(fecha,tipo,observaciones,numero,asistido,persona,embarazo) values(?,?,?,?,?,?,?)",
					new Date(parto.minusDays(91).getMillis()),"p","",3,false,null,id_emb);
			
			aux=new DateTime(parto_prob);
			parto=new DateTime(parto_prob);
			if(aux.minusDays(28).isAfter(actual))
			db.update("insert into control(fecha,tipo,observaciones,numero,asistido,persona,embarazo) values(?,?,?,?,?,?,?)",
					new Date(parto.minusDays(28).getMillis()),"p","",4,false,null,id_emb);
		}
		
		public List<Map<String,Object>> listarControl(Integer id_emb){
			return db.queryForList("select * from control where embarazo=?",id_emb);
		}
		
		public Map<String,Object> verControl(Integer id_con){
			return db.queryForMap("select * from control where id_con=?",id_con);
		}
		public Map<String,Object> obtenerE(Controles c){
			return db.queryForMap("select * from control where embarazo=?",c.getEmbarazo());
		}
		
		public void modificar(Controles c){
			db.update("update control set (observaciones,asistido)=(?,?) where id_con=?",c.getObservaciones(),c.getAsistido(),c.getId_con());
		}
		
}