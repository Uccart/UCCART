package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="us_id")
	private String usId;

	@Column(name="us_nombre")
	private String usNombre;

	@Column(name="us_pw")
	private String usPw;

	@Column(name="us_tipo")
	private Integer usTipo;

	public Usuario() {
	}

	public String getUsId() {
		return this.usId;
	}

	public void setUsId(String usId) {
		this.usId = usId;
	}

	public String getUsNombre() {
		return this.usNombre;
	}

	public void setUsNombre(String usNombre) {
		this.usNombre = usNombre;
	}

	public String getUsPw() {
		return this.usPw;
	}

	public void setUsPw(String usPw) {
		this.usPw = usPw;
	}

	public Integer getUsTipo() {
		return this.usTipo;
	}

	public void setUsTipo(Integer usTipo) {
		this.usTipo = usTipo;
	}

}