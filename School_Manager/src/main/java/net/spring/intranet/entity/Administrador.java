package net.spring.intranet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name = "tb_administrador")
@Data
public class Administrador implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_ADMIN")
	private int codigoAdministrador;
	
	@Column(name = "NOM_ADMIN")
	private String nombreAdministrador;
	
	@Column(name = "APE_ADMIN")
	private String apellidoAdministrador;
	
	@Column(name = "USU_ADMIN")
	private char usuAdministrador;
	
	@Column(name = "PASS_ADMIN")
	private char passAdministrador;
	

	@Column(name = "EST_REG")
	private String estadoRegistro;
	
	
	
	//relacion de administrador con rol
	@ManyToOne
	@JoinColumn(name = "COD_ROL")
	private Rol rol;
	
	
	
	
	
	
}



