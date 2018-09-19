package controladores;

import java.util.Date;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;






import datos.ControlesD;
import datos.embarazos;
import datos.PersonaD;
import datos.ComunidadD;
import datos.EstablecimientosD;
import datos.EtniaD;
import modelos.Controles;
import modelos.embarazo;

@Controller
@RequestMapping("controles")
public class ControlesC {
	
	@Autowired
	private PersonaD personaD;
	@Autowired
	private EtniaD etniaD;
	@Autowired
	private ComunidadD comunidadD;
	@Autowired
	private EstablecimientosD establecimientoD;
	@Autowired
	private embarazos embarazoD;
	@Autowired
	private ControlesD controlesD;
	
	@RequestMapping("lista")
	public String lista(Model e,Integer id_per,Integer embarazada, Integer embarazo){
		e.addAttribute("lista",controlesD.listarControl(embarazo));
		e.addAttribute("listaEmb", embarazoD.listarEmb(id_per));
		e.addAttribute("embarazo",embarazoD.obtenerEmb(embarazo));
		e.addAttribute("embarazada",personaD.obtener(embarazada));
		return "controles/listaControles";
	}
	
	
	
	
	@RequestMapping("estadoControl")
	public String observaciones(Model e,Integer id_con,Controles embarazo,Integer embarazada){
		e.addAttribute("control",controlesD.verControl(id_con));
		
		e.addAttribute("embarazada",embarazada);
		return "controles/estadoControl";
	}
	
	@RequestMapping("guardar")
	public String guardar(Model m, Controles c,embarazo e, Integer embarazada){
		controlesD.modificar(c);
		
		return "redirect:../embarazos/listaEmb?id_per="+e.getEmbarazada();
	}

	@RequestMapping("recienNacido")
	public String rnacido(Model m, Integer id_emb, Integer id_per){
		m.addAttribute("embarazo", embarazoD.obtenerEmb(id_emb));
		m.addAttribute("embarazada", personaD.obtener(id_per));
		return "registroParto/registrarParto";
	}

	
	
	
	
	@RequestMapping("interrupcion")
	public String interrupcion(){
		return "controles/interrupcion";
	}

	
}