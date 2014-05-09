package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the facturas_entrada database table.
 * 
 */

@Entity
@Table(name="detalles_de_factura_entrada")
public class DetalleFacturaEntrada implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="detfac_entrada_id_detalle_factura")
	private String id_detalle_factura;
	
	@Column(name="detfac_entrada_id_factura")
	private String id_facturaEntrada;

	@Column(name="detfac_entrada_id_arancel")
	private String id_Arancel;

	@Column(name="detfac_entrada_descripcion")
	private String descripcion;

	@Column(name="detfac_entrada_numero_linea")
	private Integer numero_linea;

	@Column(name="detfac_entrada_precio_unitario")
	private Float precio_unitario;

	@Column(name="detfac_entrada_descripcion_descuento")
	private String descripcion_descuento;
	
	@Column(name="detfac_entrada_total_bruto")
	private Float total_bruto;
	
	@Column(name="detfac_entrada_subtotal")
	private Float subtotal;
	
	@Column(name="detfac_entrada_cantidad")
	private Integer cantidad;
	
	

	//bi-directional one-to-one association to Estudiante
	@OneToOne
	@JoinColumn(name="detfac_entrada_id_factura", referencedColumnName="facturas_entrada_id", insertable = false, updatable = false)
	private FacturaEntrada facturaEntrada;
	
	@OneToOne
	@JoinColumn(name="detfac_entrada_id_arancel", referencedColumnName="aranceles_id", insertable = false, updatable = false)
	private Arancel arancel;
	
	
	
	public String getId_detalle_factura() {
		return this.id_detalle_factura;
	}

	public void setId_detalle_factura(String id_detalle_factura) {
		this.id_detalle_factura = id_detalle_factura;
	}
	
	public String getId_facturaEntrada() {
		return this.id_facturaEntrada;
	}

	public void setId_facturaEntrada(String id_facturaEntrada) {
		this.id_facturaEntrada = id_facturaEntrada;
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
	
	public FacturaEntrada getFacturaEntrada() {
		return this.facturaEntrada;
	}

	public void setFacturaEntrada(FacturaEntrada facturaEntrada) {
		this.facturaEntrada = facturaEntrada;
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
		detalle += "id factura -> " + id_facturaEntrada + "\n";
		detalle += "id arancel -> " + id_Arancel + "\n";
		detalle += "descripcion -> " + descripcion + "\n";
		detalle += "linea -> " + numero_linea + "\n";
		detalle += "precio -> " + precio_unitario + "\n";
		detalle += "descripcion del descuento -> " + descripcion_descuento + "\n";
		detalle += "total bruto-> " + total_bruto + "\n";
		detalle += "sub total-> " + subtotal + "\n";
		detalle += "cantidad-> " + cantidad + "\n";
		return detalle;
		
	}
	

}
