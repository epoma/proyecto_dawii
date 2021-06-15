package net.spring.intranet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name = "tb_rol")
@Data
public class Rol implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_ROL")
	private int codigoRol;
	
	
	@Column(name = "DES_ROL")
	private String descripcionRol;
	
	//realcion de rol a alumno
	@OneToMany(mappedBy = "rol")
	@JsonIgnore
	private List<Alumno> alumno;
	
	
	//relacion de rol a administrador
	@OneToMany(mappedBy = "rol")
	@JsonIgnore
	private List<Administrador> administrador;
	
	//realcion de rol a profesor
	@OneToMany(mappedBy = "rol")
	@JsonIgnore
	private List<Profesor> profesor;
	
	
}
