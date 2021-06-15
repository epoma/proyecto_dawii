package net.spring.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.intranet.dao.ProfesorDAO;
import net.spring.intranet.entity.Profesor;

@Service
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
	private ProfesorDAO profesorDAO;

	@Override
	public Profesor iniciarSesion(String user, String pass, int codRol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Profesor bean) {
		profesorDAO.insertar(bean);
		
	}

	@Override
	public void actualizar(Profesor bean) {
		profesorDAO.actualizar(bean);
		
	}

	@Override
	public void eliminar(int cod) {
		profesorDAO.eliminar(cod);
		
	}

	@Override
	public List<Profesor> listarProfesores() {
		return profesorDAO.listarProfesores();
	}

	@Override
	public Profesor buscar(int cod) {
		return profesorDAO.buscar(cod);
	}

}
