package controladores;
import modelos.Prestacion;
import modelos.RedSalud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import datos.PrestacionD;
import datos.RedSaludD;

@Controller
@RequestMapping("red_salud")
public class RedSaludC {
	@Autowired
	private RedSaludD redSaludD;
	
	@RequestMapping("lista")
	public String lista(Model m){
		m.addAttribute("lista",redSaludD.listar());
		return "red_salud/redDeSalud";
	}
	
	@RequestMapping("nuevo")
	public String nuevo(){
		return "red_salud/nuevaRedSalud";
	}
	
	@RequestMapping("guardar")
	public String guardar(RedSalud r){
		redSaludD.guardar(r);
		return "redirect:lista";
		
	}
	
	@RequestMapping("editar")
	public String editar(Model m,Integer id_red){
		m.addAttribute("red",redSaludD.obtener(id_red));
		return "red_salud/modificarRedSalud";
	}
	
	@RequestMapping("modificar")
	public String modificar(RedSalud r){
		redSaludD.modificar(r);
		return "redirect:../municipio/lista?id_red="+r.getId_red();
	}
	
	@RequestMapping("inhabilitar")
	public String inhabilitar(Integer id_red){
		redSaludD.inhabilitar(id_red);
		return "redirect:../municipio/lista?id_red="+id_red;
	}
}
