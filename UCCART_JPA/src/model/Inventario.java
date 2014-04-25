package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the Arancel database table.
 * 
 */

@Entity
@Table(name="inventario")
public class Inventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="inventario_id")
	private String inventarioId ;

	@Column(name="inventario_nombre")
	private String inventarioNombre;

	@Column(name="inventario_marca")
	private String inventarioMarca;
	
	@Column(name="inventario_modelo")
	private String inventarioModelo;
	
	@Column(name="inventario_valor")
	private float inventarioValor;
	
	@Column(name="inventario_cantidad")
	private Integer inventarioCantidad;
	
	@Column(name="inventario_proveedor")
	private String inventarioProveedor;
	
	
	



	public Inventario() {
	}

	public String getInventariolId() {
		return this.inventarioId;
	}

	public void setInventarioId(String inventarioId) {
		this.inventarioId = inventarioId;
	}
	
	public String getInventarioNombre() {
		return this.inventarioNombre;
	}
	
	public void setInventarioNombre( String inventarioNombre) {
		this.inventarioNombre = inventarioNombre;
	}

	public void setInventarioMarca( String inventarioMarca) {
		this.inventarioMarca = inventarioMarca;
	}

	public String getInventarioMarca() {
		return this.inventarioMarca;
	}
	
	public void setInventarioModelo( String inventarioModelo) {
		this.inventarioModelo = inventarioModelo;
	}

	public String getinventarioModelo() {
		return this.inventarioModelo;
	}
	
	public void setInventarioValor( float inventarioValor) {
		this.inventarioValor = inventarioValor;
	}

	public float getInventarioValor() {
		return this.inventarioValor;
	}
	
	public void setInventarioCantidad( Integer inventarioCantidad) {
		this.inventarioCantidad = inventarioCantidad;
	}

	public Integer getInventarioCantidad() {
		return this.inventarioCantidad;
	}
	
	public void setInventarioProveedor( String inventarioProveedor) {
		this.inventarioProveedor = inventarioProveedor;
	}

	public String getInventarioProveedor() {
		return this.inventarioProveedor;
	}
	
	
	
	


}