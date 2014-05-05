package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the facturas_entrada database table.
 * 
 */
@Entity
@Table(name="facturas_entrada")
public class FacturaEntrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="facturas_entrada_id")
	private String facturas_entrada_id;

	@Column(name="facturas_entrada_id_empleado")
	private String facturas_entrada_id_empleado;

	@Column(name="facturas_entrada_id_estudiante")
	private String facturas_entrada_id_estudiante;

	@Column(name="facturas_entrada_nombre")
	private String facturas_entrada_nombre;

	@Column(name="facturas_entrada_direccion")
	private String facturas_entrada_direccion;

	@Column(name="facturas_entrada_telefono")
	private String facturas_entrada_telefono;

	@Column(name="facturas_entrada_metodo_de_pago")
	private String facturas_entrada_metodo_de_pago;

	@Column(name="facturas_entrada_total")
	private Float facturas_entrada_total;

/*

	//bi-directional one-to-one association to Estudiante
	@OneToOne
	@JoinColumn(name="facturas_entrada_id_estudiante", referencedColumnName="personas_id", insertable = true, updatable = false)
	private Estudiante estudiante;
	
	@OneToOne
	@JoinColumn(name="facturas_entrada_id_empleado", referencedColumnName="personas_id", insertable = true, updatable = false)
	private Empleado empleado;
	*/
	
	
	public FacturaEntrada() {
	}

	public String getFacturas_entrada_id() {
		return this.facturas_entrada_id;
	}

	public void setFacturas_entrada_id(String facturas_entrada_id) {
		this.facturas_entrada_id = facturas_entrada_id;
	}
	
	public String getFacturas_entrada_id_empleado() {
		return this.facturas_entrada_id_empleado;
	}

	public void setFacturas_entrada_id_empleado(String facturas_entrada_id_empleado) {
		this.facturas_entrada_id_empleado = facturas_entrada_id_empleado;
	}
	
	public String getFacturas_entrada_id_estudiante() {
		return this.facturas_entrada_id_estudiante;
	}

	public void setFacturas_entrada_id_estudiante(String facturas_entrada_id_estudiante) {
		this.facturas_entrada_id_estudiante = facturas_entrada_id_estudiante;
	}
	
	public String getFacturas_entrada_nombre() {
		return this.facturas_entrada_nombre;
	}

	public void setFacturas_entrada_nombre(String facturas_entrada_nombre) {
		this.facturas_entrada_nombre = facturas_entrada_nombre;
	}
	
	public String getFacturas_entrada_direccion() {
		return this.facturas_entrada_direccion;
	}

	public void setFacturas_entrada_direccion(String facturas_entrada_nombre) {
		this.facturas_entrada_nombre = facturas_entrada_nombre;
	}
	
	public String getFacturas_entrada_telefono() {
		return this.facturas_entrada_telefono;
	}

	public void setFacturas_entrada_telefono(String facturas_entrada_telefono) {
		this.facturas_entrada_telefono = facturas_entrada_telefono;
	}
	
	public String getFacturas_entrada_metodo_de_pago() {
		return this.facturas_entrada_metodo_de_pago;
	}

	public void setFacturas_entrada_metodo_de_pago(String facturas_entrada_metodo_de_pago) {
		this.facturas_entrada_metodo_de_pago = facturas_entrada_metodo_de_pago;
	}
	
	public Float getFacturas_entrada_total() {
		return this.facturas_entrada_total;
	}

	public void setfacturas_entrada_total(Float facturas_entrada_total) {
		this.facturas_entrada_total = facturas_entrada_total;
	}
/*	
	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}*/
	

}