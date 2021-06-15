package net.spring.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.intranet.dao.AlumnoDAO;
import net.spring.intranet.entity.Alumno;
@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoDAO alumnoDAO;
	
	@Override
	public Alumno iniciarSesion(String user, String pass, int codRol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Alumno bean) {
		alumnoDAO.insertar(bean);
		
	}

	@Override
	public void actualizar(Alumno bean) {
		alumnoDAO.actualizar(bean);
		
	}

	@Override
	public void eliminar(int cod) {
		alumnoDAO.eliminar(cod);
		
	}

	@Override
	public List<Alumno> listarAlumnos() {
		return alumnoDAO.listarAlumnos();
	}

	@Override
	public Alumno buscar(int cod) {
		return alumnoDAO.buscar(cod);
	}

	@Override
	public List<Alumno> consultarAlumnosXCarrera(int codCarrera) {
		return alumnoDAO.consultarAlumnosXCarrera(codCarrera);
	}
	
	

}
