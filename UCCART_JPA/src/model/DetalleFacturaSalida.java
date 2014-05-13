package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the facturas_salida database table.
 * 
 */

@Entity
@Table(name="detalles_de_factura_salida")
public class DetalleFacturaSalida implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="detfac_salida_id_detalle_factura")
	private String id_detalle_factura;
	
	@Column(name="detfac_salida_id_factura")
	private String id_facturaSalida;

	@Column(name="detfac_salida_id_arancel")
	private String id_Arancel;

	@Column(name="detfac_salida_descripcion")
	private String descripcion;

	@Column(name="detfac_salida_numero_linea")
	private Integer numero_linea;

	@Column(name="detfac_salida_precio_unitario")
	private Float precio_unitario;

	@Column(name="detfac_salida_descuento")
	private Float descuento;
	
	@Column(name="detfac_salida_descripcion_descuento")
	private String descripcion_descuento;
	
	@Column(name="detfac_salida_total_bruto")
	private Float total_bruto;
	
	@Column(name="detfac_salida_subtotal")
	private Float subtotal;
	
	@Column(name="detfac_salida_cantidad")
	private Integer cantidad;
	
	

	//bi-directional one-to-one association to Estudiante
	@OneToOne
	@JoinColumn(name="detfac_salida_id_factura", referencedColumnName="facturas_salida_id", insertable = false, updatable = false)
	private FacturaSalida facturaSalida;
	
	@OneToOne
	@JoinColumn(name="detfac_salida_id_arancel", referencedColumnName="aranceles_id", insertable = false, updatable = false)
	private Arancel arancel;
	
	
	
	public String getId_detalle_factura() {
		return this.id_detalle_factura;
	}

	public void setId_detalle_factura(String id_detalle_factura) {
		this.id_detalle_factura = id_detalle_factura;
	}
	
	public String getId_facturaSalida() {
		return this.id_facturaSalida;
	}

	public void setId_facturaSalida(String id_facturaSalida) {
		this.id_facturaSalida = id_facturaSalida;
	}
	
	public String getIdArancel() {
		return this.id_Arancel;
	}

	public void setIdArancel(String id_Arancel) {
		this.id_Arancel = id_Arancel;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getNumeroLinea() {
		return this.numero_linea;
	}

	public void setNumeroLinea(Integer numero_linea) {
		this.numero_linea = numero_linea;
	}
	
	public Float getPrecioUnitario() {
		return this.precio_unitario;
	}

	public void setPrecioUnitario(Float precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	
	public Float getDescuento() {
		return this.descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	
	public String getDescripcionDescuento() {
		return this.descripcion_descuento;
	}

	public void setDescripcionDescuento(String descripcion_descuento) {
		this.descripcion_descuento = descripcion_descuento;
	}
	
	public Float getTotalBruto() {
		return this.total_bruto;
	}

	public void setTotalBruto(Float total_bruto) {
		this.total_bruto = total_bruto;
	}
	
	public Float getSubTotal() {
		return this.subtotal;
	}

	public void setSubTotal(Float subtotal) {
		this.subtotal = subtotal;
	}
	
	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public FacturaSalida getFacturaSalida() {
		return this.facturaSalida;
	}

	public void setFacturaSalida(FacturaSalida facturaSalida) {
		this.facturaSalida = facturaSalida;
	}
	
	public Arancel getArancel() {
		return this.arancel;
	}

	public void setArancel(Arancel arancel) {
		this.arancel = arancel;
	}
	
	public String toString(){
		String detalle;
		detalle  = "id detalle -> " + id_detalle_factura + "\n";
		detalle += "id factura -> " + id_facturaSalida + "\n";
		detalle += "id arancel -> " + id_Arancel + "\n";
		detalle += "descripcion -> " + descripcion + "\n";
		detalle += "linea -> " + numero_linea + "\n";
		detalle += "precio -> " + precio_unitario + "\n";
		detalle += "descuento -> " + descuento + "\n";
		detalle += "descripcion del descuento -> " + descripcion_descuento + "\n";
		detalle += "total bruto-> " + total_bruto + "\n";
		detalle += "sub total-> " + subtotal + "\n";
		detalle += "cantidad-> " + cantidad + "\n";
		return detalle;
		
	}
	

}
