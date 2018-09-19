package controladores;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelos.Defuncion;
import modelos.Persona;
import modelos.RedSalud;
import modelos.etnia;
import modelos.embarazo;
import datos.MujeresD;
import datos.MunicipioD;
import datos.EtniaD;
import datos.ComunidadD;
import datos.EstablecimientosD;
import datos.RedSaludD;
import datos.PersonaD;
import datos.embarazos;
import datos.ControlesD;
@Controller
@RequestMapping("embarazos")
public class embarazosC {
	@Autowired
	private RedSaludD red;
	@Autowired
	private MujeresD MujeresD;
	@Autowired
	private MunicipioD MunicipioD;
	@Autowired
	private EtniaD etnia;
	@Autowired
	private ComunidadD comunidad;
	@Autowired
	private EstablecimientosD est;
	@Autowired
	private PersonaD PersonaD;
	@Autowired
	private embarazos emb;
	@Autowired
	private ControlesD control;
	
	@RequestMapping("listaEmb")
	public String emb(Model m, Integer id_per){
		
		m.addAttribute("listaEmb", emb.listarEmb(id_per));
		m.addAttribute("per", PersonaD.obtener(id_per));
		Map<String,Object> a = PersonaD.obtenerEdad(id_per);
		Double c = (Double) a.get("edad");
		m.addAttribute("edad",(int)c.doubleValue());
		m.addAttribute("contacto", MujeresD.listarMujeres());
		return "embarazo/embarazos";
		
	}
	
	@RequestMapping("nuevoEmbarazo")
	public String nuevo(Model m, Integer id_per){
		
		m.addAttribute("embarazada",id_per);
		
		return "embarazo/nuevoEmbarazo" ;
	}
	
	@RequestMapping("guardar")
	public String guardar(embarazo e,Model m,String parto_prob2) {
		
		SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy" );
		Date f;
		
		try {
			f = formato.parse(parto_prob2);
			e.setParto_prob( f );
			int id_em=emb.guardar(e);
			control.adicionarControlesPreNatales(id_em,formato.parse(parto_prob2));
			
		
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		return "redirect:listaEmb?id_per="+e.getEmbarazada();
		
	}
	
	
}
