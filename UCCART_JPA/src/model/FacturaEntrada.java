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



	//bi-directional one-to-one association to Estudiante
	@OneToOne
	@JoinColumn(name="facturas_entrada_id_estudiante", referencedColumnName="personas_id", insertable = false, updatable = false)
	private Estudiante estudiante;
	
	@OneToOne
	@JoinColumn(name="facturas_entrada_id_empleado", referencedColumnName="personas_id", insertable = false, updatable = false)
	private Empleado empleados;

	@OneToOne(mappedBy="facturaEntrada", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	private DetalleFacturaEntrada detalleFacturaEntrada;
	
	@OneToOne(mappedBy="facturaEntrada", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	private ReciboEntrada reciboEntrada;
	
	@OneToOne(mappedBy="facturaEntrada", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	private CuentasPorCobrar cuentasPorCobrar;
	
	
	
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

	public void setFacturas_entrada_direccion(String facturas_entrada_direccion) {
		this.facturas_entrada_direccion = facturas_entrada_direccion;
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
	
	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Empleado getEmpleado() {
		return this.empleados;
	}

	public void setEmpleado(Empleado empleados) {
		this.empleados = empleados;
	}
	
	public DetalleFacturaEntrada getDetalleFacturaEntrada() {
		return this.detalleFacturaEntrada;
	}

	public void setDetalleFacturaEntrada(DetalleFacturaEntrada detalleFacturaEntrada) {
		this.detalleFacturaEntrada = detalleFacturaEntrada;
	}
	
	public ReciboEntrada getReciboEntrada() {
		return this.reciboEntrada;
	}

	public void setReciboEntrada(ReciboEntrada reciboEntrada) {
		this.reciboEntrada = reciboEntrada;
	}
	
	public CuentasPorCobrar getCuentasPorCobrar() {
		return this.cuentasPorCobrar;
	}

	public void setCuentasPorCobrar(CuentasPorCobrar cuentasPorCobrar) {
		this.cuentasPorCobrar = cuentasPorCobrar;
	}
	
	public String toString(){
		String factura;
		factura  = "id factura -> " + facturas_entrada_id + "\n";
		factura += "id empleado -> " + facturas_entrada_id_empleado + "\n";
		factura += "id estudiante -> " + facturas_entrada_id_estudiante + "\n";
		factura += "nombre -> " + facturas_entrada_nombre + "\n";
		factura += "direccion -> " + facturas_entrada_direccion + "\n";
		factura += "telefono -> " + facturas_entrada_telefono + "\n";
		factura += "metodo de pago -> " + facturas_entrada_metodo_de_pago + "\n";
		factura += "total -> " + facturas_entrada_total + "\n";
		return factura;
		
	}

}