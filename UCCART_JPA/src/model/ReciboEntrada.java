package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the recibo_entrada database table.
 * 
 */

@Entity
@Table(name="ReciboEntrada")
public class ReciboEntrada implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="reciboEntrada_id")
	private String idReciboEntrada;
	
	@Column(name="reciboEntrada_id_factura_entrada")
	private String idFacturaEntrada;

	@Column(name="reciboEntrada_id_empleado")
	private String idEmpleado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="reciboEntrada_fecha")
	private Date fecha;

	@Column(name="reciboEntrada_descripcion")
	private String descripcion;

	@Column(name="reciboEntrada_saldo_anterior")
	private Float saldoAnterior;

	@Column(name="reciboEntrada_recargo_por_mora")
	private Float recargoPorMora;
	
	@Column(name="reciboEntrada_este_abono")
	private Float esteAbono;
	
	@Column(name="reciboEntrada_saldo_actual")
	private Float saldoActual;
	

	public String getIdReciboEntrada() {
		return this.idReciboEntrada;
	}

	public void setIdReciboEntrada(String idReciboEntrada) {
		this.idReciboEntrada = idReciboEntrada;
	}
	
	public String getIdFacturaEntrada() {
		return this.idFacturaEntrada;
	}

	public void setIdFacturaEntrada(String idFacturaEntrada) {
		this.idFacturaEntrada = idFacturaEntrada;
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
	
	public Float getSaldoAnterior() {
		return this.saldoAnterior;
	}

	public void setSaldoAnterior(Float saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}
	
	public Float getRecargoPorMora() {
		return this.recargoPorMora;
	}

	public void setRecargoPorMora(Float recargoPorMora) {
		this.recargoPorMora = recargoPorMora;
	}
	
	public Float getEsteAbono() {
		return this.esteAbono;
	}

	public void setEsteAbono(Float esteAbono) {
		this.esteAbono = esteAbono;
	}
	
	public Float getSaldoActual() {
		return this.saldoActual;
	}

	public void setSaldoActual(Float saldoActual) {
		this.saldoActual = saldoActual;
	}
	

}
