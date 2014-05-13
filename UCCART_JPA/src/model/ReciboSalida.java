package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the recibo_salida database table.
 * 
 */

@Entity
@Table(name="recibo_salida")
public class ReciboSalida implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="reciboSalida_id")
	private String idReciboSalida;
	
	@Column(name="reciboSalida_id_factura_salida")
	private String idFacturaSalida;

	@Column(name="reciboSalida_id_empleado")
	private String idEmpleado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="reciboSalida_fecha")
	private Date fecha;

	@Column(name="reciboSalida_descripcion")
	private String descripcion;

	@Column(name="reciboSalida_monto")
	private Float saldoActual;
	
	
	
	@OneToOne
	@JoinColumn(name="reciboSalida_id_factura_salida", referencedColumnName="facturas_salida_id", insertable = false, updatable = false)
	private FacturaSalida facturaSalida;
	

	public String getIdReciboSalida() {
		return this.idReciboSalida;
	}

	public void setIdReciboSalida(String idReciboSalida) {
		this.idReciboSalida = idReciboSalida;
	}
	
	public String getIdFacturaSalida() {
		return this.idFacturaSalida;
	}

	public void setIdFacturaSalida(String idFacturaSalida) {
		this.idFacturaSalida = idFacturaSalida;
	}
	
	public String getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getFecha() {
		return this.fecha;
	}

	public void setNumeroLinea(Date fecha) {
		this.fecha = fecha;
	}
	
	
	public Float getSaldoActual() {
		return this.saldoActual;
	}

	public void setSaldoActual(Float saldoActual) {
		this.saldoActual = saldoActual;
	}
	
	public FacturaSalida getFacturaSalida() {
		return this.facturaSalida;
	}

	public void setFacturaSalida(FacturaSalida facturaSalida) {
		this.facturaSalida = facturaSalida;
	}

}
