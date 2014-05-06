package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the Arancel database table.
 * 
 */

@Entity
@Table(name="aranceles")
public class Arancel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="aranceles_id")
	private String arancelId ;

	@Column(name="aranceles_descripcion")
	private String arancelDescripcion;

	@Column(name="aranceles_precio")
	private float arancelPrecio ;
	
	@Column(name="aranceles_tipo")
	private String arancelTipo ;

	@OneToOne(mappedBy="arancel")
	private DetalleFacturaEntrada DetalleFacturaEntrada;
	
	

	public Arancel() {
	}

	public String getArancelId() {
		return this.arancelId;
	}

	public void setArancelId(String arancelId) {
		this.arancelId = arancelId;
	}

	public float getArancelPrecio() {
		return this.arancelPrecio;
	}

	public void setArancelPrecio(float arancelPrecio) {
		this.arancelPrecio = arancelPrecio;
	}

	public String getArancelDescripcion() {
		return this.arancelDescripcion;
	}

	public void setArancelDescripcion(String arancelDescripcion) {
		this.arancelDescripcion = arancelDescripcion;
	}
	
	public String getArancelTipo() {
		return this.arancelTipo;
	}

	public void setArancelTipo(String arancelTipo) {
		this.arancelTipo = arancelTipo;
	}

	


}