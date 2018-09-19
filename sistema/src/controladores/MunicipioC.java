package controladores;

import modelos.Municipio;
import modelos.Prestacion;
import modelos.RedSalud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import datos.MunicipioD;
import datos.PrestacionD;
import datos.RedSaludD;

@Controller
@RequestMapping("municipio")
public class MunicipioC {
	@Autowired
	private MunicipioD municipioD;
	@Autowired
	private RedSaludD redSaludD;
	
	@RequestMapping("lista")
	public String lista(Model m,Integer id_red){
		m.addAttribute("lista",municipioD.listar(id_red));
		m.addAttribute("red",redSaludD.obtener(id_red));
		return "municipio/municipio";
	}
	
	@RequestMapping("nuevo")
	public String nuevo(Model m,Integer id_red){
		m.addAttribute("id_red",id_red);
		m.addAttribute("departamentos",municipioD.listarDepartamentos());
		return "municipio/nuevoMunicipio";
	}
	
	@RequestMapping("guardar")
	public String guardar(Municipio m){
		municipioD.guardar(m);
		return "redirect:lista?id_red="+m.getRed_salud();
	}
	
	@RequestMapping("editar")
	public String editar(Model m,Integer id_mun){
		m.addAttribute("municipio",municipioD.obtener(id_mun));
		return "red_salud/modificarRedSalud";
	}
	
	@RequestMapping("inhabilitar")
	public String inhabilitar(Model m,Integer id_mun){
		municipioD.inhabilitar(id_mun);
		return "redirect:../comunidad/lista?municipio="+id_mun;
	}
	
	
}
