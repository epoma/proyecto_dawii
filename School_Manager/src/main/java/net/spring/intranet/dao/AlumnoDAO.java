package net.spring.intranet.dao;

import java.util.List;

import net.spring.intranet.entity.Alumno;

public interface AlumnoDAO {
	
	public Alumno iniciarSesion(String user, String pass, int codRol);
	
	public void insertar(Alumno bean);
	
	public void actualizar(Alumno bean);
	
	public void eliminar(int cod);
	
	public List<Alumno> listarAlumnos();
	
	public Alumno buscar(int cod);
	
	public List<Alumno> consultarAlumnosXCarrera(int codCarrera);

}
