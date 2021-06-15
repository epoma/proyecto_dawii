package net.spring.intranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.spring.intranet.entity.Profesor;
import net.spring.intranet.entity.Rol;
import net.spring.intranet.service.ProfesorService;
import net.spring.intranet.service.RolService;

@Controller
@RequestMapping(value = "/profesor")
public class ProfesorController {

	@Autowired
	private RolService rolService;
	
	@Autowired
	private ProfesorService profesorService;
	

	
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("roles",rolService.listarRol());
		model.addAttribute("profesores", profesorService.listarProfesores());
		model.addAttribute("profesor", new Profesor());
		return "vProfesor";
	}
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo")int cod,RedirectAttributes redirect) {
		try {
			profesorService.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE", "Docente Eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error al Eliminar a un Docente");
			e.printStackTrace();
		}
		return "redirect:/profesor/";
	}
	
	@RequestMapping(value = "/guardarProfesor")
	public String guardarDocente(
									@RequestParam("codigo") int _codigo,
									@RequestParam("nombres") String _nombres,
									@RequestParam("apellidos") String _apellidos,
									@RequestParam("usuario") String _usuario,
									@RequestParam("password") String _password,
									@RequestParam("edad") int _edad,
									@RequestParam("celular") String _celular,
									@RequestParam("direccion") String _direccion,
									@RequestParam("codigorol") int _codigorol,
									@RequestParam("estado") String _estado,
									RedirectAttributes redirect
			
			) {
				try {
					Profesor profesor = new Profesor();
					profesor.setCodigoProfesor(_codigo);
					profesor.setNombreProfesor(_nombres);
					profesor.setApellidoProfesor(_apellidos);
					profesor.setUsuarioProfesor(_usuario);
					profesor.setPassProfesor(_password);
					profesor.setEdadProfesor(_edad);
					profesor.setCelularProfesor(_celular);
					profesor.setDireccionProfesor(_direccion);
					Rol rol = new Rol();
					rol.setCodigoRol(_codigorol);
					profesor.setRol(rol);
					profesor.setEstadoRegistro(_estado);
					if(_codigo == 0) {
						profesorService.insertar(profesor);
						redirect.addFlashAttribute("MENSAJE", "Enhorabuena! Has registrado a un Profesor.");
					
					}else {
						profesorService.actualizar(profesor);
						redirect.addFlashAttribute("MENSAJE","Profesor actualizado");
					}
				} catch (Exception e) {
					redirect.addFlashAttribute("MENSAJE", "Oh, Al parecer hubo un error al registrar a un Profesor");
					e.printStackTrace();
				}
		return "redirect:/profesor/";
	}
	
	@RequestMapping(value = "/buscarProfesor")
	@ResponseBody
	public Profesor buscarProfesor(@RequestParam("code") int codigopro) {
		Profesor profesor = profesorService.buscar(codigopro);
		return profesor;
	}
	

	
}
