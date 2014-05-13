package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the facturas_salida database table.
 * 
 */
@Entity
@Table(name="facturas_salida")
public class FacturaSalida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="facturas_salida_id")
	private String facturas_salida_id;

	@Column(name="facturas_salida_id_empleado")
	private String facturas_salida_id_empleado;

	@Column(name="facturas_salida_id_profesor")
	private String facturas_salida_id_profesor;

	@Column(name="facturas_salida_nombre")
	private String facturas_salida_nombre;

	@Column(name="facturas_salida_direccion")
	private String facturas_salida_direccion;

	@Column(name="facturas_salida_telefono")
	private String facturas_salida_telefono;

	@Column(name="facturas_salida_metodo_de_pago")
	private String facturas_salida_metodo_de_pago;

	@Column(name="facturas_salida_total")
	private Float facturas_salida_total;



	//bi-directional one-to-one association to Estudiante
	@OneToOne
	@JoinColumn(name="facturas_salida_id_estudiante", referencedColumnName="personas_id", insertable = false, updatable = false)
	private Estudiante estudiante;
	
	@OneToOne
	@JoinColumn(name="facturas_salida_id_empleado", referencedColumnName="personas_id", insertable = false, updatable = false)
	private Empleado empleados;

	@OneToOne(mappedBy="facturaSalida", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	private DetalleFacturaSalida detalleFacturaSalida;
	
	@OneToOne(mappedBy="facturaSalida", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	private ReciboSalida reciboSalida;
	
	@OneToOne(mappedBy="facturaSalida", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	private CuentasPorPagar cuentasPorPagar;
	
	
	
	public FacturaSalida() {
	}

	public String getFacturas_salida_id() {
		return this.facturas_salida_id;
	}

	public void setFacturas_salida_id(String facturas_salida_id) {
		this.facturas_salida_id = facturas_salida_id;
	}
	
	public String getFacturas_salida_id_empleado() {
		return this.facturas_salida_id_empleado;
	}

	public void setFacturas_salida_id_empleado(String facturas_salida_id_empleado) {
		this.facturas_salida_id_empleado = facturas_salida_id_empleado;
	}
	
	public String getFacturas_salida_id_profesor() {
		return this.facturas_salida_id_profesor;
	}

	public void setFacturas_salida_id_profesor(String facturas_salida_id_profesor) {
		this.facturas_salida_id_profesor = facturas_salida_id_profesor;
	}
	
	public String getFacturas_salida_nombre() {
		return this.facturas_salida_nombre;
	}

	public void setFacturas_salida_nombre(String facturas_salida_nombre) {
		this.facturas_salida_nombre = facturas_salida_nombre;
	}
	
	public String getFacturas_salida_direccion() {
		return this.facturas_salida_direccion;
	}

	public void setFacturas_salida_direccion(String facturas_salida_direccion) {
		this.facturas_salida_direccion = facturas_salida_direccion;
	}
	
	public String getFacturas_salida_telefono() {
		return this.facturas_salida_telefono;
	}

	public void setFacturas_salida_telefono(String facturas_salida_telefono) {
		this.facturas_salida_telefono = facturas_salida_telefono;
	}
	
	public String getFacturas_salida_metodo_de_pago() {
		return this.facturas_salida_metodo_de_pago;
	}

	public void setFacturas_salida_metodo_de_pago(String facturas_salida_metodo_de_pago) {
		this.facturas_salida_metodo_de_pago = facturas_salida_metodo_de_pago;
	}
	
	public Float getFacturas_salida_total() {
		return this.facturas_salida_total;
	}

	public void setfacturas_salida_total(Float facturas_salida_total) {
		this.facturas_salida_total = facturas_salida_total;
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
	
	public DetalleFacturaSalida getDetalleFacturaSalida() {
		return this.detalleFacturaSalida;
	}

	public void setDetalleFacturaSalida(DetalleFacturaSalida detalleFacturaSalida) {
		this.detalleFacturaSalida = detalleFacturaSalida;
	}
	
	public ReciboSalida getReciboSalida() {
		return this.reciboSalida;
	}

	public void setReciboSalida(ReciboSalida reciboSalida) {
		this.reciboSalida = reciboSalida;
	}
	
	public CuentasPorPagar getCuentasPorPagar() {
		return this.cuentasPorPagar;
	}

	public void setCuentasPorPagar(CuentasPorPagar cuentasPorPagar) {
		this.cuentasPorPagar = cuentasPorPagar;
	}
	
	public String toString(){
		String factura;
		factura  = "id factura -> " + facturas_salida_id + "\n";
		factura += "id empleado -> " + facturas_salida_id_empleado + "\n";
		factura += "id profesor -> " + facturas_salida_id_profesor + "\n";
		factura += "nombre -> " + facturas_salida_nombre + "\n";
		factura += "direccion -> " + facturas_salida_direccion + "\n";
		factura += "telefono -> " + facturas_salida_telefono + "\n";
		factura += "metodo de pago -> " + facturas_salida_metodo_de_pago + "\n";
		factura += "total -> " + facturas_salida_total + "\n";
		return factura;
		
	}

}