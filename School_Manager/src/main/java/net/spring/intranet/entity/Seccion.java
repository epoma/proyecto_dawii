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
@Table(name = "tb_seccion")
@Data
public class Seccion implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_SEC")
	private int codigoSeccion;
	
	@Column(name = "DES_SEC")
	private String descripcionSeccion;
	
	@Column(name = "DES_CURS")
	private String descripcionCurso;
	

	@Column(name = "LFAL_SEC")
	private int lfalSeccion;
	
	@Column(name = "LCLA_SEC")
	private int lclaSeccion;
	
	@Column(name = "EST_REG")
	private String estadoRegistro;
	
	//relacion de seccion a profesor
	@ManyToOne
	@JoinColumn(name = "COD_PRO")
	private Profesor profesor;
	
	
	//relacion de seccion a horario
	@ManyToOne
	@JoinColumn(name = "COD_HOR")
	private Horario horario;
	
	
	
	//relacion de seccion a asistencia
	@OneToMany(mappedBy = "seccion")
	@JsonIgnore
	private List<Asistencia> asistencias ;
	
	
	
	//relacion de seccion a det_Sec_alu
	@OneToMany(mappedBy = "seccion")
	@JsonIgnore
	private List<Det_Sec_Alu> detSecAlus ;
		
		
		
	
}
