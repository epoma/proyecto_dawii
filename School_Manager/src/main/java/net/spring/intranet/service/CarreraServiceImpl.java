package net.spring.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.intranet.dao.CarreraDAO;
import net.spring.intranet.entity.Carrera;

@Service
public class CarreraServiceImpl implements CarreraService{

	@Autowired
	private CarreraDAO carreraDAO;
	
	@Override
	public void insertar(Carrera bean) {
		carreraDAO.insertar(bean);
		
	}

	@Override
	public void actualizar(Carrera bean) {
		carreraDAO.actualizar(bean);
		
	}

	@Override
	public void eliminar(int cod) {
		carreraDAO.eliminar(cod);
		
	}

	@Override
	public List<Carrera> listarCarreras() {
		
		return carreraDAO.listarCarreras();
	}

	@Override
	public Carrera buscar(int cod) {
		
		return carreraDAO.buscar(cod);
	}
	

}
