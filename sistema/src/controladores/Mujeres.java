package controladores;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelos.Defuncion;
import modelos.Persona;
import modelos.RedSalud;
import modelos.Usuario;
import modelos.embarazo;
import datos.ControlesD;
import datos.MujeresD;
import datos.MunicipioD;
import datos.EtniaD;
import datos.ComunidadD;
import datos.EstablecimientosD;
import datos.RedSaludD;
import datos.PersonaD;
import datos.embarazos;
@Controller
@RequestMapping("mujeres")
public class Mujeres {

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
	private embarazos Embarazos;
	@Autowired
	private ControlesD control;
	
	@RequestMapping("listaM")
	public String mujeres(Model m, Integer id_per){
		m.addAttribute("lista", MujeresD.listarMujeres());
		m.addAttribute("listaEmb", Embarazos.listarEmb(id_per));
		
		return "mujeres/listaMujeres";
	}
	
	@RequestMapping("nueva")
	public String nuevaEmb(Model m, Integer red_salud, Integer comunidadd){
		m.addAttribute("listae", etnia.listarEtnias());
		m.addAttribute("listar",red.listar());
		m.addAttribute("listam", MunicipioD.lista());
		m.addAttribute("listac", comunidad.lista());
		m.addAttribute("listaest", est.lista());
		return "mujeres/nuevaEmbarazada";
	}
	
	@RequestMapping("guardar")
	public String guardar(Model m, embarazo e,Persona per, String f_nacimiento1, String telefonoc, String nombrec, String apellidoc, String sexoContacto, String relacionCon, String parto_probable1 ){

try{
			SimpleDateFormat dato=new SimpleDateFormat("dd/MM/yyyy");
			
			Persona cont=new Persona();
			cont.setTelf(telefonoc);
			cont.setNombres(nombrec);
			cont.setApellidos(apellidoc);
			cont.setSexo(sexoContacto);
			cont.setRelacion(relacionCon);
			int idcontacto=PersonaD.guardar(cont);
			
			per.setContacto(idcontacto);
			per.setSexo("F");
			per.setF_nac(dato.parse(f_nacimiento1));
			
			int emb=PersonaD.guardar(per);
			embarazo e1=new embarazo();
			e1.setParto_prob(dato.parse(parto_probable1));
			e1.setEmbarazada(emb);
		
			int id_em=Embarazos.guardar(e1);
			System.out.println(id_em);
			
			control.adicionarControlesPreNatales(id_em,dato.parse(parto_probable1));
			System.out.println("exito");
		} catch (ParseException e1)	{
			System.out.println("error al ingresar datos");
			e1.printStackTrace();
		}
		
		return "redirect:listaM";
	}
	
	@RequestMapping("modificar")
	public String modificar(Model m, embarazo e,Integer id_per,Integer id_emb,String parto_probable1){
		m.addAttribute("per", PersonaD.obtener(id_per));
		m.addAttribute("listae", etnia.listarEtnias());
		m.addAttribute("listar",red.listar());
		m.addAttribute("listam", MunicipioD.lista());
		m.addAttribute("listac", comunidad.lista());
		m.addAttribute("listaest", est.lista());
		
		return "mujeres/modificarEmbarazada";
	}
	@RequestMapping("actualizar")
	public String modificar(Persona p){
		
		PersonaD.modificar(p);
		System.out.println("se modifico");
		
		return "redirect:listaM";
	}
	
	@RequestMapping("defuncion")
	public String def(Model m, Integer id_per){
		m.addAttribute("embarazada", PersonaD.obtener(id_per));
		return "mujeres/defuncion";
	}
	
	@RequestMapping("actualizarDef")
	public String actualizar(embarazo e,Persona p,Integer id_per ,Defuncion d,Model m,String fechaDef) {
		
		SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy" );
		Date f;
		
		try {
			f = formato.parse(fechaDef);
			d.setFecha(f);
			Embarazos.defuncion(d);
			
			PersonaD.quitarControl(e);
			PersonaD.quitarEmbarazo(id_per);			
			PersonaD.defuncionPersona(p);
			System.out.println("se inhabilito a la mujer");
			
			
			
		
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return "redirect:listaM";
		
}
	
}
