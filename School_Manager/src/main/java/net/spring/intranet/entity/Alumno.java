package net.spring.intranet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;


@Entity
@Table(name = "tb_alumno")
@Data
public class Alumno implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_ALU")
	private int codigoAlumno;
	
	@Column(name = "NOM_ALU")
	private String nombreAlumno;
	
	@Column(name = "APE_ALU")
	private String apellidoAlumno;
	
	@Column(name = "USU_ALU")
	private String usuarioAlumno;
	
	@Column(name = "PASS_ALU")
	private String passAlumno;
	
	@Column(name = "EDAD_ALU")
	private int edadAlumno;
	
	@Column(name = "CEL_ALU")
	private String celularAlumno;
	
	@Column(name = "DIR_ALU")
	private String direccionAlumno;
	
	
	
	@Column(name = "EST_REG")
	private String estadoRegistro;
	
	
	//realacion de alumno a carrera
	@ManyToOne
	@JoinColumn(name = "COD_CAR")
	private Carrera carrera;
	
	
	
	//relacion de alumno a rol
	@ManyToOne
	@JoinColumn(name = "COD_ROL")
	private Rol rol;
	
	
	//relacion de de alumno a asistencia
	@OneToMany(mappedBy = "alumno")
	@JsonIgnore
	private List<Asistencia> asistencia;
	
	
	//relacion de alumno a geolocalizacion
	@OneToMany(mappedBy = "alumno")
	@JsonIgnore
	private List<Geolocalizacion> geolocalizacion;
	
	
	
	//relacion de alumno a det_Sec_alu
	@OneToMany(mappedBy = "alumno")
	@JsonIgnore
	private List<Det_Sec_Alu> detSecAlu;
		
		

	
	
}
