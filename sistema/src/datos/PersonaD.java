package datos;

import java.util.Map;
import java.util.Date;
import modelos.Persona;
import modelos.embarazo;

import org.springframework.stereotype.Service;


@Service
public class PersonaD extends Conexion{
	public Integer guardar(Persona p){
		db.update("insert into persona(nombres,apellidos,telf,sexo,f_nac,idioma,etnia,comunidad,contacto,centro_salud,ci,relacion) values(?,?,?,?,?,?,?,?,?,?,?,?)",
				p.getNombres(),p.getApellidos(),p.getTelf(),p.getSexo(),p.getF_nac(),p.getIdioma(),p.getEtnia(),p.getComunidad(),p.getContacto(),p.getCentro_salud(),p.getCi(),p.getRelacion());
		return db.queryForObject("select max(id_per) from persona",Integer.class);
	}
	
	public Map<String,Object> obtener(Integer id_per){
		return db.queryForMap("select p.*,e.tipo,c.nombre as comunidad,m.nombre as municipio from persona p left join comunidad c on p.comunidad=c.id_com left join municipio m on c.municipio=m.id_mun left join embarazo e on e.embarazada=p.id_per and id_emb=(select max(id_emb)"
				+ " from embarazo where embarazada=?) where id_per=?",id_per,id_per);
	}
	
	public Map<String,Object> obtenerEdad(Integer id_per){
	return db.queryForMap("select date_part('year',age(f_nac)) as EDAD from persona where id_per=?",id_per);
	}
	
	public void modificar(Persona p){
		db.update("update persona set (nombres,apellidos,telf,sexo,f_nac,idioma,etnia,comunidad,centro_salud,ci)=(?,?,?,?,?,?,?,?,?,?) where id_per=?",p.getNombres(),p.getApellidos(),p.getTelf(),p.getSexo(),p.getF_nac(),p.getIdioma(),p.getEtnia(),p.getComunidad(),p.getCentro_salud(),p.getCi(),p.getId_per());
	}

	public void defuncionPersona(Persona p){
		db.update("update persona set (activo)=('false') where id_per=?",p.getId_per());
	}
	
	public void quitarControl(embarazo e){
		db.update("delete from control where embarazo=?",e.getId_emb());
	}
	
	public void quitarEmbarazo(Integer id_per){
		db.update("delete from embarazo where embarazada=?",id_per);
	}
	
	

}


