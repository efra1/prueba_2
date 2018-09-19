package controladores;

import modelos.Tipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import datos.TipoD;

@Controller
@RequestMapping("tipo")
public class TipoC {
	
	@Autowired
	private TipoD tipoD;
	
	@RequestMapping("lista")
	public String lista(Model m){
		m.addAttribute("lista",tipoD.listar());
		return "tipo/tiposDePersona";
	}
	
	@RequestMapping("nuevo")
	public String nuevo(){
		return "tipo/nuevoTipo";
	}
	
	@RequestMapping("guardar")
	public String guardar(Tipo t){
		tipoD.guardar(t);
		return "redirect:lista";
	}
	
	@RequestMapping("editar")
	public String editar(Model m,Integer id){
		m.addAttribute("tipo",tipoD.obtener(id));
		return "tipo/modificarTipo";
	}
	
	@RequestMapping("modificar")
	public String modificar(Tipo t){
		tipoD.modificar(t);
		return "redirect:lista";
	}
	
	@RequestMapping("inhabilitar")
	public String inhabilitar(Integer id){
		tipoD.inhabilitar(id);
		return "redirect:lista";
	}
	
}
