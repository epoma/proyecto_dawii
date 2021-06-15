package net.spring.intranet.dao;

import net.spring.intranet.entity.QR;

public interface QRDAO {
//	se invoca este metodo cuando el alumno enfoca con la cámara de su celular el QR
	public int validar(QR bean);
	
//	solo existira un registro de una cadena QR en la BD, cod debe valer 1
	public QR buscar(int cod);
}
