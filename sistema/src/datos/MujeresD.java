package datos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import modelos.Persona;
import modelos.Comunidad;
import modelos.Establecimientos;
import modelos.RedSalud;
import modelos.etnia;
import modelos.Municipio;

@Service
public class MujeresD extends Conexion {
	public List<Map<String,Object>> listarMujeres(){
		return db.queryForList("select p.*,c.nombre,q.nombres as nombresc,q.apellidos as apellidosc,q.sexo as sexoc from persona p left join persona q on p.contacto=q.id_per left join comunidad c on p.comunidad=c.id_com where p.sexo='F' ");
	}
	
	
}
