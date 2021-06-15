package net.spring.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.intranet.dao.RolDAO;
import net.spring.intranet.entity.Rol;

@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
	private RolDAO rolDAO;

	@Override
	public List<Rol> listarRol() {
		
		return rolDAO.listarRol();
	}

}
