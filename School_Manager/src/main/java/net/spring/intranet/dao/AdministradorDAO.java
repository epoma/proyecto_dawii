package net.spring.intranet.dao;

import net.spring.intranet.entity.Administrador;

public interface AdministradorDAO {
	public Administrador iniciarSesion(String user, String pass, int codRol);
}
