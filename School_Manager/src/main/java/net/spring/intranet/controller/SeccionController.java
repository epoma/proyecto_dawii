package net.spring.intranet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.spring.intranet.entity.Alumno;
import net.spring.intranet.entity.Horario;
import net.spring.intranet.entity.Profesor;
import net.spring.intranet.entity.Seccion;
import net.spring.intranet.service.HorarioService;
import net.spring.intranet.service.ProfesorService;
import net.spring.intranet.service.SeccionService;

@Controller
@RequestMapping(value = "/seccion")
public class SeccionController {
	
	@Autowired
	private SeccionService seccionService;
	
	@Autowired
	private HorarioService horarioService;
	
	@Autowired
	private ProfesorService profesorService;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("secciones", seccionService.listarSecciones());
		model.addAttribute("horarios", horarioService.listarHorario());
		model.addAttribute("profesores", profesorService.listarProfesores());
		model.addAttribute("seccion", new Seccion());
		return "vSeccion";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo")int cod,RedirectAttributes redirect) {
		try {
			seccionService.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE", "Seccion Eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Seccion Eliminado");
			e.printStackTrace();
		}
		return "redirect:/seccion/";
	}
	
	@RequestMapping("/guardarSeccion")
	public String guardar(@RequestParam("codigo") int cod,
						  @RequestParam("seccion")  String sec,
						  @RequestParam("curso")  String cur,
						  @RequestParam("profesor")  int pro,
						  @RequestParam("horario")  int hor,
						  @RequestParam("lfalta")  int lfal,
						  @RequestParam("lclases")  int lcla,
						  @RequestParam("estado")  String est,RedirectAttributes redirect) {
		
		
		try {
			Seccion beanSecc = new Seccion();
			
			beanSecc.setCodigoSeccion(cod);
			beanSecc.setDescripcionSeccion(sec);
			beanSecc.setDescripcionCurso(cur);

			Profesor profe = new Profesor();
			profe.setCodigoProfesor(pro);
			beanSecc.setProfesor(profe);
			Horario hora = new Horario();
			hora.setCodigoHorario(hor);
			beanSecc.setHorario(hora);
			beanSecc.setLfalSeccion(lfal);
			beanSecc.setLclaSeccion(lcla);
			beanSecc.setEstadoRegistro(est);
			if(cod==0) {
				seccionService.insertar(beanSecc);
				//crear atributo
				redirect.addFlashAttribute("MENSAJE","Seccion registrado");
			}
			else {
				seccionService.actualizar(beanSecc);
				redirect.addFlashAttribute("MENSAJE","Seccion actualizado");
			}
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al guardar Seccion");
			e.printStackTrace();
		}
		return "redirect:/seccion/";
	}
	
	@RequestMapping(value = "/buscarSeccion")
	@ResponseBody
	public Seccion buscarSeccion(@RequestParam("cod") int cod) {
		Seccion bean=seccionService.buscar(cod);
		return bean;
	} 
	
	@RequestMapping(value = "/consulta")
	@ResponseBody
	public List<Seccion> consulta(@RequestParam("codPro")int codProfe){
		return seccionService.consultarSeccionXProfesor(codProfe);
	}
	
	@RequestMapping("/filtro")
	public String listaAlumnoXCarrera(Model model) {
		model.addAttribute("profesores",profesorService.listarProfesores());
		return "vConsultaSeccionXProfesor";
	}

}
