package net.spring.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.intranet.dao.HorarioDAO;
import net.spring.intranet.entity.Horario;

@Service
public class HorarioServiceImpl implements HorarioService{
	
	@Autowired
	private HorarioDAO horarioDAO;

	@Override
	public List<Horario> listarHorario() {
		return horarioDAO.listarHorario();
	}

}
