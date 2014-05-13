package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the facturas_salida database table.
 * 
 */
@Entity
@Table(name="cuentas_por_pagar")
public class CuentasPorPagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cuentaspagar_id")
	private String cuentaspagar_id;

	@Column(name="cuentaspagar_id_factura_salida")
	private String cuentaspagar_id_factura_salida;

	@Column(name="cuentaspagar_saldo")
	private Float cuentaspagar_saldo;

	@OneToOne
	@JoinColumn(name="cuentaspagar_id_factura_salida", referencedColumnName="facturas_salida_id", insertable = false, updatable = false)
	private FacturaSalida facturaSalida;


	
	public CuentasPorPagar() {
	}

	public String getCuentaspagar_id() {
		return this.cuentaspagar_id;
	}

	public void setCuentaspagar_id(String cuentaspagar_id) {
		this.cuentaspagar_id = cuentaspagar_id;
	}
	
	public String getCuentaspagar_id_factura_salida() {
		return this.cuentaspagar_id_factura_salida;
	}

	public void setCuentaspagar_id_factura_salida(String cuentaspagar_id_factura_salida) {
		this.cuentaspagar_id_factura_salida = cuentaspagar_id_factura_salida;
	}
	

	public Float getCuentaspagar_saldo() {
		return this.cuentaspagar_saldo;
	}
	
	public void setCuentaspagar_saldo(Float cuentaspagar_saldo) {
		this.cuentaspagar_saldo = cuentaspagar_saldo;
	}
	
	public FacturaSalida getFacturaSalida() {
		return this.facturaSalida;
	}

	public void setFacturaSalida(FacturaSalida facturaSalida) {
		this.facturaSalida = facturaSalida;
	}

}