package net.spring.intranet.service;

import java.util.List;

import net.spring.intranet.entity.Asistencia;

public interface AsistenciaService {

	public void actualizar(Asistencia bean);
	public List<Asistencia> listarAsistencias();
	
	public List<Asistencia> listarAsistenciasxAlumnos(int codAlu);
}
