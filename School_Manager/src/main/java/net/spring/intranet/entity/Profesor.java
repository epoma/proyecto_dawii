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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name = "tb_profesor")
@Data
public class Profesor implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_PRO")
	private int codigoProfesor;
	
	@Column(name = "NOM_PRO")
	private String nombreProfesor;
	
	@Column(name = "APE_PRO")
	private String apellidoProfesor;
	
	@Column(name = "USU_PRO")
	private String usuarioProfesor;
	
	@Column(name = "PASS_PRO")
	private String passProfesor;
	
	@Column(name = "EDAD_PRO")
	private int edadProfesor;
	
	@Column(name = "CEL_PRO")
	private String celularProfesor;
	
	@Column(name = "DIR_PRO")
	private String direccionProfesor;
	
	
	
	@Column(name = "EST_REG")
	private String estadoRegistro;
	
	
	//relacion de profesor a rol
	@ManyToOne
	@JoinColumn(name = "COD_ROL")
	private Rol rol;
	
	
	//relacion de profesor a seccion
	@OneToMany(mappedBy = "profesor")
	@JsonIgnore
	private List<Seccion> seccion;
	
}
