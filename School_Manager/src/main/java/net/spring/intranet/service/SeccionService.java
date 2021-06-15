package net.spring.intranet.service;

import java.util.List;

import net.spring.intranet.entity.Profesor;
import net.spring.intranet.entity.Seccion;

public interface SeccionService {
	
	public void insertar(Seccion bean);
	
	public void actualizar(Seccion bean);
	
	public void eliminar(int cod);
	
	public List<Seccion> listarSecciones();
	
	public Seccion buscar(int cod);
	
	public List<Seccion> consultarSeccionXProfesor(int codPro);

}
