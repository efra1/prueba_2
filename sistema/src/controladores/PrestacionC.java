package controladores;

import modelos.Prestacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import datos.PrestacionD;

@Controller
@RequestMapping("prestacion")
public class PrestacionC {
	
	@Autowired
	private PrestacionD PrestacionD;
	
	@RequestMapping("lista_prestacion")
	public String lista(Model m){
		m.addAttribute("lista",PrestacionD.listarP());
		return "prestaciones/tiposDePrestaciones";
	}
	
	@RequestMapping("nuevo")
	public String nuevo(){
		return "prestaciones/nuevaPrestacion";
	}
	
	@RequestMapping("guardar")
	public String guardar(Prestacion p){
		PrestacionD.guardar(p);
		return "redirect:lista_prestacion";
	}
	
	@RequestMapping("editar")
	public String editar(Model m,Integer id){
		m.addAttribute("pres",PrestacionD.obtener(id));
		return "prestaciones/modificarPrestacion";
	}
	
	@RequestMapping("modificar")
	public String modificar(Prestacion p){
		PrestacionD.modificar(p);
		return "redirect:lista_prestacion";
	}
	
	@RequestMapping("inhabilitar")
	public String inhabilitar(Integer id_pre){
		PrestacionD.inhabilitar(id_pre);
		return "redirect:lista_prestacion";
	}
	
}
