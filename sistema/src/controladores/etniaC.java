package controladores;

import modelos.Tipo;
import modelos.etnia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import datos.EtniaD;

@Controller
@RequestMapping("pertenenciaEtnica")
public class etniaC {
	
	
		
		@Autowired
		private EtniaD EtniaD;
		
		@RequestMapping("lista_etnia")
		public String lista(Model m){
			m.addAttribute("lista",EtniaD.listarEtnias());
			return "etnias/pertenenciaEtnica";
		}
		
		@RequestMapping("nuevo")
		public String nuevo(){
			return "etnias/nuevaEtnia";
		}
		
		@RequestMapping("guardar")
		public String guardar(etnia e){
			EtniaD.guardar(e);
			return "redirect:lista_etnia";
		}
		
		@RequestMapping("editar")
		public String editar(Model m,Integer id_etn){
			m.addAttribute("etnia",EtniaD.obtener(id_etn));
			return "etnias/modificarEtnia";
		}
		
		@RequestMapping("modificar")
		public String modificar(etnia e){
			EtniaD.modificar(e);
			return "redirect:lista_etnia";
		}
		
		@RequestMapping("inhabilitar")
		public String inhabilitar(Integer id_etn){
			EtniaD.inhabilitar(id_etn);
			return "redirect:lista_etnia";
		}
	}		

