package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-06T01:37:28.085-0600")
@StaticMetamodel(DetalleFacturaEntrada.class)
public class DetalleFacturaEntrada_ {
	public static volatile SingularAttribute<DetalleFacturaEntrada, String> id_detalle_factura;
	public static volatile SingularAttribute<DetalleFacturaEntrada, String> id_facturaEntrada;
	public static volatile SingularAttribute<DetalleFacturaEntrada, String> id_Arancel;
	public static volatile SingularAttribute<DetalleFacturaEntrada, String> descripcion;
	public static volatile SingularAttribute<DetalleFacturaEntrada, Integer> numero_linea;
	public static volatile SingularAttribute<DetalleFacturaEntrada, Float> precio_unitario;
	public static volatile SingularAttribute<DetalleFacturaEntrada, String> descripcion_descuento;
	public static volatile SingularAttribute<DetalleFacturaEntrada, Float> total_bruto;
	public static volatile SingularAttribute<DetalleFacturaEntrada, Float> subtotal;
	public static volatile SingularAttribute<DetalleFacturaEntrada, Integer> cantidad;
	public static volatile SingularAttribute<DetalleFacturaEntrada, FacturaEntrada> facturaEntrada;
	public static volatile SingularAttribute<DetalleFacturaEntrada, Arancel> arancel;
}
