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
import net.spring.intranet.entity.Asistencia;
import net.spring.intranet.entity.Seccion;
import net.spring.intranet.service.AlumnoService;
import net.spring.intranet.service.AsistenciaService;
import net.spring.intranet.service.SeccionService;

@Controller
@RequestMapping(value = "/asistencia")
public class AsistenciaController {

	
	@Autowired
	private AsistenciaService asistenciaService; 
	
	
	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private SeccionService seccionService;
	
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		
		model.addAttribute("asistencias", asistenciaService.listarAsistencias());
		model.addAttribute("alumnos", alumnoService.listarAlumnos());
		model.addAttribute("secciones", seccionService.listarSecciones());
		return "asistencia";
	}
	
	
	@RequestMapping(value = "/grabarAsistencia")
	public String grabarAsistencia(@RequestParam("codigo")int cod,
									@RequestParam("alumno")int alu,
									@RequestParam("seccion")int sec,
									@RequestParam("estado")String estado,
									RedirectAttributes redirect) {
		
		try {
			Asistencia bean = new Asistencia();
			bean.setCodigoAsistencia(cod);
			bean.setEstadoRegistro(estado);
			
			Alumno beanAlu = new Alumno();
			beanAlu.setCodigoAlumno(alu);
			bean.setAlumno(beanAlu);
			
			Seccion beanSec = new Seccion();
			beanSec.setCodigoSeccion(sec);
			bean.setSeccion(beanSec);
			
			asistenciaService.actualizar(bean);
			redirect.addFlashAttribute("MENSAJE","Asistencia registrada");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al registro");
			e.printStackTrace();
		}
		
		
		return "redirect:/asistencia/";
		
	}
	
	
	

	
	@RequestMapping(value = "/consulta")
	@ResponseBody
	public List<Asistencia> consulta(@RequestParam("codAlu")int codAlu){
		return asistenciaService.listarAsistenciasxAlumnos(codAlu);
	}
	
	
	
	@RequestMapping("/filtro")
	public String listarAsistenciasxAlumnos(Model model) {
		model.addAttribute("alumnos",alumnoService.listarAlumnos());
		return "consultaAsistencia";
	}
	
	
	
	
	
	
	
	
	
	
	
}
