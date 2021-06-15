package net.spring.intranet.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Entity
@Table(name = "tb_QR")
@Data
public class QR implements Serializable{

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_QR")
	private int codigoQR;
	
	
	@Column(name = "DES_QR")
	private String desQR;
	
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FEC_QR")
	private Date fechaQR;
	
	
	
	
	
	
}
