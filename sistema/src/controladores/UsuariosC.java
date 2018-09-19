package controladores;

import modelos.Persona;
import modelos.Tipo;
import modelos.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import datos.PersonaD;
import datos.Usuarios;


@Controller
@RequestMapping("usuario")
public class UsuariosC {
	
	@Autowired
	private Usuarios usuarioD;
	@Autowired
	private PersonaD personaD;
	
	@RequestMapping("lista")
	public String lista(Model m){
		m.addAttribute("lista",usuarioD.listar());
		return "usuarios/usuario";
	}
	@RequestMapping("nuevo")
	public String nuevo(Model m){
		m.addAttribute("roles",usuarioD.listarRoles());
		return "usuarios/adicionarUsuarios";
	}
	
	@RequestMapping("guardar")
	public String guardar(Model m,Persona p,Usuario u){
		
		Integer id_per=personaD.guardar(p);
		
		u.setPersona(id_per);
		usuarioD.guardar(u);
		
		return "redirect:lista";
	}
	
	@RequestMapping("editar")
	public String editar(Model m,Integer persona){
		m.addAttribute("roles",usuarioD.listarRoles());
		m.addAttribute("usuario",usuarioD.obtener(persona));
		return "usuarios/modificarUsuario";
	}

	@RequestMapping("modificar")
	public String modificar(Usuario u){
		usuarioD.modificar(u);
		return "redirect:lista";
	}
	
	@RequestMapping("inhabilitar")
	public String inhabilitar(Integer persona){
		usuarioD.inhabilitar(persona);
		return "redirect:lista";
	}
}
