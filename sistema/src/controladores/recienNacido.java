package controladores;

import java.util.Date;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




import datos.ControlesD;
import datos.embarazos;
import datos.PersonaD;
import datos.ComunidadD;
import datos.EstablecimientosD;
import datos.EtniaD;
import modelos.Controles;
@Controller
@RequestMapping("registro")
public class recienNacido {

	
	@RequestMapping("recienNacido")
	public String rnacido(){
		return "recienNacido/registrarParto";
	}
}
