package net.spring.intranet.service;

import java.util.List;

import net.spring.intranet.entity.Carrera;

public interface CarreraService {
	
	public void insertar(Carrera bean);
	
	public void actualizar(Carrera bean);
	
	public void eliminar(int cod);
	
	public List<Carrera> listarCarreras();
	
	public Carrera buscar(int cod);

}
