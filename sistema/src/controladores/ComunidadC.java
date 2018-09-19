package controladores;

import modelos.Municipio;
import modelos.Comunidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import datos.MunicipioD;
import datos.ComunidadD;

@Controller
@RequestMapping("comunidad")
public class ComunidadC {
	
	@Autowired
	private ComunidadD comunD;
	@Autowired
	private MunicipioD municipioD;
	
	@RequestMapping("lista")
	public String lista(Model m,Integer municipio){
		m.addAttribute("lista",comunD.listar(municipio));
		m.addAttribute("comunidad",municipioD.obtener(municipio));
		return "comunidad/comunidades";
	}
	
	@RequestMapping("nuevo")
	public String nuevo(Model m,Integer municipio){
		m.addAttribute("municipio",municipio);
		return "comunidad/nuevaComunidad";
	}
	
	@RequestMapping("guardar")
	public String guardar(Model m,Comunidad c){
		comunD.adicionar(c);
		return "redirect:lista?municipio="+c.getMunicipio();
	}

	@RequestMapping("editar")
	public String editar(Model m,Integer id_mun){
		m.addAttribute("comunidad",comunD.obtener(id_mun));
		return "municipio/modificarMunicipio";
	}
}
