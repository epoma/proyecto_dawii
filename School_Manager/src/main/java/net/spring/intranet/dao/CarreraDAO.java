package net.spring.intranet.dao;

import java.util.List;

import net.spring.intranet.entity.Carrera;

public interface CarreraDAO {
	public void insertar(Carrera bean);
	
	public void actualizar(Carrera bean);
	
	public void eliminar(int cod);
	
	public List<Carrera> listarCarreras();
	
	public Carrera buscar(int cod);
}
