package net.spring.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.intranet.dao.SeccionDAO;
import net.spring.intranet.entity.Profesor;
import net.spring.intranet.entity.Seccion;

@Service
public class SeccionServiceImpl implements SeccionService{
	
	@Autowired
	private SeccionDAO seccionDAO;

	@Override
	public void insertar(Seccion bean) {
		seccionDAO.insertar(bean);
		
	}

	@Override
	public void actualizar(Seccion bean) {
		seccionDAO.actualizar(bean);
		
	}


	@Override
	public void eliminar(int cod) {
		seccionDAO.eliminar(cod);
		
	}

	@Override
	public List<Seccion> listarSecciones() {
		return seccionDAO.listarSecciones();
	}

	@Override
	public Seccion buscar(int cod) {
		return seccionDAO.buscar(cod);
	}

	@Override
	public List<Seccion> consultarSeccionXProfesor(int codPro) {
		return seccionDAO.consultarSeccionXProfesor(codPro);
	}

	

}
