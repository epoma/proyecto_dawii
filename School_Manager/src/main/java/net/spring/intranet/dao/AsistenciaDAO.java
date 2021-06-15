package net.spring.intranet.dao;

import java.util.List;

import net.spring.intranet.entity.Asistencia;

public interface AsistenciaDAO {
	public void actualizar(Asistencia bean);
	public List<Asistencia> listarAsistencias();
	
	public List<Asistencia> listarAsistenciasxAlumnos(int codAlu);
}
