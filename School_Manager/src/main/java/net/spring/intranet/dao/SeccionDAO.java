package net.spring.intranet.dao;

import java.util.List;

import net.spring.intranet.entity.Seccion;

public interface SeccionDAO {
	public void insertar(Seccion bean);
	
	public void actualizar(Seccion bean);
	
	public void eliminar(int cod);
	
	public List<Seccion> listarSecciones();
	
	public Seccion buscar(int cod);
	
	public List<Seccion> consultarSeccionXProfesor(int codPro);
	
}
