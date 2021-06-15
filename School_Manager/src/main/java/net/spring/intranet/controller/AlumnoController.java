package net.spring.intranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.spring.intranet.entity.Alumno;
import net.spring.intranet.entity.Carrera;
import net.spring.intranet.entity.Rol;
import net.spring.intranet.service.AlumnoService;
import net.spring.intranet.service.CarreraService;
import net.spring.intranet.service.RolService;

import java.util.List;

@Controller
@RequestMapping(value = "/alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired 
	private CarreraService carreraService;
	
	@Autowired
	private RolService rolService;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("alumnos", alumnoService.listarAlumnos());
		model.addAttribute("carreras", carreraService.listarCarreras());
		model.addAttribute("roles", rolService.listarRol());
		model.addAttribute("alumno", new Alumno());
		return "vAlumno";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo")int cod,RedirectAttributes redirect) {
		try {
			alumnoService.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE", "Alumno Eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Alumno Eliminado");
			e.printStackTrace();
		}
		return "redirect:/alumno/";
	}
	
	@RequestMapping(value = "/guardarAlumno")
	public String grabarAlumno(@RequestParam("codigo")int cod,
								@RequestParam("nombre")String nom,
								@RequestParam("apellido")String ape,
								@RequestParam("usuario")String usu,
								@RequestParam("password")String pass,
								@RequestParam("edad")int edad,
								@RequestParam("celular")String cel,
								@RequestParam("direccion")String dire,
								@RequestParam("estado")String estado,
								@RequestParam("carrera")int codcarre,
								@RequestParam("rol")int codrol,RedirectAttributes redirect) {
		try {
			Alumno beanAlu =  new Alumno();
			beanAlu.setCodigoAlumno(cod);
			beanAlu.setNombreAlumno(nom);
			beanAlu.setApellidoAlumno(ape);
			beanAlu.setUsuarioAlumno(usu);
			beanAlu.setPassAlumno(pass);
			beanAlu.setEdadAlumno(edad);
			beanAlu.setCelularAlumno(cel);
			beanAlu.setDireccionAlumno(dire);
			beanAlu.setEstadoRegistro(estado);
			Carrera carr = new Carrera();
			carr.setCodigoCarrera(codcarre);
			beanAlu.setCarrera(carr);
			Rol rol = new Rol();
			rol.setCodigoRol(codrol);
			beanAlu.setRol(rol);
			if(cod==0) {
				alumnoService.insertar(beanAlu);
				//crear atributo
				redirect.addFlashAttribute("MENSAJE","Alumno registrado");
			}
			else {
				alumnoService.actualizar(beanAlu);
				redirect.addFlashAttribute("MENSAJE","Alumno actualizado");
			}
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al guardar Alumno");
			e.printStackTrace();
		}
		return "redirect:/alumno/";
	}
	
	@RequestMapping(value = "/buscarAlumno")
	@ResponseBody
	public Alumno buscarAlumno(@RequestParam("cod") int cod) {
		Alumno bean=alumnoService.buscar(cod);
		return bean;
	} 
	
	@RequestMapping(value = "/consulta")
	@ResponseBody
	public List<Alumno> consulta(@RequestParam("codCarre")int codCarre){
		return alumnoService.consultarAlumnosXCarrera(codCarre);
	}
	
	@RequestMapping("/filtro")
	public String listaAlumnoXCarrera(Model model) {
		model.addAttribute("carreras",carreraService.listarCarreras());
		return "vConsultaAlumnoXCarrera";
	}
	

}
