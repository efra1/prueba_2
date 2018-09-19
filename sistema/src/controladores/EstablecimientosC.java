package controladores;
import modelos.Establecimientos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import datos.EstablecimientosD;
import datos.ComunidadD;

@Controller
@RequestMapping("establecimientos")
public class EstablecimientosC {

	@Autowired
	private EstablecimientosD EstD;
	@Autowired
	private ComunidadD comunidadD;
	
	@RequestMapping("lista")
	public String lista(Model m,Integer comunidad){
		m.addAttribute("lista",EstD.listar(comunidad));
		m.addAttribute("comunidad",comunidadD.obtener(comunidad));
		return "establecimientos_salud/establecimientos";
	}
	
	@RequestMapping("nuevo")
	public String nuevo(Model m,Integer comunidad){
		m.addAttribute("comunidad",comunidad);
		return "establecimientos/nuevoEstablecimiento";
	}
	
	@RequestMapping("guardar")
	public String guardar(Model m,Establecimientos e){
		EstD.adicionar(e);
		return "redirect:lista?comunidad="+e.getComunidad();
	}

}
