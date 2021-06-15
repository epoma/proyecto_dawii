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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "tb_det_sec_alu")
@Data
public class Det_Sec_Alu implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_SEC_ALU")
	private int codSecAlu;
	
	
	@Column(name = "NOTA_1")
	private int nota1;
	
	@Column(name = "NOTA_2")
	private int nota2;
	
	
	
	
	//relacion de det_sec_alu a seccion
	@ManyToOne
	@JoinColumn(name = "COD_SEC")
	private Seccion seccion;
	
	
	
	

	//relacion de det_sec_alu a alumno
	@ManyToOne
	@JoinColumn(name = "COD_ALU")
	private Alumno alumno;
	
	
	
}
