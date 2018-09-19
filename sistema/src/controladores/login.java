package controladores;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modelos.Usuario;









import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import datos.Usuarios;
import datos.MujeresD;
import datos.listaBotones;

@Controller
@RequestMapping("principal")
public class login {
	
	@Autowired
	private Usuarios usuariosD;
	@Autowired
	private MujeresD MujeresD;
	@Autowired
	private listaBotones lista;
	
	@RequestMapping("login")
	public String login(){
		return "principal/login";
	}
	
	@RequestMapping("validar")
	public String validar(Usuario u, Model m, HttpServletRequest req){
		Map<String,Object> usuario=usuariosD.login(u);
		if(usuario==null)return "principal/errorLogin";
		m.addAttribute("usuario",usuario);
		
		return "menuprincipal";
	}
	@RequestMapping("botones")
	public String botones(Model m){
		
		List<Map<String, Object>> a=lista.ListaMujeres();
		 
		m.addAttribute("lista1",a);
		m.addAttribute("MEmbarazadas",lista.ListaMujeresRegistradas() );
		m.addAttribute("Riesgo", lista.Riesgo());
		m.addAttribute("Rnacidos", lista.RecienNacido());
		return "Botones/botones";
	}
	
	
	@RequestMapping("menu")
	public String inicio(){
		return "menuprincipal";
	}
	
	
	@RequestMapping("logout")
	public String salir( HttpServletRequest req){
		HttpSession sesion=req.getSession(true);
		sesion.setAttribute("USUARIO", null);
		return "principal/login";
	}

}
