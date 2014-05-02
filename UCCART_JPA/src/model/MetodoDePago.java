package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the metodos_de_pago database table.
 * 
 */
@Entity
public class MetodoDePago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mdp_id")
	private String id;

	@Column(name="mdp_metodo")
	private String metodo;

	@Column(name="mdp_descripcion")
	private String descripcion;

	public MetodoDePago() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMetodo() {
		return this.metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}