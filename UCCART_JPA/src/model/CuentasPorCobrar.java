package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the facturas_entrada database table.
 * 
 */
@Entity
@Table(name="cuentas_por_cobrar")
public class CuentasPorCobrar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cuentascobrar_id")
	private String cuentascobrar_id;

	@Column(name="cuentascobrar_id_factura_entrada")
	private String cuentascobrar_id_factura_entrada;

	@Column(name="cuentascobrar_saldo")
	private Float cuentascobrar_saldo;

	@OneToOne
	@JoinColumn(name="cuentascobrar_id_factura_entrada", referencedColumnName="facturas_entrada_id", insertable = false, updatable = false)
	private FacturaEntrada facturaEntrada;


	
	public CuentasPorCobrar() {
	}

	public String getCuentascobrar_id() {
		return this.cuentascobrar_id;
	}

	public void setCuentascobrar_id(String cuentascobrar_id) {
		this.cuentascobrar_id = cuentascobrar_id;
	}
	
	public String getCuentascobrar_id_factura_entrada() {
		return this.cuentascobrar_id_factura_entrada;
	}

	public void setCuentascobrar_id_factura_entrada(String cuentascobrar_id_factura_entrada) {
		this.cuentascobrar_id_factura_entrada = cuentascobrar_id_factura_entrada;
	}
	

	public Float getCuentascobrar_saldo() {
		return this.cuentascobrar_saldo;
	}
	
	public void setCuentascobrar_saldo(Float cuentascobrar_saldo) {
		this.cuentascobrar_saldo = cuentascobrar_saldo;
	}
	
	public FacturaEntrada getFacturaEntrada() {
		return this.facturaEntrada;
	}

	public void setFacturaEntrada(FacturaEntrada facturaEntrada) {
		this.facturaEntrada = facturaEntrada;
	}

}